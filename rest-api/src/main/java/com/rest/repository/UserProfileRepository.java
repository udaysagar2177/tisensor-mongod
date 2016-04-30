package com.rest.repository;

import com.rest.model.UserProfile;

/**
 * Created by uday on 4/3/16.
 */

public interface UserProfileRepository {
    void createSimulationUser(UserProfile user);
    String getUserId(String tiSensorId);
}
