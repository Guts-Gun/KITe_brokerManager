package gutsandgun.kite_brokermanager.dto;

import gutsandgun.kite_brokermanager.type.FailReason;
import gutsandgun.kite_brokermanager.type.SendingType;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link gutsandgun.kite_brokermanager.entity.read.ResultTx} entity
 */
@Data
public class ResultTxDto implements Serializable {
	private final Long id;
	private final String userId;
	private final Long resultSendingId;
	private final Long txId;
	private final Long brokerId;
	private final SendingType sendingType;
	private final String sender;
	private final String receiver;
	private final Boolean success;
	private final FailReason failReason;
	private final String title;
	private final String mediaLink;
	private final String content;
	private final Long inputTime;
	private final Long scheduleTime;
	private final Long startTime;
	private final Long sendTime;
	private final Long completeTime;
	private final Long logTime;
}