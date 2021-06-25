package learning.day3

import learning.day3.Cash.Cash

/**
 * 学习目标： 创建枚举类
 * Java中为了创建一个单例，要创建一个Enum，但是在scala中为了要创建一个Enum，需要创建一个单例（Object声明）
 */
class Test8 {

}

object Cash extends Enumeration{
  type Cash = Value
  val CNY,GBP,JPY = Value

  def main(args: Array[String]): Unit = {
    println(Cash.CNY)
    val money = new Money(2,Cash.GBP)
    println(money)
    Cash.values.foreach(o=>println(o))
  }
}

class Money(val amount: Int,val currency: Cash){
  override def toString: String = s"$amount $currency"
}




