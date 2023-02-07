package gutsandgun.kite_brokermanager.service;


import gutsandgun.kite_brokermanager.dto.BrokerDto;
import gutsandgun.kite_brokermanager.dto.BrokerInfoDto;
import gutsandgun.kite_brokermanager.entity.write.Broker;
import gutsandgun.kite_brokermanager.repository.write.WriteBrokerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrokerServiceImpl implements BrokerService {

	@Autowired
	WriteBrokerRepository writeBrokerRepository;


	@Autowired
	private final ModelMapper mapper;


	public List<BrokerDto> selectBrokerList() {

		List<BrokerDto> brokerDtoList = new ArrayList<>();
		List<Broker> brokerList = writeBrokerRepository.findAll();

		brokerList.forEach(broker -> {
			BrokerDto brokerDto = mapper.map(broker, BrokerDto.class);
			brokerDtoList.add(brokerDto);
		});

		return brokerDtoList;
	}

	@Override
	public long addBroker(BrokerInfoDto brokerInfoDto) {
		Broker broker;
		broker = writeBrokerRepository.save(brokerInfoDto.toEntity());
		return broker.getId();
	}

}
