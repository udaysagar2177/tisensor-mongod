package com.rest.repository;

import com.rest.model.User;
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

@Repository("userRepository")
public class MongoUserRepository implements UserRepository {
    private  static Logger logger = LoggerFactory.getLogger(
            MongoUserRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;

    public void createUser(User user) {
        mongoTemplate.save(user, "users");
    }

    public String getUserId(String tiSensorId) {
        List<User> userId = mongoTemplate.find(new Query().addCriteria(
                Criteria.where("tiSensorId").is(tiSensorId)),
                User.class,
                "users");

        if(userId.isEmpty()){
            return null;
        }
        if(userId.size() > 1){
            StringBuffer userIds = null;
            for(int i=0; i<userId.size(); i++){
                userIds.append(userId.get(i));
            }
            logger.error("multiple users "+userIds.toString()+
                    " with same tisensorid "+tiSensorId+" detected");
        }
        return userId.get(0).getUserId();
    }
}
