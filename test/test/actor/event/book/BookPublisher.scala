package test.actor.event.book

package test.actor.event.book

import akka.actor.Actor

class BookPublisher(bus: AuthorBookBus) extends Actor {

  def receive = {
    case book: Book =>
      println(s"BookPublisher=======${self.path}")
      println(s"Yeah! Publishing a new book: $book")
      bus.publish(book)
  }

}

