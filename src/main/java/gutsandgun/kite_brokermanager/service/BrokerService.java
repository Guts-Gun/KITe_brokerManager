package gutsandgun.kite_brokermanager.service;

import gutsandgun.kite_brokermanager.dto.BrokerDto;
import gutsandgun.kite_brokermanager.dto.BrokerInfoDto;
import gutsandgun.kite_brokermanager.type.SendingType;

import java.util.List;

public interface BrokerService {

    List<BrokerDto> selectBrokerList();  // 브로커 리스트 조회

    List<BrokerDto> selectBrokerTypeList(SendingType sendingType);

    long addBroker(BrokerInfoDto brokerInfoDto);
}
