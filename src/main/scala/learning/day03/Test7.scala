package learning.day03

import scala.collection._

/**
 * 学习目标： apply方法
 *
 * 不用new关键字就可以创建伴生类的实例，特殊的apply方法就是达到这种效果的关键
 */
class Test7 {}

class Marker2 private (color: String) {
  println(s"creating ${this}")
  override def toString: String = s"create marker $color"
}

object Marker2 {
  private val markers =
    mutable.Map("red" -> new Marker2("red"), "yellow" -> new Marker2("yellow"))

  def supperColors:Iterable[String] = markers.keys

  def apply(color:String)={
    markers.getOrElseUpdate(color,new Marker2(color))
  }
}

object Test7_1{
  def main(args: Array[String]): Unit = {
    println(Marker2("green"))
    println(Marker2.supperColors)
  }
}
