package learning.day04

/**
 * 型变： +T 或 -T
 * +T 是"定义侧协变",而不是"使用侧协变"
 * -T 是"定义侧逆变",而不是"使用侧逆变"
 */
class Test6 {

}

class MyList[+T]  // +T 是告诉scala提供协变支持，意思就是在编译期间，scala会接受一个类型或者该类型的派生类型

class MyList1[-T] // -T是告诉scala提供逆变支持，意思就是在编译期间，scala会接受一个类型或者该类型的超类类型

object Test6_1{
  def main(args: Array[String]): Unit = {
    var list1 = new MyList[Int]
//    var list2: MyList[Any] = _
//    val list3: MyList[Nothing] = _
//    list1 = list3
//    list2 = list1

    var list4 = new MyList1[Int]
    val list5 = new MyList1[Any]
    list4 = list5

  }
}
