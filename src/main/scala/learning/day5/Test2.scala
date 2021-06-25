package learning.day5

/**
 * 学习目标： 柯里化
 *
 * 什么是scala的柯里化，不要编写方法只有一个的参数列表，而要编写多个，
 * 不能写成这样， def foo(a:Int,b,Int)
 * 而要写成这样， def foo(a:Int)(b:Int),这样调用时，就可以写成 def foo(1)(2) 或者 def foo{1}{2} 或者 def(0){1}{2}
 */
class Test2 {

}

/**
 * 首先我们来看一个foldLeft函数
 */
object Test2_1{
  def main(args: Array[String]): Unit = {
    val array =Array(1,2,3,4)
    val sum = array.foldLeft(0){(sum,elm)=>sum+elm}
    println(sum)
    val max = array.foldLeft(Integer.MIN_VALUE){(large,elm)=>Math.max(large,elm)}
    println(max)

    // 为了使代码更加简洁，foldleft方法有一个等效的/: 操作符，我们可以使用foldLeft()或等效的/:操作符执行先前的操作
    val sum1 = (0 /: array) {(sum, elem) => sum + elem}
    val max1 = (Integer.MIN_VALUE /:array){(large,elem)=>Math.max(large,elem)}
    println(sum1)
    println(max1)
  }


}

