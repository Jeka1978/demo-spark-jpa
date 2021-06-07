package com.epam.spark.demosparkjpa.repo;

import com.epam.spark.demosparkjpa.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @RestResource(path = "byage")
    List<Driver> findByAgeGreaterThan(int age);

    @RestResource(path = "byname")
    List<Driver> findByNameContaining(String partOfName);
}
