package com.rest.repository;


import com.rest.model.TiSensorDatapoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by uday on 3/27/16.
 */

@Service
@Repository("TiSensorDatapointRepository")
public class MongoTiSensorDatapointRepository implements
        TiSensorDatapointRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void saveDatapoint(TiSensorDatapoint datapoint) {
        mongoTemplate.save(datapoint);
    }
}
