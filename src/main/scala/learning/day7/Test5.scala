package learning.day7

/**
 * 学习目标：for表达式
 * for([pattern <- generator;definition*]+;filter*)
 *   [yield] expression
 * for表达式接受一个或者多个生成器作为参数，并带有0个或多个定义以及0个或者多个过滤器，这些都是由分号分隔的，yield关键字是可选的，如果存在，则告诉表达式返回一个值列表
 * 而不是一个Unit。
 */
class Test5 {

}

object Test5_1{
  def main(args: Array[String]): Unit = {
//    val ob1 = Ob1("yang",2)
//    print(ob1.toString)

    val i = 2
    val i1 = 1 << 4
//    val i2 = i >> 2
    println(i1)
//    println(i2)
  }
}

case class Ob1(name:String,age:Int)

case class UserModel(
                      Id: Option[Int],
                      RealName: Option[String]
                    )

