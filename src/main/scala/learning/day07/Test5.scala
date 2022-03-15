package learning.day07

/**
  * 学习目标：for表达式
  * for([pattern <- generator;definition*]+;filter*)
  *   [yield] expression
  * for表达式接受一个或者多个生成器作为参数，并带有0个或多个定义以及0个或者多个过滤器，这些都是由分号分隔的，yield关键字是可选的，如果存在，则告诉表达式返回一个值列表
  * 而不是一个Unit。
  */
class Test5 {}

object Test5_1 {
  def main(args: Array[String]): Unit = {
    val ints = for (i <- 1 to 3)
      yield i * 2
    println(ints)

    val ints1 = for (i <- 1 to 3; if i % 2 == 0)
      yield i * 2
    println(ints1)

    val ints2 = for (i <- 1 to 3
                     if i % 2 == 0)
      yield i * 2
    println(ints2)

    val list = List(Ob1("yang", 23), Ob1("qun", 45))
    val age = for(obj <- list;
        age = obj.age)
    yield age
    println(age)

    /**
     * for表达式中提供了多个生成器，那么每个生成器都将形成一个内部循环，最右边的生成器控制最里面的循环
     */
    for(i<- 1 to 3; j<- 4 to 6){
      println(s"[$i,$j]")
    }


  }
}

case class Ob1(name: String, age: Int)


