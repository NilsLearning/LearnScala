package learning.day11

import java.io.File

/**
 * 学习目标：使用Actor编程
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