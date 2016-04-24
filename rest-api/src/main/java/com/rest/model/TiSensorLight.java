package com.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by uday on 4/23/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TiSensorLight implements TiSensorDatapoint {
    private double light;
    private long timestamp;
    private String tiSensorId;
    private String userId;
    private String collection = "tiSensorLight";

    public String getCollectionName() {
        return collection;
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTiSensorId() {
        return tiSensorId;
    }

    public void setTiSensorId(String tiSensorId) {
        this.tiSensorId = tiSensorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
