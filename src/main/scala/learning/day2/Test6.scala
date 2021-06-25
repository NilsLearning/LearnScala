package learning.day2

/**
 * 学习目标： 多行字符串
 *
 * 1.在scala中对于多行的字符串只需要放在一对3个双引号之中("""……"""),这是scala对所谓的here文档的支持
 * here文档--又成为heredoc,here字符串或here脚本，是一种在命令行shell和编程语言里定义一个字符串的方法，它可以保存文字里面的换行或是
 * 缩排等空白字符，一些编程语言允许在字串里执行变量替换和命令替换
 * 2.我们也可以使用RichString中的stripMargin()方法去除起始的空格，stripMargin方法将管道符号（|）前面的控制字符都去掉了,并且对于不是起始位置的管道符，
 * 3.s插值器和raw 插值器
 */
object Test6 {
  def main(args: Array[String]): Unit = {
    val str = """我们是多行字符串，里面保存"了大量原始文档"，欢迎使用"""
    println(str)
    val str1 =
      """aaaaaaaaaa]aaaaaaa
            ]   bbbbbbbbbbbbbbb
        ]ccccccccccc
        ]""".stripMargin(']')
    println(str1)
    val str2 =
      """aaaaaaaaaa|aaaaaaa
        |   bbbbbbbbbbbbbbb
        |ccccccccccc
        |""".stripMargin
    println(str2)

  }
}
