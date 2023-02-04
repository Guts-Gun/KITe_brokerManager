package gutsandgun.kite_brokermanager.service;

import gutsandgun.kite_brokermanager.dto.BrokerDto;
import gutsandgun.kite_brokermanager.dto.BrokerInfoDto;

import java.util.List;

public interface BrokerService {

    List<BrokerDto> selectBrokerList();  // 브로커 리스트 조회

    long addBroker(BrokerInfoDto brokerInfoDto);
}
