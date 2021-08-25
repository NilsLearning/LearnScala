package test.actor.event.book

import akka.actor.Actor

class BookSubscriber extends Actor {

  def receive = {
    case book: Book =>
      println(s"BookSubscriber=======${self.path}")
      println(s"My name is ${self.path.name} and I have received a new book: $book")
  }
}
