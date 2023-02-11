package gutsandgun.kite_brokermanager.controller;


import gutsandgun.kite_brokermanager.dto.BrokerDto;
import gutsandgun.kite_brokermanager.dto.BrokerInfoDto;
import gutsandgun.kite_brokermanager.service.BrokerService;
import gutsandgun.kite_brokermanager.type.SendingType;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping(value = "/broker/typeList")
    public ResponseEntity<List<BrokerDto>> selectBrokerTypeList(@RequestParam SendingType sendingType) {

        List<BrokerDto> brokerDtoList = new ArrayList<>();
        if(sendingType.equals(SendingType.MMS) || sendingType.equals(SendingType.SMS)){
            brokerDtoList = brokerService.selectBrokerTypeList(SendingType.SMS);
        }else if(sendingType.equals(SendingType.EMAIL)){
            brokerDtoList = brokerService.selectBrokerTypeList(SendingType.EMAIL);
        }
        return new ResponseEntity<>(brokerDtoList, HttpStatus.OK);
    }

}
