package com.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by uday on 4/3/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "users")
public class User {
    public String userId;
    public String tiSensorId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTiSensorId() {
        return tiSensorId;
    }

    public void setTiSensorId(String tiSensorId) {
        this.tiSensorId = tiSensorId;
    }
}
