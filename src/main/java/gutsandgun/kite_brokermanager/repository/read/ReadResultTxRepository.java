package gutsandgun.kite_brokermanager.repository.read;

import gutsandgun.kite_brokermanager.dto.ResultTxDto;
import gutsandgun.kite_brokermanager.entity.read.ResultTx;
import gutsandgun.kite_brokermanager.type.SendingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadResultTxRepository extends JpaRepository<ResultTx, Long> {

	/**
	 * get finished message tx by broker id
	 *
	 * @param brokerId
	 * @return List<ResultTxDto>
	 */
	List<ResultTxDto> findTop5ByBrokerIdAndSendTimeNotNullAndCompleteTimeNotNullOrderByIdDesc(Long brokerId);

	/**
	 * get finished message tx by broker id and sending type for check latency
	 *
	 * @param brokerId
	 * @param sendingType
	 * @return List<ResultTxDto>
	 */
	List<ResultTxDto> findTop5ByBrokerIdAndSendingTypeAndSendTimeNotNullAndCompleteTimeNotNullOrderByIdDesc(Long brokerId, SendingType sendingType);

	/**
	 * get finished message tx by broker id for fail rate
	 *
	 * @param brokerId
	 * @return
	 */
	List<ResultTxDto> findTop100ByBrokerIdAndCompleteTimeNotNullOrderByIdDesc(Long brokerId);


	/**
	 * get finished message tx by broker id and sending type for fail rate
	 *
	 * @param brokerId
	 * @param sendingType
	 * @return
	 */
	List<ResultTxDto> findTop100ByBrokerIdAndSendingTypeAndCompleteTimeNotNullOrderByIdDesc(Long brokerId, SendingType sendingType);


}
