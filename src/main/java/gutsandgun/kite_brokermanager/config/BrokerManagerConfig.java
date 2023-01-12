package gutsandgun.kite_brokermanager.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrokerManagerConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
