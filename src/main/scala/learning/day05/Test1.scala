package learning.day05

/**
 * 学习目标： 函数
 * i => i
 * => 的左边是参数列表，右边是输出的结果
 * 使用函数值就很容易使代码符合DRY( Don't Repest Yourself)原则

 *
 */
class Test1 {

}

object Test1_1{
  def main(args: Array[String]): Unit = {
//    print(sum(2))
//    println(toMethod(2,i=>2*i))
//    println(toMethod(2,i=>i))
//    println(toMethod(2,i=> if(i%2==0) i else 0))
//    zeroMethod(()=>42)
//    twoMethod(3,2,(i,j)=>i*j)
//    zeroMethod1(42)
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

  def sum(number:Int) ={
    var result =0
    for(i <- 1 to number){
      result += i
    }
    result
  }

  def toMethod(num:Int, codeBlock: Int => Int) ={
    var result = 0
    for(i <- 1 to num){
      result += codeBlock(i)
    }
    result
  }

  /**
   * 定义一个0参数的函数方法
   */
  def zeroMethod(zero: ()=>Int)={
    println(s"${zero()}")
  }

  def zeroMethod1(zero: =>Int)={
    println(s"${zero}")
  }

  val assertionsEnable = true

  def myAssert(predicate:() => Boolean)={
    if(assertionsEnable && !predicate())
      throw new AssertionError
  }

  def myAssert1(predicate: => Boolean)={
    if(assertionsEnable && ! predicate)
      throw new AssertionError
  }


  def twoMethod(month:Int,day:Int,two: (Int,Int) =>Int): Unit ={
    println(two(month,day))
  }
}


