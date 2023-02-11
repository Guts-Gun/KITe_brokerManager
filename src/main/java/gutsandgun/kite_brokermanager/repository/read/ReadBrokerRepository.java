package gutsandgun.kite_brokermanager.repository.read;

import gutsandgun.kite_brokermanager.entity.read.Broker;
import gutsandgun.kite_brokermanager.type.SendingType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadBrokerRepository extends JpaRepository<Broker, Long> {

    List<Broker> findBySendingType(SendingType sendingType);
}
