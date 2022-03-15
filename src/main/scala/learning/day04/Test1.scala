package learning.day04

import java._
/**
 * 学习目标： scala的类型推断
 */
class Test1 {

}

object Test1_1{
  def main(args: Array[String]): Unit = {
    var list1 = new util.ArrayList[Int]
    var list2 = new util.ArrayList[Any]
    //在这里 list2 =list1会发生编译报错的情况，这是因为scala不允许将一个元素类型为任意类型的集合赋值给一个指向元素类型为Any的集合
//    list2 =list1

//    var ref1 : Int = 1
//    var ref2 : Any = _
//    ref2 = ref1
  }
}
