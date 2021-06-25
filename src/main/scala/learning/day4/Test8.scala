package learning.day4

import java.time.LocalDate

import com.sun.scenario.effect.Offset

/**
  * 学习目标： 隐式类
  * 相比于在Test7中，创建一个常规类和一个单独的隐式转换方法，你可以告诉scala，某个类的唯一目的就是作为一种适配器或者转换器
  */
class Test8 {}

object DataUtil {
  var ago = "ago"
  var after = "after"
  implicit class DateHelper(val offset: Int)  {
    def days(when:String)={
      val now = LocalDate.now
      when match{
        case "ago" => now.minusDays(offset)
        case "after" => now.plusDays(offset)
        case _ => now
      }
    }
  }
}


object Test8_1{
  import DataUtil._
  def main(args: Array[String]): Unit = {
    println(2 days ago)
  }
}