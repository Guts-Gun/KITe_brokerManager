package gutsandgun.kite_brokermanager.repository.read;

import gutsandgun.kite_brokermanager.entity.read.SendingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadSendingScheduleRepository extends JpaRepository<SendingSchedule, Long> {
}