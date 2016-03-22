package com.rest.service;

import com.rest.model.TiSensorDatapoint;

/**
 * Created by uday on 3/21/16.
 */
public interface TiSensorService {
    boolean isRegisteredId(String tiSensorId);
    String getUserId(TiSensorDatapoint datapoint);
    void save(TiSensorDatapoint datapoint);
}
