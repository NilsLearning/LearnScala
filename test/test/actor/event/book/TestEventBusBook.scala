package test.actor.event.book

import akka.actor.{ActorSystem, Props}
import org.scalatest.FunSuite
import test.actor.event.book.BookPublisher

class TestEventBusBook extends FunSuite {
  /**
    * 测试消息总线
   */
  test("eventBusBook") {

    implicit val system: ActorSystem = ActorSystem("publisher-subscribers-example")

    val author = "Author"

    val authorBookBus = new AuthorBookBus(author)
    val bookPublisher = system.actorOf(Props(new BookPublisher(authorBookBus)), name = "book-publisher")

    val subscriber1 = system.actorOf(Props[BookSubscriber], name = "subscriber-1")
    val subscriber2 = system.actorOf(Props[BookSubscriber], name = "subscriber-2")

//    authorBookBus.subscribe(subscriber1, true)
    authorBookBus.subscribe(subscriber2, true)

    bookPublisher ! Book(title = "A book title", authors = List(author, "Another Author"))
    // Yeah! Publishing a new book: Book(A book title,List(Author, Another Author))
    // My name is subscriber-1 and I have received a new book: Book(A book title,List(Author, Another Author))

    bookPublisher ! Book(title = "Another book title", authors = List("Author","Another Author"))
    // Yeah! Publishing a new book: Book(Another book title,List(Another Author))
    // My name is subscriber-2 and I have received a new book: Book(Another book title,List(Another Author))
  }



}
