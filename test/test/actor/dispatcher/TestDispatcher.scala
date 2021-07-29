package test.actor.dispatcher

import actor.dispatcher.DispatcherActor
import akka.actor.{ActorSystem, Props}
import org.scalatest.FunSuite


class TestDispatcher extends FunSuite {

  /**
   */
  test("TestDispatcher") {
    val system = ActorSystem("LocalSys")

    // 通过Props方式创建父Actor
    val pActor1 = system.actorOf(Props[DispatcherActor], name = "DispatcherActor1")
    val pActor2 = system.actorOf(Props[DispatcherActor], name = "DispatcherActor2")
    for(i <- 1 to 20){
      pActor1 ! "hello"
    }
    for(i <- 1 to 20){
      pActor2 ! "hello"
    }


  }



}
