package learning.day2

/**
 * 学习目标： scala的==与java的==的区别
 * scala的==是基于值的比较，而不论类型是什么，这是在类Any（scala中所有的类型都衍生自Any）
 * scala中的eq方法是基于身份的比较
 * str1 和str2 都指向同一个String实例，因为Java不会为第二个字符串字面量"hello",然而str3指向另一个新建的String实例
 */
object Test8 {
  def main(args: Array[String]): Unit = {
    val str1  = "hello"
    val str2 = "hello"
    val str3 = new String("hello")
    println(str1 eq str2)
    println(str1 == str2)
    println(str1 == str3)
    println(str1 eq str3)

  }
}
