package com.epam.spark.demosparkjpa.services;

import com.epam.spark.demosparkjpa.model.Driver;
import com.epam.spark.demosparkjpa.repo.DriverRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
@Transactional
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private Faker faker;


    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }


    @EventListener(ContextRefreshedEvent.class)
    public void fillDrivers() {
        for (int i = 0; i < 200; i++) {
            driverRepository.save(Driver.builder().age(faker.random().nextInt(120)).name(faker.gameOfThrones().character()).build());
        }
    }
}








