package test.example

import org.scalatest.FunSuite

class Test3 {

}

class Base64Test extends FunSuite {

  test("children") {

    val inner1 = Circle(Seq.empty, "inner1")
    val inner2 = Circle(Seq.empty, "inner2")
    val inner3 = Circle(Seq.empty, "inner3")
    val out1 = Circle(Seq(inner1,inner2), "out1")
    val out2 = Circle(Seq(inner3), "out2")
    val list = Seq(out1,out2)
    val list1 = Seq.empty[Circle]

    printlist(list1)
    printlist(list)
  }

  private def printlist(list: Seq[Circle]) = {
    val inner11 = "inner1"
    val out = list.flatMap { list =>
      list.circle.map { inner =>
        inner.name
      }
    }
    if(out.contains(inner11)){
      print("true")
    }else{
      print("false")
    }
    println(out)
  }
}

case class Circle(
                   circle: Seq[Circle],
                   name: String
                 )