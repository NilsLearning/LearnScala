package test.actor.tolerance

import akka.actor.{ActorSystem, Props}
import org.scalatest.FunSuite


/**
 * 测试监督模式
 */
class TestSupervisor extends FunSuite {

  /**
   * 演示功能点：
   * 1.子异常被父级Actor监视到并进行处理
   * 2.父级Actor在没有重写preRestart方法的情况下，会在重启期间掐死自己所有的孩子
   */
  test("TestSupervisor1") {
    val system = ActorSystem("LocalSys")
    val supervisor = system.actorOf(Props[Supervisor1], "supervisor")

    supervisor !  ("newChild", "child1")
    supervisor !  ("newChild", "child2")
    supervisor !  ("newChild", "child3")
    val child1 = system.actorSelection("akka://LocalSys/user/supervisor/child1")
    val child2 = system.actorSelection("akka://LocalSys/user/supervisor/child2")
    val child3 = system.actorSelection("akka://LocalSys/user/supervisor/child3")
    child1 ! "exception"
    child2 ! 2
    child3 ! 3
  }

  /**
   * 演示功能点：
   * 1.父级Actor在重写preRestart方法的情况下，重启期间也会将自己的孩子救活
   */
  test("TestSupervisor2") {
    val system = ActorSystem("LocalSys")
    val supervisor = system.actorOf(Props[Supervisor2], "supervisor")

    supervisor !  ("newChild", "child1")
    supervisor !  ("newChild", "child2")
    supervisor !  ("newChild", "child3")
    val child1 = system.actorSelection("akka://LocalSys/user/supervisor/child1")
    val child2 = system.actorSelection("akka://LocalSys/user/supervisor/child2")
    val child3 = system.actorSelection("akka://LocalSys/user/supervisor/child3")
    child1 ! "exception"
    child2 ! 2
    child3 ! 3
  }
}
