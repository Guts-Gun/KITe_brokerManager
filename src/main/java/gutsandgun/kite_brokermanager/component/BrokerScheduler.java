package gutsandgun.kite_brokermanager.component;

import gutsandgun.kite_brokermanager.dto.ResultTxTransferDto;
import gutsandgun.kite_brokermanager.entity.write.Broker;
import gutsandgun.kite_brokermanager.repository.read.ReadResultTxTransferRepository;
import gutsandgun.kite_brokermanager.repository.write.WriteBrokerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BrokerScheduler {
	private final ReadResultTxTransferRepository resultTxTransferRepository;
	private final WriteBrokerRepository brokerRepository;

	@Scheduled(cron = "0/10 * * * * *")
	public void brokerLatencyUpdate() {
		System.out.println("지연율 체크");
		List<Broker> brokerList = getBrokerList();

		for (Broker broker : brokerList) {
			float avg = getBrokerRecentLatency(broker.getId());
			broker.setLatency(avg);
		}
		System.out.println(brokerList.stream()
				.map(broker -> (broker.getName() + " : " + broker.getLatency()))
				.collect(Collectors.toList()));
		brokerRepository.saveAllAndFlush(brokerList);
	}

	@Scheduled(cron = "0/30 * * * * *")
	public void brokerFailureRateUpdate() {
		System.out.println("실패율 체크");
		List<Broker> brokerList = getBrokerList();

		for (Broker broker : brokerList) {
			float avg = getBrokerFailureRate(broker.getId());
			broker.setFailureRate(avg);
		}
		System.out.println(brokerList.stream()
				.map(broker -> (broker.getName() + " : " + broker.getFailureRate()))
				.collect(Collectors.toList()));
		brokerRepository.saveAllAndFlush(brokerList);
	}


	public List<Broker> getBrokerList() {
		List<Broker> brokerList = brokerRepository.findAll();
		return brokerList;
	}

	public Float getBrokerRecentLatency(long brokerId) {
		List<ResultTxTransferDto> resultTxTransferDtoList = resultTxTransferRepository.findTop5ByBrokerIdAndSuccessNotNullOrderByIdDesc(brokerId);

		float sum = 0;
		for (ResultTxTransferDto result : resultTxTransferDtoList) {
			sum += (result.getCompleteTime() - result.getSendTime());
		}
		float avg = resultTxTransferDtoList.size() > 0 ? sum / resultTxTransferDtoList.size() : 0;

		return avg;
	}

	private float getBrokerFailureRate(Long brokerId) {
		List<ResultTxTransferDto> resultTxTransferDtoList = resultTxTransferRepository.findTop100ByBrokerIdAndSuccessNotNullOrderByIdDesc(brokerId);

		float sum = 0;
		for (ResultTxTransferDto result : resultTxTransferDtoList) {
			if (!result.getSuccess())
				sum++;
		}
		float avg = resultTxTransferDtoList.size() > 0 ? sum / resultTxTransferDtoList.size() * 100 : 0;

		return avg;
	}

}
