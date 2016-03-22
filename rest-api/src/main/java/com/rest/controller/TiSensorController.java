package com.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rest.model.TiSensorDatapoint;
import com.rest.service.TiSensorService;

/**
 * Created by uday on 3/21/16.
 */

@RestController
public class TiSensorController {

    @Autowired
    TiSensorService tiSensorService;
    private Logger logger;

    public TiSensorController(){
        logger = LoggerFactory.getLogger(TiSensorController.class);
    }

    @RequestMapping(value = "/datapoint", method = RequestMethod.POST,
            consumes = {"application/json"})
    public ResponseEntity<Void> checkAndInsertDataPoint(
            @RequestBody TiSensorDatapoint datapoint){

        // check if tiSensorId is registered
        if(!tiSensorService.isRegisteredId(datapoint.getTiSensorId())){
            logger.info("Unregistered TiSensorId is received!");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        tiSensorService.save(datapoint);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Void> sayHello(){
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
