package learning.day3

import jdk.internal.util.xml.impl.Input

/**
  * 学习目标： 参数化类型
  * 泛型或参数化类型有助于创建能够同时应对多种不同类型的类和函数
 *    scala为什么泛型用的时[],而不是<>?
 *     因为scala添加了对XML的原生支持，占用了<>符号，所以后来就使用了[],这也绕过对数组中的元素访问要变成通过()进行
  */
class Test4 {
  def echo[T](input1: T, input2: T) {
    println(s"[${input1.getClass}]+[${input2.getClass}]")
  }

}

object Test4_1 {
  def echo[T](input1: T, input2: T) {
    println(s"[${input1.getClass}]+[${input2.getClass}]")
  }

  // 如果目的就是为了接收两个不同类型的参数，则可以使用如下写法：
  def echo1[T1, T2](input1: T1, input2: T2) {
    println(s"[${input1.getClass}]+[${input2.getClass}]")
  }

  def main(args: Array[String]): Unit = {
    echo1[Int, String](1, "2")
    // 为了防止对代码重构时传入了不同类型的参数，可在这里对echo后面加参数类型限定
    echo[Int](1, 2)
  }

}

class Message[T](val content: T){
  override def toString: String = s"message content [$content]"
  //字段content的类型被参数化了，其类型会在类型创建的时候决定，is()方法的参数类型也是如此
  def is(value: T):Boolean = value == content
}

object Test4_2{
  def main(args: Array[String]): Unit = {
    // 与java不同，scala不允许使用原生类型(raw type),如果定义message1的时候使用Message，而不是Message[String],编译器就会报错
    // 这里的原生类型指的时泛型中类型擦除之后的类型
    val message1:Message[String]=new Message("hello")
    val message2 = new Message(2)

    val message3=new Message("hello")
    println(message1)
    println(message2)
    println(message1.is("hello"))
    println(message2.is(1))
  }

}
