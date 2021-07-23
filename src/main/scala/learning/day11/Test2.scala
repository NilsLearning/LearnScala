package learning.day11

import akka.actor.{AbstractActor, Actor, ActorSystem, Props}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
 * 创建Actor
 * ----------------------------
 * scala使用来自Akka的Actor模型支持，Akka的Actor托管在一个ActorSystem种，它管理了线程，消息队列以及Actor的生命周期，
 * 相对于使用传统的new关键字来创建实例，我们使用了一种特殊的actorOf工厂方法来创建Actor，并将其对应的ActorRef赋值给了
 * 名为depp的引用。
 *
 * ---------------------------
 * Actor在不同的线程中运行，而不是调用代码的主线程
 * 每个Actor一次只处理一个消息
 * 多个Actor并发的运行，同时处理多个消息
 * Actor是异步的
 * 不会阻塞调用者，main方法直接运行了println方法，根本不会等待这些Actor的回复
 *
 */
class Test2 {

}

//class TestActor() extends AbstractActor{
////  override def createReceive: akka.actor.AbstractActor.Receive = {
////    case message => println(s"akka actor $message")
////  }
////}
case class Yang()
object CreateActors{
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("sample")
    val deep = system.actorOf(Props[TestActor1])
    val deep1 = system.actorOf(Props[TestActor1])
    deep ! Yang

    deep1 ! "WonKa1"
    Thread.sleep(100)
    deep ! "hello"
    deep1 ! "hello1"
    println(s"start+${Thread.currentThread()}")
    // 只要系统保持活跃，这个线程池就会一直保持活跃，如果要使该程序在main代码块执行完成之后关闭，就必须
    //调用ActorSystem的terminate方法
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