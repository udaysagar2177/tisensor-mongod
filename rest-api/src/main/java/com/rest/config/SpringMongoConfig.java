package com.rest.config;

import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class SpringMongoConfig {
    private static Logger logger = LoggerFactory.getLogger(
            SpringMongoConfig.class);

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        logger.debug("Connecting to MongoDB on"+
                Constants.DATABASE_HOSTNAME+":"+Constants.DATABASE_PORT);
        logger.debug("Using Database"+Constants.DATABASE_NAME);
        logger.debug("with Username: "+ Constants.DATABASE_USERNAME+" and " +
                "password: "+Constants.DATABASE_PASSWORD);

        return new SimpleMongoDbFactory(
                new MongoClient(
                        Constants.DATABASE_HOSTNAME,
                        Constants.DATABASE_PORT
                ),
                Constants.DATABASE_NAME,
                new UserCredentials(
                        Constants.DATABASE_USERNAME,
                        Constants.DATABASE_PASSWORD
                ));
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
