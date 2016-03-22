package com.rest.service;

import com.rest.model.TiSensorDatapoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by uday on 3/21/16.
 */
@Service("userService")
public class TiSensorServiceImpl implements TiSensorService {
    private Logger logger;

    public TiSensorServiceImpl(){
        logger = LoggerFactory.getLogger(TiSensorServiceImpl.class);
    }

    public boolean isRegisteredId(String tiSensorId){
        // for simulated TiSensors, TODO: must be registered later
        if(tiSensorId.startsWith("SIMULATED_")){
            logger.info("Datapoint received from "+tiSensorId);
            return true;
        }
        // TODO: check if given tiSensorId is registered by any user
        return false;
    }

    public String getUserId(TiSensorDatapoint datapoint){
        // TODO: Get the userId from Database
        return "user1";
    }

    public void save(TiSensorDatapoint datapoint){
        datapoint.setUserId(getUserId(datapoint));
        // TODO: save Datapoint to Database
    }
}
