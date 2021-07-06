package learning.day11

import java.io.File

/**
 * 学习目标：使用Actor编程
 *本节代码只是统计一个文件下有多少文件来说明IO执行的耗时情况，但是
 * 按照书中给出的例子，我没有执行成功
 */
class Test1 {

}
object Test1{
  def main(args: Array[String]): Unit = {
    val start = System.nanoTime
    val exploreFrom = new File("D:\\hello")

    var count = 0L
    var filesToVisit = List(exploreFrom)

    while (filesToVisit.nonEmpty) {
      val head = filesToVisit.head
      filesToVisit = filesToVisit.tail

      val children = getChildren(head)
      count = count + children.count { !_.isDirectory }
      filesToVisit = filesToVisit ::: children.filter { _.isDirectory }
    }

    val end = System.nanoTime
    println(s"Number of files found: $count")
    println(s"Time taken: ${(end - start) / 1.0e9} seconds")
  }

  def getChildren(file: File) = {
    val children = file.listFiles()
    if (children != null) children.toList else List()
  }



}