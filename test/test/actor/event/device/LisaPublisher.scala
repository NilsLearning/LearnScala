package test.actor.event.device

import akka.actor.Actor

class LisaPublisher(bus: LisaEventBus) extends Actor {

  def receive = {
    case v:LisaEvent => v.objectType match {
      case t: Device =>
        println(s"${self.path}+执行设备发布")
        bus.publish(v)
      case t: Asset =>
        println(s"${self.path}+执行积分发布")
        bus.publish(v)
    }
    case _ => None



  }

}

