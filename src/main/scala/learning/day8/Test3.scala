package learning.day8

/**
 * 学习目标： scala异常
 * 1.scala中不请之你对异常进行进行捕捉，因为它将所有的异常都看作是不受检异常，在java中需要区分受检异常和不受检异常，例如：
 *   Thread.sleep方法，java中需要对该异常进行捕捉或者抛出来，但是Scala不需要
 * 2.scala中catch代码块是结合着模式匹配来进行异常处理的
 * 3.注意catch语句块的顺序，java的编译器会去检查catch代码块中的顺序，但是scala中不会去检查case中的代码块顺序，这个据说会在scala未来版本中进行改进
 */
case class Test31 ()

object Test3_1{
  def main(args: Array[String]): Unit = {
    try{
      numberException(11)
    }catch{
      case e: Exception => println("Exception"+e.getMessage)
      case e: RuntimeException => println("RuntimeException"+e.getMessage)
      case e: IllegalArgumentException => println("IllegalException"+"====="+e.getMessage)


    }

  }

  def numberException(num:Int)={
    if(num>10)
      throw new IllegalArgumentException("illegalException")
    if(num<10)
      throw new RuntimeException("runTimeException")
    if(num==10)
      throw new Exception("exception")
  }
}

/**
 * java格式
 */
object Test3_2 {
  @throws[InterruptedException]
  def main(args: Array[String]): Unit = {
    Thread.sleep(100)
  }
}