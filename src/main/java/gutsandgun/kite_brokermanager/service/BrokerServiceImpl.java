package gutsandgun.kite_brokermanager.service;


import gutsandgun.kite_brokermanager.dto.BrokerDto;
import gutsandgun.kite_brokermanager.entity.read.Broker;
import gutsandgun.kite_brokermanager.repository.read.ReadBrokerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrokerServiceImpl implements BrokerService{

    @Autowired
    ReadBrokerRepository readBrokerRepository;

    @Autowired
    private final ModelMapper mapper;


    public List<BrokerDto> selectBrokerList() {

        List<BrokerDto> brokerDtoList = new ArrayList<>();
        List<Broker> brokerList = readBrokerRepository.findAll();

        brokerList.forEach(survey -> {
            BrokerDto brokerDto = mapper.map(survey, BrokerDto.class);
            brokerDtoList.add(brokerDto);
        });

        return brokerDtoList;
    }

}
