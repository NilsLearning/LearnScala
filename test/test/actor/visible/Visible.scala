package test.actor.visible

import akka.actor.Actor
import akka.event.Logging


class Visible extends Actor {
  val log = Logging(context.system, this)
  var state = 0

  def receive = {
    case "add" =>
      state = state + 1
      log.info("++++="+self.toString() + state)
    case "minus" =>
      state = state - 1
      log.info("----="+self.toString() + state)
    case "get" =>
      log.info("====="+self.toString() + state)
  }

//  override def preStart {
//    log.info("======actor:" + self.toString() + ",子 启动 .")
//  }
//
//  override def postStop {
//    log.info("======actor:" + self.toString() + ",子 停止 .")
//  }
//
//  override def preRestart(reason: Throwable, message: Option[Any]) {
//    log.info(
//      "======actor:" + self.toString() + ",子 预重启, reason:" + reason + ", message:" + message
//    )
//  }
//
//  override def postRestart(reason: Throwable) {
//    log.info("======actor:" + self.toString() + ",子 正式重启, reason:" + reason)
//  }
}
