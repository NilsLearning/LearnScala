package learning.day05

/**
 * 学习目标： 参数路由
 * 编译器会检查方法 /: 的函数签名，该签名决定了该方法接收两个参数列表，第一个参数列表接收一个对象，第二个参数列表接收一个函数值，
 * 然后，编译器会要求这个函数值接收两个参数，一旦编译器推导出所接收的函数值的签名，那么它就会检查这个函数值是否接收两个参数。
 * 本案例中，尽管我们没有指定max方法的参数，但是编译器会知道这个方法接收两个参数，编译器会让函数签名中的两个参数和max方法的两个参数对号入座
 * ，并最终执行正确的参数路由。
 *
 */
class Test4 {

}

object Test4{
  def main(args: Array[String]): Unit = {
    val array = Array(1,2,3)
    val max = (Integer.MIN_VALUE/:array){Math.max(_,_)}
    val max1 = (Integer.MIN_VALUE/:array){Math.max _}
    val max2 = (Integer.MIN_VALUE/:array){Math.max}
    println(max)
    println(max1)
    println(max2)
  }
}