package gutsandgun.kite_brokermanager.dto;

import gutsandgun.kite_brokermanager.entity.write.Broker;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link gutsandgun.kite_brokermanager.entity.write.Broker} entity
 */
@Data
public class BrokerInfoDto implements Serializable {
	private final String name;
	private final String ip;
	private final String color;
	private final Float price;



	public BrokerInfoDto(String name, String ip, String color, Float price) {
		this.name = name;
		this.ip = ip;
		this.color = color;
		this.price = price;
	}

	public Broker toEntity() {
		return Broker.builder()
				.name(name)
				.ip(ip)
				.color(color)
				.price(price)
				.build();
	}
}