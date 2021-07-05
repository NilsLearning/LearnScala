package learning.day10

import scala.io.StdIn

/**
 *
 * 学习目标：scala中的并发编程
 * 1.惰性求值
 */
class Test1 {

}

/**
 * 惰性求值：条件的短路求值，如 && 和 ||
 */
object Test1{
  def main(args: Array[String]): Unit = {
    // 通过运行以下代码，可以发现使用||运算符时出现了惰性运算，程序并没有执行test2(6)的函数调用
    if(test1(5) || test2(6)){
      println("Sdad")
    }
    // 以下代码中无论是否使用到了bool这个变量，程序都是会执行的，所以这种情况不是我们想要的结果
     val bool = test2(4)
    if(test1(5) && bool ){
      println(bool)
    }
    // 通过使用lazy对变量进行标记，可以对该变量值的绑定将会被推迟到它首次使用时
    // lazy只可以修饰不可变量val，而不能用于修饰可变变量var
    lazy val bool1= test2(4)
    if(test1(5) && bool1 ){
      println(bool)
    }
  }
  def test1(input:Int)={
    if(input>10) {
      println("input >10")
      true
    }
    else
    false
  }
  def test2(input:Int)={
    println("do test2")
    true
  }
}

/**
 * 在以下代码中出现了随机顺序绑定到两个变量，在这个情况下的结果就是，不可交换计算将变得不可预知
 */
object Test1_1{
  def main(args: Array[String]): Unit = {
    def read = StdIn.readInt()
    lazy val first =read
    lazy val second =read
    if(Math.random()<0.5) {
      second
      println(second.toString)
    }
    println(first-second)

  }
}