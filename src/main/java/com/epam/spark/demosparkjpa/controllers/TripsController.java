package com.epam.spark.demosparkjpa.controllers;

import com.epam.spark.demosparkjpa.services.TripsEnrichmentator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/trips/show/")
public class TripsController {
    @Autowired
    private TripsEnrichmentator enrichmentator;


    @GetMapping("join_solution")
    public void showDriversWithAgeJoinSolution() {
        enrichmentator.showTripsWithDriverAgeJoinSolution();
    }

    @GetMapping("udf_solution")
    public void showDriversWithAgeUdfSolution() {
        enrichmentator.showTripsWithDriverAgeUdfSolution();
    }

}
