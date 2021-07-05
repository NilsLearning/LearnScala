package learning.day10

import scala.io.Source
import scala.xml.XML

/**
 * 使用并行集合加速
 */
class Test3 {

}

object Test3_1{
  def main(args: Array[String]): Unit = {
  val str = s"https://raw.githubusercontent.com/ReactivePlatform/" +
    s"Pragmatic-Scala-StaticResources/master/src/main/resources/" +
    s"weathers/"
    println(str)
  }

  def getWeatherData(city:String)={
//    val response = Source.fromURL()
  }


//
    def getWeatherData(city: String) = {
    val response = Source.fromURL(
      s"https://raw.githubusercontent.com/ReactivePlatform/" +
        s"Pragmatic-Scala-StaticResources/master/src/main/resources/" +
        s"weathers/$city.xml")
    val xmlResponse = XML.loadString(response.mkString)
    val cityName = (xmlResponse \\ "city" \ "@name").text
    val temperature = (xmlResponse \\ "temperature" \ "@value").text
    val condition = (xmlResponse \\ "weather" \ "@value").text
    (cityName, temperature, condition)
  }
}


