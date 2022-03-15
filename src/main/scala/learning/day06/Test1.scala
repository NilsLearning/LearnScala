package learning.day06

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

/**
 * 学习目标： 特质
 * 名词： 选择性混入，延迟绑定
 */
class Test1 {

}

object Test1_1{


  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global


  def main(args: Array[String]): Unit = {
    Await.result(test1_2,Duration.Inf)
  }

  def test1_2={
    val f = Future{Seq(1,2,3)}
    f.flatMap(o=>
      Future(println("hello"+s"o==${o.toString()}"),o))
  }

}
