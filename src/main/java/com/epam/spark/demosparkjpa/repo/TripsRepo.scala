package com.epam.spark.demosparkjpa.repo

import com.epam.spark.demosparkjpa.model.Trip
import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.springframework.stereotype.Component

/**
 * @author Evgeny Borisov
 */
@Component
class TripsRepo(sparkSession: SparkSession) {

  def readTrips(): Dataset[Row] = {

    val schema = org.apache.spark.sql.Encoders.product[Trip].schema
    //    sparkSession.read.option("delimiter", " ").schema(simpleSchema).csv("taxi/trips.txt").show()
    sparkSession.read.option("delimiter", " ").schema(schema).csv("taxi/trips.txt")
  }

}
