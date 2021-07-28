package test.actor.visible

import akka.actor.{ActorSystem, Props}
import org.scalatest.FunSuite

class TestVisible extends FunSuite {

  /**
   * 测试Actor中的“发生在先”规则
   */
  test("visible") {
    val system = ActorSystem("LocalSys")
    val visitation1 = system.actorOf(Props[Visible], "Visible1")
    val visitation2 = system.actorOf(Props[Visible], "Visible2")
    visitation1 ! "add"
    visitation1 ! "add"
    visitation1 ! "add"
    visitation1 ! "add"
    visitation1 ! "minus"
    visitation1 ! "get"
//    Thread.sleep(5000)
    visitation2 ! "get"
  }


  test("Visible1") {
    val system = ActorSystem("LocalSys")
    val visitation1 = system.actorOf(Props[Visible], "Visible")
    val visitation2 = system.actorOf(Props[Visible], "Visible")
    val visitation3 = system.actorOf(Props[Visible], "Visible")

    for(i <- 1 to 100){
      visitation1 ! "add"
    }
    for(i <- 1 to 100){
      visitation2 ! "add"
    }
  }
}