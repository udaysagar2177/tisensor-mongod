package com.load;

import java.util.HashMap;

/**
 * Created by uday on 3/22/16.
 */
public class SimulatedTiSensor {
    public static void main(String args[]){
        int tiSensorsCount = 3;
        for(int i=0; i<tiSensorsCount; i++){
            new Thread(new RunnableTiSensor("SIMULATED_"+i)).start();
        }
    }
}
