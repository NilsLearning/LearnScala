package learning.day5

/**
 * 学习目标： 参数的占位符
 *
 * 在Test2中，对于函数中的参数都是明确指定的，接下来将使用_代替
 */
class Test3 {

}

object Test3{
  def main(args: Array[String]): Unit = {
    val array = Array(1,2,3)
    val sum = (0/:array){_ + _}
    println(sum)
    val max = (Integer.MIN_VALUE /:array){Math.max(_,_)}
    println(max)
  }
}