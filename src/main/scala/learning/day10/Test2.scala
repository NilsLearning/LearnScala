package learning.day10

/**
 * 学习目标： 释放严格集合惰性
 * view方法 and stream流--天然的惰性，按需生产值
 */
class Test2 {

}

case class People(age:Int,name:String)

object Test2_1{

  def main(args: Array[String]): Unit = {
   method()

  }
  // 找出list集合元素中字母y开头并且年龄大于10的人
  def method()={
    val list = List((12,"yang"),(8,"qun"),(3,"nils"),(22,"y1ng"))
    // 第一次isOldThan10方法对集合中所有的元素进行计算，后得出筛选结果后再进行nameStartByY方法执行
    println(list.filter { isOldThan10 }. filter{nameStartByY}.head)
    // 使用view方法获取一个严格集合的惰性视图，进而加快检索效率
    println("===================")
    println(list.view.filter { isOldThan10 }. filter{nameStartByY}.head)
  }

  def isOldThan10(people: (Int,String))={
    println("isOldThan10"+s"$people")
    val (age,_) = people
    age>10
  }
  def nameStartByY(people: (Int,String))={
    println("nameStartByY()"+s"$people")
    val (_,name) =people
    name.startsWith("y")
  }
}

/**
 * 流：按需要生成
 */
object Test2_2{
  def main(args: Array[String]): Unit = {
    println(generate(25))
    // 不要在服务器上调用force方法，否则无论你有多少内存，都将被耗尽
    println(generate(25).take(10).force)
  }
  def generate(starting: Int):Stream[Int] ={
    starting #:: generate(starting+1)
  }
}

/**
 * 流的另外一个特性：它们记住我们已经生成的值
 * 原理就是，将耗时的函数调用结果缓存起来，然后在同样的输入再次产生时，直接返回已经缓存的调用结果，该技术乘坐memorization，一种加速计算的优化技术
 */
object Test2_3{
  def isDivisibleBy(number:Int,divisor:Int)= {
//    println(s"[$number,$divisor]")
    number % divisor ==0
  }

  def isPrime(number:Int)=number >1 && !(2 until number).exists{isDivisibleBy(number,_)}

  def primes(starting:Int):Stream[Int] ={
    println(s"computing is $starting")
    if(isPrime(starting))
      starting #:: primes(starting+1)
    else
      primes(starting+1)
  }

  def main(args: Array[String]): Unit = {
    val ints = primes(5)
    val ints1 = primes(3)
    println(ints.take(3).force)
    println("let's take more=======")
    println(ints1.take(4).force)
  }
}