package test.actor.life

import java.io.{File, PrintWriter}

import akka.actor.Actor
import akka.event.Logging


class ChildActor extends Actor {
  val log = Logging(context.system, this)
  log.info("======start ChildActor ")
  override def receive() = {
    case "abc"       => log.info(s"======${self.path}  " + "get abc string ")
    case "writeFile" =>
      val writer = new PrintWriter(new File(s"D:\\item.txt"))
      for (i <- 1 to 1000)
        writer.println(i)
      writer.close()
      log.info("======writeFileEnd***********.")
    case "exception" => throw new NullPointerException()
    case _           => log.info("======children cann't handle unknown message")
  }

  override def preStart {
    log.info("======actor:" + self.path + ",child preStart .")
  }

  override def postStop {
    log.info("======actor:" + self.path + ",child postStop .")
  }

  override def preRestart(reason: Throwable, message: Option[Any]) {
    log.info(
      "======actor:" + self.path + ",preRestart child, reason:" + reason + ", message:" + message
    )
  }

  override def postRestart(reason: Throwable) {
    log.info("======actor:" + self.path + ",postRestart child, reason:" + reason)
  }
}
