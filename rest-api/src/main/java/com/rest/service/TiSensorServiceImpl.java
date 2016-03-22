package com.rest.service;

import com.rest.model.TiSensorDatapoint;
import org.springframework.stereotype.Service;

/**
 * Created by uday on 3/21/16.
 */
@Service("userService")
public class TiSensorServiceImpl implements TiSensorService {
    public boolean isRegisteredId(String tiSensorId){
        System.out.println(tiSensorId);
        if(tiSensorId.compareTo("aaa") == 0){
            return true;
        }
        return false;
    }

    public String getUserId(TiSensorDatapoint datapoint){
        // Get the userId from Database
        return "user1";
    }

    public void save(TiSensorDatapoint datapoint){
        datapoint.setUserId(getUserId(datapoint));
        // save Datapoint
    }
}
