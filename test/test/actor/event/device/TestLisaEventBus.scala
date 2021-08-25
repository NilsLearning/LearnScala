package test.actor.event.device

import akka.actor.{ActorSystem, Props}
import org.scalatest.FunSuite

class TestLisaEventBus extends FunSuite {
  /**
    * 测试消息总线
   */
  test("lisaEventBus") {

    implicit val system: ActorSystem = ActorSystem("publisher-subscribers-example")

    val lisaEventBus = new LisaEventBus
    val lisaPublisher = system.actorOf(Props(new LisaPublisher(lisaEventBus)), name = "lisa-publisher")

    val subscriber1 = system.actorOf(Props[LisaSubscriber], name = "subscriber-1")
    val subscriber2 = system.actorOf(Props[LisaSubscriber], name = "subscriber-2")

    lisaPublisher ! LisaEvent("device",Device("sn123","name123"))
    lisaPublisher ! LisaEvent("asset",Asset("add",Map("userName"->"yang")))
    lisaPublisher ! LisaEvent("book",Asset("add",Map("userName"->"yang")))


    lisaEventBus.subscribe(subscriber1, "device")
    lisaEventBus.subscribe(subscriber2, "asset")


//    bookPublisher ! Book(title = "A book title", authors = List(author, "Another Author"))
    // Yeah! Publishing a new book: Book(A book title,List(Author, Another Author))
    // My name is subscriber-1 and I have received a new book: Book(A book title,List(Author, Another Author))

//    bookPublisher ! Book(title = "Another book title", authors = List("Author","Another Author"))
    // Yeah! Publishing a new book: Book(Another book title,List(Another Author))
    // My name is subscriber-2 and I have received a new book: Book(Another book title,List(Another Author))
  }



}
