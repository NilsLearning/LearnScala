package learning.day14
class Demo1 {}

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.event.{Logging, LoggingAdapter}
import learning.day11.TestActor1

import scala.concurrent.Await
import scala.concurrent.duration.Duration
//定义Actor类
class MyActor extends Actor {

  def receive = {
    case "test" => println("received test")
    case _      => println("received unknown message")
  }
}
class MyActor1(name: String) extends Actor {
  def receive = {
    case "test" =>
      println("received test MyActor1=" + this.name)
    case _ => println("received unknown message")
  }
}
class MyActor2(firstName: String, lastName: String, age: Int) extends Actor {

  def receive = {
    case "test" =>
      println(
        "received test MyActor2==" + this.firstName + this.lastName,
        this.age
      )
    case _ => println("received unknown message")
  }
}
object MyActorRun {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("sample")
    val ref = system.actorOf(Props[ActorDemo1])
    val ref1 = system.actorOf(Props(new ActorDemo2("yang")))
    val ref2 = system.actorOf(Props(classOf[MyActor2], "yang", "qun", 123))
    ref ! "test"
    ref ! "actor"
    ref1 ! "test"
    ref2 ! "test"
  }
}
