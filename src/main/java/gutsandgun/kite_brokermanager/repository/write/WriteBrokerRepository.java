package gutsandgun.kite_brokermanager.repository.write;

import gutsandgun.kite_brokermanager.entity.write.Broker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriteBrokerRepository extends JpaRepository<Broker, Long> {
}
