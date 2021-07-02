package learning.day7

/**
 * 学习目标： List
 * 在scala的标准库中，默认的List的实现只有两个子集，即Nil和::,其中Nil代表空列表，而::代表一个非空列表，并且由一个头部
 * （head）和尾部（tail）组成，尾部又是一个List
 * 1.list(0)其实是list.apply(0)的又一个简单的形式
 * 2.a::list的意思是将一个a元素放在当前List前面,会生成一个新集合
 * 3.list:::list1的意思是将list前插入到list1中,为什么scala中采用的头插法，这是因为与遍历到最后一个元素相比，访问头部元素要快的多，事半功倍
 * 4.使用filter可以对元素进行条件过滤
 * 5.使用forAll可以判定所有元素中是否又满足条件的结果，返回的是布尔量
 * 6.使用exists可以集合中任意元素是否满足条件，返回的是布尔
 * 7.foldLeft()方法将从列表的左侧开始，为列表中的每个元素调用给定的函数值（代码块），它将两个元素传递给函数值，第一个元素
 *  是使用（该列表中的）前一个元素执行该函数数值得到的部分结果，这就是为何称其为折叠（folding），第二个元素是列表中的一个元素，部分
 *  结果的初始值被称作为该方法的参数提供（在这个例子中是0），foldLeft方法形成了一个元素链，并在该函数值中将计算结果得到的部分结果值，
 *  从左边开始，从一个元素携带到下一个元素，类似的，foldRight是从右边开始
 * 8。foldLeft提供的符号表示为 /:(),foldRight提供的符号表示为\:()
 */
class Test3 {

}

object Test3_1{
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3)
    val i = list(0)
    val ii = list.head
    println(i)
    println(ii)
    val a = 5
    val list1 = a::list
    println(list.toString())
    println(list1.toString())
    val list2 = List(4,5)
    val list3 = list ::: list2
    val list4 = list2 ::: list
    println(list3)
    println(list4)
    val bool = list.forall(_ > 5)
    println(bool)
    val bool1 = list.exists(_ > 2)
    println(bool1)
    val i1 = list.foldLeft(0)((total, ele) => total + ele)
    println(i1)
    val i2 = (0 /: list) (_ + _)
    println(i2)
  }
}
