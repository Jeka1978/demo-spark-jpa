package com.epam.spark.demosparkjpa.services

import com.epam.spark.demosparkjpa.model.{Driver, Trip}
import com.epam.spark.demosparkjpa.repo.TripsRepo
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.sql.{DataFrame, Dataset, Encoders, Row, SparkSession}
import org.apache.spark.sql.functions._
import org.springframework.stereotype.Component

import scala.collection.JavaConverters._

/**
 * @author Evgeny Borisov
 */
@Component
class TripsEnrichmentator(@transient driverService: DriverService,@transient tripsRepo: TripsRepo, @transient sparkSession: SparkSession) extends Serializable {
    import sparkSession.implicits._


  private val id2Age: Map[Int, Int] = driverService
    .getAllDrivers
    .asScala
    .map(driver => driver.getId -> driver.getAge)
    .toMap

  private val broadCastedMap: Broadcast[Map[Int, Int]] = sparkSession.sparkContext.broadcast(id2Age)

  def showTripsWithDriverAgeUdfSolution():Unit={
    val tripsDf = tripsRepo.readTrips()
    val getAgeUdf = udf((id: Int) => {broadCastedMap.value.getOrElse(id, 0)})
   
  }

  def showTripsWithDriverAgeJoinSolution(): Unit = {
    import com.epam.spark.demosparkjpa.model.DriverAdapter._
    val tripsDf = tripsRepo.readTrips()
    val drivers: java.util.List[Driver] = driverService.getAllDrivers()


    val driversDf = sparkSession.createDataFrame(drivers).withColumnRenamed("id", "driverId")

    tripsDf.join((driversDf), driversDf("driverId") === tripsDf("id")).drop("id").show(false)

  }

}
