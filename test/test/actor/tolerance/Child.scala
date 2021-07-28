package test.actor.tolerance

import akka.actor.Actor
import akka.event.Logging


class Child extends Actor {
  val log = Logging(context.system, this)
  var state = 0

  def receive = {
    case "exception" =>
      throw new NullPointerException()
    case x: Int =>
      log.info("======state=" + x)
    case "get" => sender() ! state
  }

  override def preStart {
    log.info("======actor:" + self.toString() + ",子 启动 .")
  }

  override def postStop {
    log.info("======actor:" + self.toString() + ",子 停止 .")
  }

  override def preRestart(reason: Throwable, message: Option[Any]) {
    log.info(
      "======actor:" + self.toString() + ",子 预重启, reason:" + reason + ", message:" + message
    )
  }

  override def postRestart(reason: Throwable) {
    log.info("======actor:" + self.toString() + ",子 正式重启, reason:" + reason)
  }
}
