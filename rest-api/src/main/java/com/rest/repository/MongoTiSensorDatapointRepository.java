package com.rest.repository;


import com.rest.model.TiSensorDatapoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger
            (MongoTiSensorDatapointRepository.class);
    @Autowired
    MongoTemplate mongoTemplate;

    public void saveDatapoint(TiSensorDatapoint datapoint) {
        logger.debug("Saving datapoint " + datapoint.toString() + " to " +
                datapoint.getCollectionName());
        mongoTemplate.save(datapoint, datapoint.getCollectionName());
    }
}
