package com.rest.service;

import com.rest.config.Constants;
import com.rest.model.TiSensorDatapoint;
import com.rest.model.UserProfile;
import com.rest.repository.TiSensorDatapointRepository;
import com.rest.repository.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by uday on 3/21/16.
 */

@Service("TiSensorServiceImpl")
public class TiSensorServiceImpl implements TiSensorService {
    private Logger logger = LoggerFactory.getLogger(TiSensorServiceImpl.class);
    private int existingUsers = 0;

    @Autowired
    TiSensorDatapointRepository tiSensorDatapointRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    public boolean isRegisteredIdAttachUserId(TiSensorDatapoint datapoint) {
        if (datapoint.getTiSensorId().startsWith(
                Constants.SIMULATED_TISENSOR_ID_HANDLE)) {
            logger.info("Datapoint received from " + datapoint.getTiSensorId());
            createTiSensorSimulationUserIfDoesNotExists(datapoint);
        }
        String userId = userProfileRepository.getUserId(datapoint.getTiSensorId());
        if(userId == null){
            return false;
        }
        datapoint.setUserId(userId);
        return true;
    }

    private void createTiSensorSimulationUserIfDoesNotExists(
            TiSensorDatapoint datapoint){
        if(userProfileRepository.getUserId(datapoint.getTiSensorId()) != null){
            existingUsers++;
            return;
        }
        int tiSensorSimulation = Integer.parseInt(
                datapoint.getTiSensorId()
                        .substring(Constants.SIMULATED_TISENSOR_ID_HANDLE
                                .length()));
        if(tiSensorSimulation >= existingUsers) {
            UserProfile userProfile = new UserProfile();
            UserProfile.User user = new UserProfile.User();
            user.setUserId(Constants.SIMULATED_TISENSOR_USER_HANDLE+
                    tiSensorSimulation);
            user.setTiSensorId(datapoint.getTiSensorId());
            userProfile.setUser(user);
            userProfileRepository.createSimulationUser(userProfile);
            existingUsers++;
        }
    }

    public void save(TiSensorDatapoint datapoint) {
        tiSensorDatapointRepository.saveDatapoint(datapoint);
    }
}
