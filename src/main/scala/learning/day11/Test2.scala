package learning.day11

import akka.actor.{AbstractActor, Actor, ActorSystem, Props}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
 * 创建Actor
 * Actor在不同的线程中运行，而不是调用代码的主线程
 * 每个Actor一次只处理一个消息
 * 多个Actor并发的运行，同时处理多个消息
 * Actor是异步的
 * 不会阻塞调用者，main方法直接运行了println方法，根本不会等待这些Actor的回复
 */
class Test2 {

}

//class TestActor() extends AbstractActor{
////  override def createReceive: akka.actor.AbstractActor.Receive = {
////    case message => println(s"akka actor $message")
////  }
////}

object CreateActors{
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("sample")
    val deep = system.actorOf(Props[TestActor1])
    val deep1 = system.actorOf(Props[TestActor1])
    deep ! "WonKa"

    deep1 ! "WonKa1"
    Thread.sleep(100)
    deep ! "hello"
    deep1 ! "hello1"
    println(s"start+${Thread.currentThread()}")
    val teminal = system.terminate()
    Await.ready(teminal,Duration.Inf)
    println(s"end+${Thread.currentThread()}")
  }

}
class TestActor1() extends Actor{
  def receive(): Receive = {
    case message => println(s"akka actor $message - ${Thread.currentThread}")
  }
}