package test.example

/**
 * 使用ScalaTest测试
 * 需要在build.sbt里面导入如下依赖：
 * libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
 */
class Test2 {

}
import java.util

import org.scalatest._
class UseScalaTest extends FlatSpec with Matchers{
   trait EmptyArrayList{
     val list = new util.ArrayList[String]
   }

  "a list" should "be empty on create" in new EmptyArrayList{
    list.size should be(0)
  }
}
