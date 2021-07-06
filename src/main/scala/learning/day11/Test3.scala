package learning.day11

import akka.actor.{Actor, ActorSystem, Props}
import akka.util.Timeout

import scala.collection.mutable
import scala.concurrent.Await

/**
 * 学习目标：Actor中隔离可变性
 *
 */
class Test3 {

}
case class Play(role:String)
case class ReportCount(role:String)

class TestActor2() extends Actor{
  val messageCount:mutable.Map[String,Int] = mutable.Map()
  def receive(): Receive = {
    // 第一种消息类型用于告诉Actor来扮演某一个角色
    case Play(role) =>
    val currentCount = messageCount.getOrElse(role,0)
    messageCount.update(role,currentCount+1)
    println(s"Playing $role")
    // 第二种消息类型用于查询Actor已经扮演过某一个角色的次数，如果消息类型是ReportCount，
      //则我们将会使用给定的角色作为键，读取对相应的值，并将其消息发送给当前的Sender
    case ReportCount(role) =>
    sender ! messageCount.getOrElse(role,0)
    println(s"ReportCount $role")
  }
}

object Test3_1{
  import akka.pattern._
  import akka.util.Timeout
  import scala.concurrent.duration._
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("sample")
    val deep  = system.actorOf(Props[TestActor2])
    val hanks = system.actorOf(Props[TestActor2])
    deep ! Play("Wonka")
    deep ! Play("nils")

    deep ! Play("Wonka")
    hanks ! Play("nils1")

    println("Send roles to play")
    implicit val timeout:Timeout = Timeout(5.seconds)
    // 不同于什么也不返回的！方法，？方法返回一个Future，并且这个ask方法需要设置一个超时时间
     val wonkaFuture = deep ? ReportCount("Wonka")
    val sparrowFuture = deep ? ReportCount("nils")
    val gumpFuture = hanks ? ReportCount("nils1")

    val wonkaCount = Await.result(wonkaFuture,timeout.duration)
    val sparrowCount = Await.result(sparrowFuture,timeout.duration)
    val gumpCount = Await.result(gumpFuture,timeout.duration)

    println(s"wonkafuture ${wonkaFuture.toString}")
    println(s"sparrowFuture ${sparrowFuture.toString}")
    println(s"gumpFuture ${gumpFuture.toString}")

    println(s"deep played $wonkaCount times")
    println(s"deep played $sparrowCount times")
    println(s"hank played $gumpCount times")
    val terminateFuture = system.terminate()
    Await.ready(terminateFuture,Duration.Inf)

  }
}