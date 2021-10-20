package learning.day9

/**
 * 学习目标： 递归
 * 尾部递归的调用进行自动优化--通过使用迭代的方式而不是递归
 * scala编译器能够检测到尾递归并将它替换成跳转到函数的最开始，并在跳转之前将参数更新为新的值
 * 尾递归函数并不会在每次调用时构建一个新的栈帧，所有的调用都会在同一个栈帧中执行
 * 注意：Scala中使用尾递归是比较受限的，因为用JVM指令集实现更高形式的尾递归非常困难，scala只能对那些直接尾递归调用自己的函数做优化，
 * 如果递归调用是间接的，Scala就没法优化它们
 * 蹦床调用--
 */
class Test1 {

  def approximate(guess:Double):Double={
    if(isGoodEnough(guess)) guess
    else approximate(improve(guess))
  }

  def isGoodEnough(guess: Double): Boolean = false



  def improve(d: Double): Double ={
    d
  }

  def boom(x:Int):Int={
    if (x==0) throw new Exception("boom")
    else boom(x-1) +1
  }
}
