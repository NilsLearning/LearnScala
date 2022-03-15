package learning.day02

/**
 * 学习目标： 操作符重载
 * 注意：在scala中没有操作符并不能免去处理操作符优先级的需要，
 * 例如+ - 与* /的优先级比较，即使重新定义，* /的优先级仍然比 + -高，对于两个字符的优先级相同，那么在左边的方法优先级更高
 */
object Test7 {
  def main(args: Array[String]): Unit = {
    val v1 = new Complex(2,3)
    val v2 = new Complex(3,-4)
    println(v1 + v2)
  }
}

// 这里如果对Complex里面的变量如果不使用val声明，则会出现错误 --value real is not a member of learning.day2.Complex
//    new Complex(real + operand.real,imaginary + operand.imaginary
class Complex(val real:Int,val imaginary:Int){
  def + (operand: Complex) : Complex ={
    // 这里的加号还用的是Predef里面的加号
    new Complex(real + operand.real,imaginary + operand.imaginary)
  }
  override def toString: String ={
    val sign = if(imaginary < 0) "" else "+"
    s"$real$sign$imaginary"
  }

}

