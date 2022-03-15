package learning.day03

import scala.collection._
/**
 * 学习目标： 独立对象和伴生对象
 *
 * 独立对象--它和任何类都没有自动的联系(stand-alone object)
 * 可以选择将一个单例关联到一个类，这样的单例，其名字和对应类的名字一致，因此被成为伴生对象（companion object），相应的类被成为伴生类
 * 伴生对象作为一种变通的方案，弥补scala中缺少static成员的试试，但是在scala未来的版本，有可能会使用@static注解对静态方法提供支持
 */
class Test6 {

}

class Marker1 private(color: String){
  println(s"creating ${this}")

  override def toString: String = s"create marker1 $color"

}

object Marker1{
  private val markers = mutable.Map("red"->new Marker1("red"))

  def getMarker(color:String) ={
    markers.getOrElseUpdate(color,new Marker1(color))
  }
}

object Test6_1{
  def main(args: Array[String]): Unit = {
    println(Marker1 getMarker "red")
  }
  // 如果是以下写法，那么就会报错：
  //val marker1 = new Marker1("red")
  // 提示：No constructor accessible from her
}