package com.rest.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userProfile")
public class UserProfile {
    @Id
    private ObjectId _id;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ClassPojo [user = " + user + "]";
    }

    public static class User {
        private String tiSensorId;

        private String userId;

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

}