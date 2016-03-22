package com.rest.model;

/**
 * Created by uday on 3/21/16.
 */
public class TiSensorDatapointWithUserID extends TiSensorDatapoint {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
