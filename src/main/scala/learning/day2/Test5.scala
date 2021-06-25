package learning.day2

/**
 * 学习目标： 隐式参数
 *
 * 在scala中，如果一个参数被定义为implicit，则该参数值的传递是可选的，另外其存在于单独的参数列表中，然而，如果没有传值，Scala会在调用的作用域中寻找一个
 * 隐式变量，这个隐式变量必须和隐式参数具有相同的类型，因此，在一个作用域中每一种类型都最多只能有一个隐式变量
 * 形式为：
 * def 方法名（形参）（隐式参数）
 */
object Test5 {
  class Wifi(name:String){

    override def toString: String = name
  }

  def connected(user:String)(implicit wifi:Wifi): Unit ={

    println(s"$user"+"=========="+s"$wifi")
  }
  def main(args: Array[String]): Unit = {
    implicit val wifi = new Wifi("nils1")
//    connected("sha")(wifi)
    connected("user1")
    main2()
  }

  def main2(): Unit ={
    implicit val wifi1 = new Wifi("nils2")
    connected("user2")
  }
}
