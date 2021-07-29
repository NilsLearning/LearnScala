package test.actor.dispatcher

import actor.dispatcher.DispatcherActor
import akka.actor.{ActorSystem, Props}
import org.scalatest.FunSuite


class TestDispatcher extends FunSuite {

  /**
   * 测试在不同调度器下线程处理消息的情况
   */
  test("TestDispatcher") {
    val system = ActorSystem("LocalSys")

    // 通过Props方式创建父Actor
    val pActor1 = system.actorOf(Props[DispatcherActor], name = "DispatcherActor1")
    val pActor2 = system.actorOf(Props[DispatcherActor], name = "DispatcherActor2")
    for(_ <- 1 to 20){
      pActor1 ! "hello"
    }
    for(_ <- 1 to 20){
      pActor2 ! "hello"
    }


  }



}
