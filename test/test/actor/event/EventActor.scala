package test.actor.event

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ReceiveTimeout}
import akka.event.Logging
import akka.util.Timeout

import scala.concurrent.Await

//定义Actor类
class EventActor extends Actor  {
  val log = Logging(context.system, this)

  def receive = {
    case ("newChild", name: String) => println("")
    case ("stop", name: String) =>
      implicit val resolveTimeout = Timeout(5, TimeUnit.SECONDS)
      val child = Await.result(
        context.actorSelection(self.path + "/" + name).resolveOne(),
        resolveTimeout.duration
      )
      context.stop(child)
    case ReceiveTimeout => throw new RuntimeException("======received timeout"); // 每隔超时时间没收到消息就抛出异常
    case "exception" => throw new NullPointerException()
    case "suicide"      =>
    case x: Any         => println("")
  }


}
