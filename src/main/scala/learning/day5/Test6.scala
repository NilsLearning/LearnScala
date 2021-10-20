package learning.day5

/**
 * 学习目标： 传名参数

 * boolAssert与byNameAssert的差异：
 * boolAssert圆括号中的表达式将先于对boolAssert的调用被求值，而由于
 * byNameAssert的flag参数类型是=> Boolean,在byNameAssert的圆括号中的表达式在
 * 调用byNameAssert之前不会被求值，而是会有一个函数值被创建出来，这个函数值的apply方法将会对1/0==0求值，传入
 * byNameAssert的是这个函数值
 */

object Test6{
  def main(args: Array[String]): Unit = {
//    boolAssert(1/0==0)
    byNameAssert(1/0==0)
  }

  /**
   * 常规函数写法
   * @param flag
   * @return
   */
  def boolAssert(flag:Boolean)={
    println("boolAssert")
  }

  /**
   * 传名参数写法
   */
  def byNameAssert(flag: => Boolean)={
      println("byNameAssert")

  }

}


