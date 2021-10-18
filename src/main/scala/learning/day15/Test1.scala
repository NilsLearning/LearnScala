package learning.day15

/**
 *
 * 函数字面量的语法：用圆括号括起来的一组带有名字的参数，一个右箭头和函数体
 * => 表示该函数将左侧的内容（任何整数x）转换成右侧的内容
 * (x:Int,y:Int) => x +y
 * 打开终端，通过scalac编译
 * scalac Test1.scala得到文件
 * 然后经过javap反编译指令
 * javap Test1$.class得到文件
 */
object Test1 {
  /**
   * 函数式写法
   *
   */
  def main(args: Array[String]): Unit = {
    val increase = (x:Int,y:Int) => x * y
    println(increase(2,5))
  }

  def increase(x:Int,y:Int): Int ={
    x + y
  }

  /**
   * 查看编译后的文件
   */

}
