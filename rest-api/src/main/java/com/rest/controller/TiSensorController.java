package com.rest.controller;

import com.rest.config.Constants;
import com.rest.service.TiSensorService;
import com.rest.service.TiSensorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rest.model.TiSensorDatapoint;

/**
 * Created by uday on 3/21/16.
 */

@RestController
public class TiSensorController {

    @Autowired
    TiSensorService tiSensorServiceImpl;

    private static Logger logger = LoggerFactory.getLogger(
            TiSensorController.class);;


    @RequestMapping(value = "/datapoint", method = RequestMethod.POST,
            consumes = {"application/json"})
    public ResponseEntity<Void> checkAndInsertDataPoint(
            @RequestBody TiSensorDatapoint datapoint){

        // check if tiSensorId is registered
        if(!tiSensorServiceImpl.isRegisteredIdAttachUserId(datapoint)){
            logger.info("Unregistered TiSensorId is received!");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        tiSensorServiceImpl.save(datapoint);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Void> sayHello(){
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
