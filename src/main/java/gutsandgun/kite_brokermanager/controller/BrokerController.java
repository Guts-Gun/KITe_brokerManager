package gutsandgun.kite_brokermanager.controller;


import gutsandgun.kite_brokermanager.dto.BrokerDto;
import gutsandgun.kite_brokermanager.service.BrokerService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="broker")
@Log4j2
public class BrokerController {

    @Autowired
    BrokerService brokerService;


    @GetMapping(value = "/list")
    public ResponseEntity<List<BrokerDto>> selectBrokerList() {
        return new ResponseEntity<>(brokerService.selectBrokerList(), HttpStatus.OK);
    }

}
