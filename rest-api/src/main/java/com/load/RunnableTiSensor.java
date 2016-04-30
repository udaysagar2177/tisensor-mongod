package com.load;

import com.rest.config.Constants;
import com.rest.model.TiSensorDatapoint;
import com.rest.model.TiSensorHumidity;
import com.rest.model.TiSensorLight;
import com.rest.model.TiSensorTemperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * Created by uday on 3/22/16.
 */
public class RunnableTiSensor implements Runnable {
    private String tiSensorId;
    private Logger logger;
    private RestTemplate restTemplate;

    public RunnableTiSensor(String tiSensorId){
        this.tiSensorId = tiSensorId;
        logger = LoggerFactory.getLogger(
                RunnableTiSensor.class);
        restTemplate = new RestTemplate();
    }

    public void run(){
        Random random = new Random();

        TiSensorTemperature temperature = new TiSensorTemperature();
        TiSensorLight light = new TiSensorLight();
        TiSensorHumidity humidity = new TiSensorHumidity();
        temperature.setTiSensorId(this.tiSensorId);
        light.setTiSensorId(this.tiSensorId);
        humidity.setTiSensorId(this.tiSensorId);
        temperature.setTimestamp("22:00:00");
        light.setTimestamp("22:00:00");
        humidity.setTimestamp("22:00:00");

        while(true){
            temperature.setTemperature(15+random.nextDouble());
            sendDataPoint(temperature, "/temperature");
            light.setLight(5+random.nextDouble());
            sendDataPoint(light, "/light");
            humidity.setHumidity(50+random.nextDouble());
            sendDataPoint(humidity, "/humidity");
            try {
                Thread.sleep(1000);
            }catch(Exception e){
                logger.info("Thread: "+tiSensorId+" Interrupted!"+e);
            }
        }
    }

    private void sendDataPoint(TiSensorDatapoint datapoint, String restUrl){
        try{
            logger.debug("Sending datapoint " +datapoint.getCollectionName()
                    +" to "+ Constants
                    .DATAPOINT_REST_URL+restUrl);
            restTemplate.postForLocation(Constants.DATAPOINT_REST_URL+restUrl,
                    datapoint);
        }catch(Exception e){
            logger.error("Failed to send datapoint! "+e);
        }
    }
}
