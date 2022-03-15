package learning.day03

class PoliceOfficer(val name: String)

/**
 * 学习目标： 别名
 * 给一个类取别名
 */
object Test2 {
  def main(args: Array[String]): Unit = {
    type Cop = PoliceOfficer
    val cop1 = new Cop("nils")
    println(cop1.getClass)
    // 以上输出的结果是： class learning.day3.PoliceOfficer
  }
}
