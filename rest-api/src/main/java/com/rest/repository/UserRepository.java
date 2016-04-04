package com.rest.repository;

import com.rest.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by uday on 4/3/16.
 */

public interface UserRepository {
    void createUser(User user);
    String getUserId(String tiSensorId);
}
