package com.rest.repository;

import com.rest.model.TiSensorDatapoint;
import org.springframework.stereotype.Service;

/**
 * Created by uday on 4/3/16.
 */

public interface TiSensorDatapointRepository {
    void saveDatapoint(TiSensorDatapoint datapoint);
}
