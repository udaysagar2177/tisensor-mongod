package com.rest.controller;

import com.rest.model.TiSensorDatapoint;
import com.rest.model.TiSensorHumidity;
import com.rest.model.TiSensorLight;
import com.rest.model.TiSensorTemperature;
import com.rest.service.TiSensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by uday on 3/21/16.
 */

@RestController
public class TiSensorController {

    private TiSensorService tiSensorServiceImpl;

    private static Logger logger = LoggerFactory.getLogger(
            TiSensorController.class);

    @Autowired
    public TiSensorController(TiSensorService tiSensorServiceImpl){
        this.tiSensorServiceImpl = tiSensorServiceImpl;
    }

    @RequestMapping(value = "/tisensor/temperature",
            method = RequestMethod.POST,
            consumes = {"application/json"})
    public ResponseEntity<Void> checkAndInsertTemperature(
            @RequestBody TiSensorTemperature temperature){
        logger.debug("Received temperature datapoint "+temperature.toString()
                +" from "+temperature.getUserId());
        return processDatapoint(temperature);
    }

    @RequestMapping(value = "/tisensor/light",
            method = RequestMethod.POST,
            consumes = {"application/json"})
    public ResponseEntity<Void> checkAndInsertLight(
            @RequestBody TiSensorLight light){
        logger.debug("Received light datapoint "+light.toString()+" from "+light
                .getUserId());
        return processDatapoint(light);
    }

    @RequestMapping(value = "/tisensor/humidity",
            method = RequestMethod.POST,
            consumes = {"application/json"})
    public ResponseEntity<Void> checkAndInsertHumidity(
            @RequestBody TiSensorHumidity humidity){
        logger.debug("Received humidity datapoint "+humidity.toString()+" " +
                "from "+humidity.getUserId());
        return processDatapoint(humidity);
    }

    private ResponseEntity<Void> processDatapoint(TiSensorDatapoint datapoint){
        // check if tiSensorId is registered
        if(!tiSensorServiceImpl.isRegisteredIdAttachUserId(datapoint)){
            logger.info("Received datapoint from unregistered tiSensor, " +
                    "dropping it!");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        tiSensorServiceImpl.save(datapoint);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
