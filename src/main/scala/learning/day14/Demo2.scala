package learning.day14

class Demo2 {}

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

//定义Actor类
class ActorDemo1 extends Actor {

  def receive = {
    case "test" => println(s"${self.path}")
    case _      => println("received unknown message")
  }
}
class ActorDemo2(name: String) extends Actor {
  val child = context.actorOf(Props[ActorDemo1](), name = "myChild")
  def receive = {
    case x =>
      sender() ! x
      println("test ActorDemo2==="+s"${self.path}")
  }
}

object ActorDemoRun {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("sample")
    val ref = system.actorOf(Props[ActorDemo1])
    val ref1 = system.actorOf(Props[ActorDemo1](),"yang")
    val ref2 = system.actorOf(Props(new ActorDemo2("yang")))
    ref ! "test"
    ref1 ! "test"
    ref2 ! "test"

  }
}
