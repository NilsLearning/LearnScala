package test.actor.life

import java.util.concurrent.TimeUnit

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import org.scalatest.FunSuite
import test.actor.base.ParentActor

import scala.concurrent.Await


class TestLifeCycle extends FunSuite {

  /**
   * 启动Start策略：
   * 当Akka通过Props构建一个Actor后，会调用构造函数，之后调用prestart
   */
  test("start") {

    val system = ActorSystem("lpLocalSys")

    // 通过Props方式创建父Actor
    val pActor = system.actorOf(Props[ParentActor], name = "pActor")

    pActor ! "test"

  }

  /**
   * 停止Stop策略，该过程分为两步：
   * 1)Actor将挂起对邮箱的处理，并向所有子Actor发送终止命令，然后处理来自子Actor的终止消息直到所有的子Actor都完成终止
   * 2)终止自己，调用postStop方法，清空邮箱，向DeathWatch发布Terminated，通知其监管者
   */
  test("stop") {

    val system = ActorSystem("lpLocalSys")

    val pActor = system.actorOf(Props[ParentActor], name = "pActor")

    pActor ! ("newChild", "child-1")
    pActor ! ("newChild", "child-2")
    val child2 = system.actorSelection("akka://lpLocalSys/user/pActor/child-2")
    child2 ! "writeFile"
    implicit val resolveTimeout = Timeout(20, TimeUnit.SECONDS)
    val parent = Await.result(system.actorSelection("akka://lpLocalSys/user/pActor").resolveOne(),
      resolveTimeout.duration)
    system.stop(parent)
  }

  /**
   *  Restart策略:
   *  1.actor被挂起;
   *  2.调用旧实例的supervisionStrategy.handleSupervisorFailing方法（缺省实现为挂起所有的子actor）;
   *  3.调用preRestart方法，从上面的源码可以看出来，preRestart方法将所有的children stop掉了！（Stop动作，大家注意！），并调用postStop回收资源;
   *  4.调用旧实例的supervisionStrategy.handleSupervisorRestarted方法（缺省实现为向所有剩下的子actor发送重启请求）;
   *  5.等待所有子actor终止直到preRestart最终结束;
   *  6.再次调用之前提供的actor工厂创建新的actor实例;
   *  7.对新实例调用postRestart;
   *  8.恢复运行新的actor
   */
  test("restart") {

    val system = ActorSystem("lpLocalSys")

    val pActor = system.actorOf(Props[ParentActor], name = "pActor")

    pActor ! ("newChild", "child")
    // 父Actor抛出异常
    pActor ! "exception"
    val child = system.actorSelection("akka://lpLocalSys/user/pActor/child")
    Thread.sleep(10000) // 等待旧实例child2被挂起
    child ! "abc"
    //    val teminal = system.terminate()
    //      Await.ready(teminal,Duration.Inf)
  }


}
