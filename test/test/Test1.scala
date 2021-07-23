package test

class Test1 {}

/**
  * 使用Junit测试
  * 需要在build.sbt里面添加以下依赖：
  * libraryDependencies += "junit" % "junit" % "4.12" % "test"
  */
import org.junit.Test
import org.junit.Assert._
import org.scalatest.FunSuite

class UsingJunit {

  @Test
  def listAdd(): Unit = {
    val list = List(1, 2, 3)
    assertEquals(3, list.size)
//    list.map{a=>
//      println(a)
//    }
  }
}

class Base64Test extends FunSuite {

  test("base64") {
    println("hello test")
  }
}
