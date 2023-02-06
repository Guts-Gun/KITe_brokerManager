package gutsandgun.kite_brokermanager.component;

import gutsandgun.kite_brokermanager.dto.ResultTxDto;
import gutsandgun.kite_brokermanager.entity.write.Broker;
import gutsandgun.kite_brokermanager.repository.read.ReadResultTxRepository;
import gutsandgun.kite_brokermanager.repository.write.WriteBrokerRepository;
import gutsandgun.kite_brokermanager.type.SendingType;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BrokerScheduler {
	private final ReadResultTxRepository resultTxRepository;
	private final WriteBrokerRepository brokerRepository;

	@Scheduled(cron = "0/10 * * * * *")
	public void brokerLatencyUpdate() {
		List<Broker> brokerList = getBrokerList();

		for (Broker broker : brokerList) {
			float avg = getBrokerRecentLatency(broker.getId());
			broker.setLatency(avg);
		}
		brokerRepository.saveAllAndFlush(brokerList);
	}

	public List<Broker> getBrokerList() {
		List<Broker> brokerList = brokerRepository.findAll();
		return brokerList;
	}

	public Float getBrokerRecentLatency(long brokerId) {
		List<ResultTxDto> resultTxDtoList = resultTxRepository.findTop5ByBrokerIdAndSendingTypeAndSendTimeNotNullAndCompleteTimeNotNullOrderByIdDesc(brokerId, SendingType.SMS);

		long sum = 0;
		for (ResultTxDto result : resultTxDtoList) {
			sum += (result.getCompleteTime() - result.getSendTime());
		}
		float avg = resultTxDtoList.size() > 0 ? sum / resultTxDtoList.size() : 0;

		return avg;
	}

}
