package learning.day03

/**
 * 学习目标： 包对象
 * 包对象的作用是避免创建并重复引用这样一个额外的类的负担
 */
class Test9 {

}

/**
 * 定义一个convert包对象
 */
package object Convert{
  def convert(number:Int,unit:String): String ={
    s"$number--$unit"
  }

  def convert1(number:Int,unit:String): String ={
    s"$number-+++-$unit"
  }
}





