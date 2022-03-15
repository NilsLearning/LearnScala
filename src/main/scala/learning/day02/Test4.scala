package learning.day02

/**
 * 学习目标： 可变参数 & 默认值的使用
 * 灵活的参数和参数值，scala提供了一些便利的特性来接收变长参数，声明参数的默认值以及定义命名参数
 */
object Test4 {
   def testManyInt(values: Int *){
    print(values.max)
  }

//  def main(args:Array[String]): Unit ={
//    testManyInt(1,2,3)
//  }

//  def main(args:Array[String]): Unit ={
//    val values = Array(1,2,3,5)
//    // values后面的符号表示告诉编译器将数组展开成所需的形式
//    testManyInt(values : _*)
//  }

  /**
   * 发现scala的case class提供默认的对象toString方法
   * @param args
   */
    def main(args:Array[String]): Unit ={
      val mail1 = Mail("yang","qun")
      val mail2 = Mail(address = "hell")
      print(mail2)
      println(mail1 toString)
    }


}

/**
 * 提供默认值的case class
 * @param name
 * @param address
 */
case class Mail(
  name:String = "nils",
  address: String
               )