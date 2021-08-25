package test.actor.event.book

import akka.event.{ActorEventBus, EventBus, LookupClassification}

class AuthorBookBus(author: String) extends EventBus
  with LookupClassification
  with ActorEventBus {

  type Event = Book
  type Classifier = Boolean

  override def mapSize = 2

  override def classify(book: Book) = book.authors.contains(author)

  override protected def publish(book: Book, subscriber: Subscriber) = subscriber ! book
}