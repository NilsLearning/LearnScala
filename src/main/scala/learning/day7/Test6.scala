package learning.day7

/**
 * 学习目标：SEQ
 */
class Test6 {}

object Test6 {
  def main(args: Array[String]): Unit = {
    var seq0 = scala.collection.immutable.Seq.empty
    val seq1 = scala.collection.immutable.Seq[Long](1, 2, 3)
    val seq2 = Seq(2, 3, 4)
    val ints = seq1 ++ seq2
    println("ints=====" + ints)
    val se1 = seq1 ++: seq2
    println("se1====="+se1)
    val seq4 = Seq(None,None)
    val v1  = seq4.foldLeft(0)((total, ele) => total)
    println("v1========"+v1)
  }
}
