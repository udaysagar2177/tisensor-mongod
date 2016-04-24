package com.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by uday on 4/23/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TiSensorTemperature implements TiSensorDatapoint {
    private double temperature;
    private long timestamp;
    private String tiSensorId;
    private String userId;
    private String collection = "tiSensorTemperature";

    public String getCollectionName() {
        return collection;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
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
