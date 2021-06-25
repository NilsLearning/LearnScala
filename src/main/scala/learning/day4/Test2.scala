package learning.day4

/**
 * 学习目标：Scala的类型树
 *
 * 1. Nothing类型在scala的类型验证机制的支持意义重大，如下面method方法
 *         Any
 *         /\
 *   ----------------
 *   /\             /\
 *  AnyRef         AnyVal
 *  /\              /\
 * 所有引用类型    值类型（Double，Int等）
 *  \/              \/
 *  -----------------
 *         \/
 *         Nothing
 */
class Test2 {

}

object Test2_2{
  def main(args: Array[String]): Unit = {
    method1(11)
  }

  /**
   * 在该方法中，throw语句的结果类型不能推断为Int类型而被任意处理，因为在任何地方都可能引发异常，Nothing类型这个时候就派上用场了，因为
   * 它是所有类型的子类型，所以它可以替代任何东西，Nothing是抽象的，因为在运行时永远都不会得到一个真正的Nothing实例，它是一个纯粹的辅助类型，
   * 用于类型推断以及类型验证
   * @param value
   * @return
   */
  def method1(value : Int)={
    if(value < 10)
      value * 2 else throw new RuntimeException
  }
}
