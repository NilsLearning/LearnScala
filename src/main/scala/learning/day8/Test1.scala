package learning.day8

import java.time.DayOfWeek

/**
  * 模式匹配
  * 注意scala中的模式匹配会进行自动break
  * 1.根据值的类型和守卫进行匹配
  * 2.scala期望模式变量名都以小写字母开头，而常量名则是大写字母
 * 3.当我们编写一个模式匹配时，都需要确保完整地覆盖了所有可能的case，一般我们会添加一个默认的case，但是如果没有这个默认case，
 * 我们可以将这些样例的超类定义为密封（sealed）的，密封类除在同一个文件中定义的子类外，不能添加新的子类。
  */
class Test1 {}
object Test1_1 {
  def main(args: Array[String]): Unit = {
    println(Week.SUNDAY)
    println(Week.SUNDAY.toString)
    val str = "SUNDAY"
    println(str == Week.SUNDAY.toString)

    Week.matchTest((1, 2))
    Week.matchTest(3)

  }
}

sealed abstract class Expr
case class Str(name:String) extends Expr
case class Number(num:Int) extends Expr
case class NumberVar(num:Int,name:String) extends Expr

object Test2 {

  def describe(e:Expr):String = e match{
    case Number(_) =>  "a number"
    case Str(_) => "str"
  }

  def main(args: Array[String]): Unit = {
    val value:Number = Number(1)
    println(describe(value))
//    testMatchVariable(0)
//    testMatchVariable(100)
  }
  val max = 100
  val MAX = 100

  /**
    * 如果你使用的是大写字母的名称，scala将会在作用域范围内查找常量，但是如果使用的是非大写字母的名称，它将只假设其是一个模式变量，
    * 此处模式变量隐藏了（Sample类的）max字段
    * @param input
    */
  def testMatchVariable(input: Int): Unit = {
    input match {
      case max => println(s"print max $max")
      // 可以使用this来进行指定
//      case this.max => println(s"print max $max")
      // 可以使用单引号来进行指定
//      case `max` => println(s"print max $max")
    }
    input match {
      case MAX => println(s"print max $input")
    }
  }
}

object Week extends Enumeration {
  val SUNDAY: Week.Value = Value("SUNDAY")
  val SATURDAY: Week.Value = Value("SATURDAY")

  /**
    * 根据值的类型和守卫进行匹配
    * @param input
    */
  def matchTest(input: Any): Unit = {
    input match {
      case (x: Int, y: Int)    => println("x & y")
      case (x: Int) if (x > 1) => println("xxxx")
    }
  }
}

object Test3 {
  def main(args: Array[String]): Unit = {
    val age = 1
    age match {
      // 使用unapply提取器进行匹配，match表达式会自动的将age作为参数发送给apply方法
      case Person() => println("+++++++++")
      case _        => println("--------------")
    }
    val person = Person("yang", 123)
    person match {
      case Person(name, age) => println(person.name)
      case _ => println("--------------")
    }
    val age1 = 11
    age1 match {
      // 使用unapply提取器进行匹配，match表达式会自动的将age作为参数发送给apply方法
//      case Person() => println("+++++++++")
        // 在这里number1和number不作为传入参数，而是作为传出参数
//      case TestUnapply(number1,number2)        => println("--------------"+number1)
      case TestUnapply(number1 @ Person(),number2)        => println("--------------"+number2)
      case _ =>
    }
  }
}
object Person {
  def unapply(age: Int) = {
    if (age > 10) true else false
  }
}
object TestUnapply {
  def unapply(age: Int) = {
    if (age == 10) Some(1, 2) else None
  }
}
case class Person(name: String, age: Int)
