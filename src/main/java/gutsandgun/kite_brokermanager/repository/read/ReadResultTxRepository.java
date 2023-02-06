package gutsandgun.kite_brokermanager.repository.read;

import gutsandgun.kite_brokermanager.dto.ResultTxDto;
import gutsandgun.kite_brokermanager.entity.read.ResultTx;
import gutsandgun.kite_brokermanager.type.SendingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadResultTxRepository extends JpaRepository<ResultTx, Long> {

	List<ResultTxDto> findTop5ByBrokerIdAndSendTimeNotNullAndCompleteTimeNotNullOrderByIdDesc(Long brokerId);

	List<ResultTxDto> findTop5ByBrokerIdAndSendingTypeAndSendTimeNotNullAndCompleteTimeNotNullOrderByIdDesc(Long brokerId, SendingType sendingType);


}
