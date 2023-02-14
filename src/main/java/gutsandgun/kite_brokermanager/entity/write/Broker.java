package gutsandgun.kite_brokermanager.entity.write;

import gutsandgun.kite_brokermanager.entity.BaseTimeEntity;
import gutsandgun.kite_brokermanager.type.SendingType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Where(clause = "is_deleted = false")
@SQLDelete(sql = "UPDATE broker SET is_deleted=true WHERE id = ?")
public class Broker extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * 중계사 이름
	 */
	@Comment("중계사 이름")
	private String name;

	/**
	 * 중계사 ip
	 */
	@Comment("중계사 ip")
	private String ip;

	/**
	 * 중계사 컬러 hex
	 */
	@Comment("중계사 색")
	@Builder.Default
	private String color = "#FF0000";

	/**
	 * 발송 메시지 타입
	 */
	@Comment("발송 메시지 타입")
	private SendingType sendingType;


	/**
	 * 중계사 가격
	 */
	@Comment("중계사 가격")
	private Float price;

	/**
	 * 중계사 응답속도
	 */
	@Comment("중계사 응답속도")
	private Float latency;

	/**
	 * 중계사 실패율
	 */
	@Comment("중계사 실패율")
	private Float failureRate;

	@ColumnDefault("false")
	@Builder.Default
	private Boolean isDeleted = false;

	@Builder
	public Broker(String name, String ip, SendingType sendingType, String color, Float price) {
		this.name = name;
		this.ip = ip;
		this.sendingType = sendingType;
		this.color = color;
		this.price = price;
	}
}
