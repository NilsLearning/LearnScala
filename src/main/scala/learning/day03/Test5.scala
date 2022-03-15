package learning.day03

import scala.collection._

/**
 * 学习目标： 单例对象和伴生对象
 * 在scala中创建一个单例对象使用的关键字是object而不是class，因为不能实例化一个单例对象，所以不能传递参数给它的构造器
 */
class Test5 {

}

class Marker(color: String){
  println(s"creating ${this}")

  override def toString: String = {
    s"make marker $color"
  }
}

object MarkerFactory{
  private val markers = mutable.Map("red" -> new Marker("red"),"blue" -> new Marker("blue"))
  def getMark(color:String) ={
    markers.getOrElseUpdate(color,new Marker(color))
  }

  def main(args: Array[String]): Unit = {
    println(MarkerFactory getMark "blue")
    println(MarkerFactory getMark "yellow")
    println(MarkerFactory getMark "blue")
    println(MarkerFactory getMark "red")
  }
}