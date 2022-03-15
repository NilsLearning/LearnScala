package learning.day04

import java.time.{LocalDate, LocalTime}

import com.sun.scenario.effect.Offset

/**
 * 学习目标： 隐式函数
 * 在本案例的学习过程中，使用到了DSL语法
 */
class Test7 {

}

class DateHelper(offset: Int){
  def days(when : String) ={
    val now = LocalDate.now
    when match {
      case "ago" => now.minusDays(offset)
      case "after" => now.plusDays(offset)
      case _ => now
    }
  }
}

object DateHelper{
  val ago = "ago"
  val after = "after"
  implicit def int2DateHelper(offset: Int) = new DateHelper(offset)

  def main(args: Array[String]): Unit = {
    println(1 days after)
  }
}

import DateHelper._
object Test7_1{
  def main(args: Array[String]): Unit = {
    println( 1 days ago )
  }
}


