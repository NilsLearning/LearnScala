package test.actor.event

import akka.actor.{ActorSystem, Props}
import org.scalatest.FunSuite


class TestEventBus extends FunSuite {
  /**
    * 测试消息总线
   */
  test("eventBus") {
    val system = ActorSystem("lpLocalSys")

    val testActor1 = system.actorOf(Props[EventActor], name = "actor1")
    val testActor2 = system.actorOf(Props[EventActor], name = "actor2")

    val lookupBus = new LookupBusImpl
    lookupBus.subscribe(testActor1, "greetings")
    lookupBus.subscribe(testActor2, "time")

    lookupBus.publish(MsgEnvelope("greetings", "hello"))
    lookupBus.publish(MsgEnvelope("time", System.currentTimeMillis()))
//    lookupBus.unsubscribe(testActor1)
    lookupBus.publish(MsgEnvelope("greetings", "hello```````"))
    lookupBus.publish(MsgEnvelope("time1", System.currentTimeMillis()))
//    expectMsg("hello")
  }

  test("eventBus1") {
    val system = ActorSystem("lpLocalSys")

    val testActor1 = system.actorOf(Props[EventActor], name = "actor1")
    val testActor2 = system.actorOf(Props[EventActor], name = "actor2")
    val testActor3 = system.actorOf(Props[EventActor], name = "actor3")

    val subchannelBus = new SubchannelBusImpl
    subchannelBus.subscribe(testActor1, "abc")
    subchannelBus.subscribe(testActor2, "abcdef")
    subchannelBus.subscribe(testActor1, "abcdefg")
//    subchannelBus.subscribe(testActor3, "abcdefg")
    subchannelBus.publish(MsgEnvelope("abc", "c"))
    subchannelBus.publish(MsgEnvelope("abcdef", "d"))
    subchannelBus.publish(MsgEnvelope("abcdef·", "d1"))
    subchannelBus.publish(MsgEnvelope("abc", "c1"))
    subchannelBus.publish(MsgEnvelope("abcdefg", "abcdefg"))
    subchannelBus.publish(MsgEnvelope("abc", "c2"))
    //    expectMsg("hello")
  }

  /**
   * 测试扫描分类法
   */
  test("ScanningClassification") {
    val system = ActorSystem("lpLocalSys")

    val testActor1 = system.actorOf(Props[EventActor], name = "actor1")
    val testActor2 = system.actorOf(Props[EventActor], name = "actor2")
    val testActor3 = system.actorOf(Props[EventActor], name = "actor3")

    val scanningBus = new ScanningBusImpl
    scanningBus.subscribe(testActor1, 3)
    scanningBus.subscribe(testActor2, 5)
    scanningBus.publish("xyzabc")
    scanningBus.publish("ab")
    scanningBus.publish("abc")
//        expectMsg("hello")



  }

}
