package learning.day14.actor

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, Props, ReceiveTimeout}
import akka.util.Timeout

import scala.concurrent.Await

//定义Actor类
class ParentActor extends Actor {
  println("start pActor ")

  def receive = {
    case ("newChild", name: String) => context.actorOf(Props[ChildActor], name)
    case ("stop", name: String) =>
      println("========================stop")
      implicit val resolveTimeout = Timeout(5, TimeUnit.SECONDS)
      val child = Await.result(
        context.actorSelection(self.path + "/" + name).resolveOne(),
        resolveTimeout.duration
      )
      context.stop(child)
    case ReceiveTimeout => throw new RuntimeException("received timeout"); // 每隔超时时间没收到消息就抛出异常
    case "suicide"      =>
    case x: Any         => println("received unknown message :" + x)
  }

  /**
   * 在 actor 实例化后执行,重启时不会执行
   */
  override def preStart {
    println("actor:" + self.path + ", parent preStart ")
  }

  /**
   * 在 actor 正常终止后执行,异常重启时不会执行。
   */
  override def postStop {
    println("actor:" + self.path + ",parent postStop .")
  }

  /**
   * 在 actor 异常重启前保存状态
   */
  override def preRestart(reason: Throwable, message: Option[Any]) {
    println(
      "actor:" + self.path + ", preRestart parent, reason:" + reason + ", message:" + message
    )
  }

  /**
   * 在 actor 异常重启后恢复状态
   */
  override def postRestart(reason: Throwable) {
    println("actor:" + self.path + ", postRestart parent, reason:" + reason)
  }
}
