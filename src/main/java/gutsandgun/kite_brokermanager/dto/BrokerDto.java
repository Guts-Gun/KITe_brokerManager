package gutsandgun.kite_brokermanager.dto;

import gutsandgun.kite_brokermanager.type.SendingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link gutsandgun.kite_brokermanager.entity.write.Broker} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrokerDto {

	private Long id;

	private String name;

	private String ip;

	private SendingType sendingType;

	private Float price;

	private Float latency;

	private Float failureRate;

	private String color;

}
