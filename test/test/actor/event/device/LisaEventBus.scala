package test.actor.event.device

import akka.event.{ActorEventBus, EventBus, LookupClassification}

class LisaEventBus extends EventBus
  with LookupClassification
  with ActorEventBus {

  type Event = LisaEvent
  override type Classifier = String
  override protected def mapSize(): Int = 128

  override protected def classify(event: LisaEvent) = {
    println("========" + event.topic)
    event.topic
  }

  override protected def publish(lisaEvent: LisaEvent, subscriber: Subscriber) = subscriber ! lisaEvent


}