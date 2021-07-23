package learning.day14
class Test1 {

}


import akka.actor.Actor
import akka.event.{Logging, LoggingAdapter}
//定义Actor类
class MyActor extends Actor {
  val log: LoggingAdapter = Logging(context.system, this)

  def receive = {
    case "test" => log.info("received test")
    case _      => log.info("received unknown message")
  }
}