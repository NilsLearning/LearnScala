package learning.day2
import scala.Predef
/**
  * 学习目标：体验scala如何减少样板代码的书写
  * 1.体验scala的类型推断，在这个demo中i作为整数无需声明，即可使用
  * 2.减少噪声，少了很多的分号
  * 3.在scala中，如果方法没有参数，或者只有一个参数，就可以省略点号和括号，如果一个方法带有多个参数，则必须使用括号，但是点号是可选的
 *  4.支持脚本（不是所有的代码需要放到一个类中）
 *  5.return是可选的
 *  6.类和方法是可选的
 *  7.scala按照顺序导入下面的包和类，
 *    java.lang,
 *    scala,
 *     scala.Predef
  */
object Test1 {
  def main(args: Array[String]) {

    /**
      * 箭头的左边(<-)定义了一个val，右边是一个生成器表达式,在1 to 3执行的过程中，代码其实是创建了一个不同的名为i的val的变量
      * to()是一个方法，to方法实际上都是RichInt上的方法（富封装器），变量i的类型为Int，被隐式转换为RichInt，因此，1 to 3 等价于 1.to(3)
      */
    for (i <- 1 to 3)
      //      println(i)
      // 采用字符串插值（语法形如S"……${expression}……")
      print(s"$i,")
    print("hello")
  }

  /**
  * 学习目标： val定义的变量的不可变性解读
  * 不可变性作用在变量上，而不是作用在变量所引用的实例上
  * 例如： val buffer = new StringBuffer()，就不能改变buffer的引用，但是我们可以使用StringBuffer的方法append去修改所引用的实例
  *     而 val str = new String，就代表了引用不可变，实例也是没有办法改变的
  *     所以使用val声明的变量，不能假定它完全不可变
  *
  */






}
