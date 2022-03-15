package learning.day07

/**
 * 学习目标：Set
 * 集合叠加， 找出相同部分， 改变set中的元素
 */
class Test1 {

}

object Test1_1{
  def main(args: Array[String]): Unit = {
    val set1 = Set(1,2,3)
    val set2 = Set(4,2,3)
    // 合并set，使用++方法
    val set3 = set1 ++ set2
    print(set3.toString())
    // 找出两个set中相同的部分
    val set4 = set1 & set2
    print(set4)
    // 改变set中的元素,这里是给set中的每一个元素加4
    val set5 = set1.map(_+4)
    print(set5)
    set1.foreach(Int=>print(Int*10))
  }
}