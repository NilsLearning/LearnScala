package actor.dispatcher

import akka.actor.Actor
import akka.event.Logging

//定义Actor类
class DispatcherActor extends Actor  {
  val log = Logging(context.system, this)

  def receive = {
    case "hello"      => log.info("======hello===" +self.path+"=="+ Thread.currentThread().getName)
    case "hello1"      => log.info("======hello1===" +self.path+"=="+ Thread.currentThread().getName)
    case x: Any        => log.info("======received unknown message :" + x)
  }

  /**
   * 在 actor 实例化后执行,重启时不会执行
   */
//  override def preStart {
//    log.info("======actor:" + self.toString() + ", DispatcherActor preStart ")
//  }
//
//  /**
//   * 在 actor 正常终止后执行,异常重启时不会执行。
//   */
//  override def postStop {
//    log.info("======actor:" + self.toString() + ",DispatcherActor postStop .")
//  }
//
//  /**
//   * 在 actor 异常重启前保存状态
//   */
//  override def preRestart(reason: Throwable, message: Option[Any]) {
//    log.info(
//      "======actor:" + self.toString() + ", preRestart DispatcherActor, reason:" + reason + ", message:" + message
//    )
//  }
//
//  /**
//   * 在 actor 异常重启后恢复状态
//   */
//  override def postRestart(reason: Throwable) {
//    log.info("======actor:" + self.toString() + ", postRestart DispatcherActor, reason:" + reason)
//  }
}
