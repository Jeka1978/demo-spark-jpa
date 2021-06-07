package com.epam.spark.demosparkjpa;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSparkJpaApplication {


    @Bean
    public Faker faker(){
        return new Faker();
    }



    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoSparkJpaApplication.class, args);
        System.out.println();
    }

}
