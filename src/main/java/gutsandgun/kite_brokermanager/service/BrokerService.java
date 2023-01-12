package gutsandgun.kite_brokermanager.service;

import gutsandgun.kite_brokermanager.dto.BrokerDto;

import java.util.List;

public interface BrokerService {

    List<BrokerDto> selectBrokerList();  // 브로커 리스트 조회
}
