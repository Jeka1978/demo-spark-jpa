package com.epam.spark.demosparkjpa.model

import com.epam.spark.demosparkjpa.services.DriverService

import scala.collection.JavaConverters._
import scala.language.implicitConversions

/**
 * @author Evgeny Borisov
 */
case class DriverScala(id: Int, age: Int)

object DriverAdapter{
  implicit def toProduct(driver: Driver): DriverScala = {
    DriverScala(driver.getId, driver.getAge)
  }
  implicit def toProduct1(drivers: java.util.List[Driver]): List[DriverScala] = {
    drivers.asScala.toList.map(driver =>DriverScala(driver.getId, driver.getAge))
  }

}
