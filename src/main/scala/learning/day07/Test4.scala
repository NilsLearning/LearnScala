package learning.day07

/**
 * 方法名约定： scala并没有（原生的）操作符，操作符就是方法
 * 如果方法名以: 结尾，那么调用的目标是该操作符号后面的实例，scala不允许使用字母作为操作符的名称，除非使用下划线对该操作符增加前缀，
 * 因此，一个名为jumpOver:()的方法名被拒绝的，但是可以使用jumpOver_:()则可以被接受
 * 也就是说，a.fun(b)这种调用通过添加冒号的方式变成 a.fun:(b),也就是b fun: a
 */
class Test4 {}

object Test4_1 {
  def main(args: Array[String]): Unit = {
    val cow = new Cow
    val moon = new Moon
    cow ~ moon
    moon.~:(cow)
    cow ~: moon

    val sample = new Sample
    +sample
    -sample

  }
}

class Cow {
  def ~(moon: Moon) = {
    println("hello cow")
  }
}

class Moon {
  def ~:(cow: Cow): Unit = {
    println("hello Moon")
  }
}

/**
 * 其中一元+操作符被映射为对unary_+()方法的调用
 * 而一元-操作符被映射为对unary_-()方法的调用
 */
class Sample{
  def unary_+()= println("unary_+")
  def unary_-()= println("unary_-")

}