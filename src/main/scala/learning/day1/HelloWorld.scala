//package learning.day1
//
//import scala.concurrent.Future
//
//object HelloWorld {
//  def calc(x: Int): Int = x + 2
//
//  def main(args: Array[String]): Unit = {
////    val list = Await.result(test(),Duration.Inf)
//////    val list = Await.result(test(),Duration.Inf)
////    list.map(x => {
//////      println("1233")
////      println(x)
////    })
//
////    val eventualStrings = test()
////    val eventualStrings1 = eventualStrings.flatMap(x => {
////        test1(x)
////    })
////    val eventualStrings2 = eventualStrings.flatMap(x => {
//////      test3(x)
////
////            // x.
////            // flatMap(y=>{ y match{
////            //   case Some(y) =>test3(y)
////            //   case _ =>
////            // }
////            // })
////    })
//
////    Thread.sleep(5000)
////    println(eventualStrings1.value)
////    val list = List(1,2,3)
////    val list1 = List("uangh","da")
////    val seq = Seq(list,list1)
////    println(seq.flatten)
//      val seqList = Seq((1,2),(2,3))
//      print(seqList.toMap)
//  }
//
//  def test(): Future[List[String]] ={
//    Future(List("yang", "qin", "hu", "tao", "liu", "uhu"))
//  }
//  def test1(strs:List[String]): Future[List[String]] ={
//    Future(strs.flatMap(x=>{
//      test2(x)
//    }))
//  }
//  def test2(str:String): List[String] ={
//    List(str+"1")
//  }
//  def test3(str:String): Future[List[String]] ={
//    Future(List(str+"1"))
//  }
//
////  def test() {
////    Future(
////      print("1")
////      )
////  }
//
//  //   print(str.indexOf("0x"))
//}
