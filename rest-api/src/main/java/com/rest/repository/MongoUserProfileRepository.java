package com.rest.repository;

import com.rest.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by uday on 4/3/16.
 */

@Repository("MongoUserProfileRepository")
public class MongoUserProfileRepository implements UserProfileRepository {
    private  static Logger logger = LoggerFactory.getLogger(
            MongoUserProfileRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;

    public void createSimulationUser(UserProfile userProfile) {
        mongoTemplate.save(userProfile, "userProfile");
    }

    public String getUserId(String tiSensorId) {
        List<UserProfile> userProfile = null;
        try {
            userProfile = mongoTemplate.find(new Query().addCriteria(
                    Criteria.where("user.tiSensorId").is(tiSensorId)),
                    UserProfile.class,
                    "userProfile");
        } catch (Exception e){
            logger.error("Unable to get userId for given tiSensorId "+e);
        }

        if(userProfile.isEmpty()){
            return null;
        }
        if(userProfile.size() > 1){
            logger.error("Multiple users "+userProfile+
                    " with same tisensorid "+tiSensorId+" detected");
        }
        return userProfile.get(0).getUser().getUserId();
    }
}
