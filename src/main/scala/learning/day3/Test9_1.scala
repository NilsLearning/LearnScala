package learning.day3.Convert

/**
 * 在此使用了包对象 Convert对象
 * 这里的关键是在类中表明  package learning.day3.Convert
 * 在scala中大量使用了包对象，在所有的Scala代码中，scala包都会被自动导入，因此，scala这个包的包对象也会被导入，这个包对象包含了很多类型别名和隐式转换。
 * 在代码中使用List[T],它就会被自动指向scala.collection.immutable.List[A],这多亏了scala包对象中定义的一个别名
 */
object Test9_1{
  def main(args: Array[String]): Unit = {
    List("yang","qun")
    println(convert(1,"2"))
    println(convert1(1,"2"))
  }
}
