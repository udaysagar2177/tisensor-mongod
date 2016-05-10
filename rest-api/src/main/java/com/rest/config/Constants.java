package com.rest.config;

/**
 * Created by uday on 3/24/16.
 */

public class Constants {

    public static final String DATABASE_NAME;
    public static final String DATABASE_USERNAME;
    public static final String DATABASE_PASSWORD;
    public static final String DATABASE_HOSTNAME;
    public static final int DATABASE_PORT;

    public static final String DATAPOINT_REST_URL;

    public static final int NUMBER_OF_TISENSOR_SIMULATIONS;
    public static final String SIMULATED_TISENSOR_ID_HANDLE =
            "TISENSOR_SIMULATION_";
    public static final String SIMULATED_TISENSOR_USER_HANDLE =
            "TISENSOR_SIMULATION_USER_";
    public static final int SIMULATED_TISENSOR_COUNT = 3;

    static {
        if(System.getenv("environment") != null &&
                System.getenv("environment").equals("production")) {
            DATABASE_NAME      = System.getenv("DATABASE_NAME");
            DATABASE_USERNAME  = System.getenv("DATABASE_USERNAME");
            DATABASE_PASSWORD  = System.getenv("DATABASE_PASSWORD");
            DATABASE_HOSTNAME  = System.getenv("DATABASE_HOSTNAME");
            DATABASE_PORT      = Integer.parseInt(System.getenv(
                                                        "DATABASE_PORT"));
            DATAPOINT_REST_URL = System.getenv("DATAPOINT_REST_URL");
            if(System.getenv("NUMBER_OF_TISENSOR_SIMULATIONS") == null)
                NUMBER_OF_TISENSOR_SIMULATIONS = 3;
            else
                NUMBER_OF_TISENSOR_SIMULATIONS = Integer.parseInt(
                        System.getenv("NUMBER_OF_TISENSOR_SIMULATIONS"));
        }else {
            DATABASE_NAME      = "mydb";
            DATABASE_USERNAME  = "";
            DATABASE_PASSWORD  = "";
            DATABASE_HOSTNAME  = "192.168.10.2";
            DATABASE_PORT      = 27017;
            DATAPOINT_REST_URL = "http://52.73.142.19:8081/tisensor";
            NUMBER_OF_TISENSOR_SIMULATIONS = 3;
        }
    }
}
