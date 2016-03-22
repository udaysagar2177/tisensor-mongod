package com.rest.service;

import com.rest.model.TiSensorDatapoint;
import com.rest.model.TiSensorDatapointWithUserID;
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

    public String getUserId(){
        return "user1";
    }

    public TiSensorDatapointWithUserID extendDataPoint(
            String userId,
            TiSensorDatapoint datapoint){
        TiSensorDatapointWithUserID newDatapoint = new TiSensorDatapointWithUserID();
        newDatapoint.setUserId(userId);
        newDatapoint.setTemperature(datapoint.getTemperature());
        newDatapoint.setLight(datapoint.getLight());
        newDatapoint.setTiSensorId(datapoint.getTiSensorId());
        newDatapoint.setTimestamp(datapoint.getTimestamp());
        return newDatapoint;
    }

    public void save(TiSensorDatapoint datapoint){
        String userId = getUserId();
        extendDataPoint(userId, datapoint);
        // save Datapoint
    }
}
