package learning.day14

class Demo3 {}

import akka.actor.{ActorSystem, Kill, Props}
import learning.day14.actor.ParentActor



object LifeCycleMainApp extends App {

  // 构建Actor系统
  val system = ActorSystem("lpLocalSys")

  // 通过Props方式创建父Actor
  val pActor = system.actorOf(Props[ParentActor], name = "pActor")

  pActor ! ("newChild", "child-1")
  pActor ! ("newChild", "child-2")
  pActor ! "test"

  val parent = system.actorSelection("akka://lpLocalSys/user/pActor")
  parent ! "test"
  //    parent ! ("stop", "child-2")

  val child2 = system.actorSelection("akka://lpLocalSys/user/pActor/child-2")
//  child2 ! Kill // 杀死 child2
      child2 ! "exception"
  Thread.sleep(5000) // 等待 child2  被杀死
  pActor ! ("newChild", "child-2")
//val teminal = system.terminate()
//  Await.ready(teminal,Duration.Inf)
}

