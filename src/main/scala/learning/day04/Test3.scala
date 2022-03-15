package learning.day04

/**
 * 学习目标： Option类型
 *
 * 在Effective Java一书中有这样的合理建议： 返回空集合，而不是null 引用
 */
class Test3 {

}

/**
 * commentOnPractice方法返回的是Some[T]的实例或者None，而不是String的实例，这两个类都继承自Option[T]
 * 通过显式的指定类型为Option[String],Scala会强制检查实例是否存在，这是在编译式强制执行的，因为没有检查Null引用，所以
 * 不太可能会触发NullPointException
 */
object Test3_1{
  def main(args: Array[String]): Unit = {
    for(input <- Set("jack","test")){
      val maybeString = commentOnPractice(input)
      val dispaly = maybeString.getOrElse("hello")
      println(dispaly)
    }
  }

  def commentOnPractice(str: String)={
    if(str == "test") Some(str) else None
  }
}
