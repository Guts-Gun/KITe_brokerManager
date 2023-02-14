package gutsandgun.kite_brokermanager.dto;

import gutsandgun.kite_brokermanager.type.FailReason;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link gutsandgun.kite_brokermanager.entity.read.ResultTxTransfer} entity
 */
@Data
public class ResultTxTransferDto implements Serializable {
	private final Long resultTxId;
	private final Long brokerId;
	private final Boolean success;
	private final FailReason failReason;
	private final Long sendTime;
	private final Long completeTime;
	private final Long logTime;

}