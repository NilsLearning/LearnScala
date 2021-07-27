package learning.day14.actor

import akka.actor.Actor


class ChildActor extends Actor {
  println("start ChildActor ")
  override def receive() = {
    case "abc"       => println(s"${self.path}" + "get abc string ")
    case "exception" => throw new NullPointerException()
    case _           => println("children cann't handle unknown message")
  }

  override def preStart {
    println("actor:" + self.path + ",child preStart .")
  }

  override def postStop {
    println("actor:" + self.path + ",child postStop .")
  }

  override def preRestart(reason: Throwable, message: Option[Any]) {
    println(
      "actor:" + self.path + ",preRestart child, reason:" + reason + ", message:" + message
    )
  }

  override def postRestart(reason: Throwable) {
    println("actor:" + self.path + ",postRestart child, reason:" + reason)
  }
}
