package gutsandgun.kite_brokermanager.controller;


import gutsandgun.kite_brokermanager.dto.BrokerDto;
import gutsandgun.kite_brokermanager.dto.BrokerInfoDto;
import gutsandgun.kite_brokermanager.service.BrokerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/brokermanager")
@Log4j2
public class BrokerController {

    @Autowired
    BrokerService brokerService;

    @PostMapping("/broker/add")
    public long addBroker(@RequestBody BrokerInfoDto brokerInfoDto){
        return brokerService.addBroker(brokerInfoDto);
    }

    @GetMapping(value = "/broker/list")
    public ResponseEntity<List<BrokerDto>> selectBrokerList() {
        return new ResponseEntity<>(brokerService.selectBrokerList(), HttpStatus.OK);
    }

}
