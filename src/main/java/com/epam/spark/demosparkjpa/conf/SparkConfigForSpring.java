package com.epam.spark.demosparkjpa.conf;

import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@Configuration
public class SparkConfigForSpring {

    @Bean
//    @Profile("DEV")
    //spring.profiles.active
    public SparkSession sparkSessionDev(){
        return SparkSession.builder().master("local[*]").appName("taxi").getOrCreate();
    }
  /*  @Bean
    @Profile("PROD")
    public SparkSession sparkSessionProd(){
        return SparkSession.builder().appName("taxi").getOrCreate();
    }*/
}



