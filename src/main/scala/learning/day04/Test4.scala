package learning.day04

/**
  * 学习目标： Either类型
  * 当一个函数调用的结果可能存在也可能不存在时，Option类型很有用，有时候，你可能希望从一个函数中返回两种不同类型的值之一
  * Either类型有两种值，左值（通常被认为是错误），右值（通常被认为是正确的或者预期的）
  */
class Test4 {}

object Test4_1 {
  def main(args: Array[String]): Unit = {
//    println(testEither(9))
//    println(testEither(90))
    displayTestEither(testEither(3))
    displayTestEither(testEither(33))
  }

  def testEither(value: Int) = {
    if (value < 10)
      Right(value)else
      Left("Error number")
  }

  def displayTestEither(result : Either[String,Int]): Unit ={
    println(s"$result")
    result match {
      case Right(value) => println(s" result: $value")
      case Left(erro) => println(s"Error: $erro")
    }
  }
}
