package learning.day2

/**
 * 学习目标： scala的元组
 * 采用下划线加数字这种模式，表示我们在元组中想访问的元素或索引的位置，与集合不同，元组中索引的位置是从1开始的
 */
object Test3 {

  def yunzu(): (String, String, String) ={
    ("hello","je;","da")
  }

  def main(args:Array[String]): Unit ={
    val tuple = yunzu()
    print(tuple._1)
  }

}
