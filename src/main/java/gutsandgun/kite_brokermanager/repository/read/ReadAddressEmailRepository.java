package gutsandgun.kite_brokermanager.repository.read;

import gutsandgun.kite_brokermanager.entity.read.AddressEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadAddressEmailRepository extends JpaRepository<AddressEmail, Long> {
}