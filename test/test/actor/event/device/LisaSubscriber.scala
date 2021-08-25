package test.actor.event.device

import akka.actor.Actor

class LisaSubscriber extends Actor {

  def receive = {
    case v: LisaEvent => v.objectType match {
      case t: Device =>
        println(s"${self.path}+执行设备订阅")
      case t: Asset =>
        println(s"${self.path}+执行积分订阅")
    }
    case _ => None
  }
}
