package gutsandgun.kite_brokermanager.repository.read;

import gutsandgun.kite_brokermanager.dto.ResultTxTransferDto;
import gutsandgun.kite_brokermanager.entity.read.ResultTxTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadResultTxTransferRepository extends JpaRepository<ResultTxTransfer, Long> {

	/**
	 * get finished message tx by broker id
	 *
	 * @param brokerId
	 * @return List<ResultTxTransferDto>
	 */
	List<ResultTxTransferDto> findTop5ByBrokerIdAndSuccessNotNullOrderByIdDesc(Long brokerId);

//	List<ResultTxTransferDto> findTop5ByBrokerIdAndSendTimeNotNullAndCompleteTimeNotNullOrderByIdDesc(Long brokerId);


	/**
	 * get finished message tx by broker id for fail rate
	 *
	 * @param brokerId
	 * @return List<ResultTxTransferDto>
	 */
	List<ResultTxTransferDto> findTop100ByBrokerIdAndSuccessNotNullOrderByIdDesc(Long brokerId);

//	List<ResultTxTransferDto> findTop100ByBrokerIdAndCompleteTimeNotNullOrderByIdDesc(Long brokerId);


}