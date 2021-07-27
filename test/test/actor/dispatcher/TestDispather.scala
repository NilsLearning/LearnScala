package test.actor.dispatcher

import org.scalatest.FunSuite


class TestDispather extends FunSuite {

  /**
   */
  test("start") {

//    val system = ActorSystem("lpLocalSys")
//    val myDispatcher = system.dispatchers.lookup("my-dispatcher")
//    myDispatcher {
////      # Dispatcher is the name of the event-based dispatcher
//      type = Dispatcher
////      # What kind of ExecutionService to use
//        executor = "fork-join-executor"
////      # Configuration for the fork join pool
//        fork-join-executor {
//          # Min number of threads to cap factor-based parallelism number to
//            parallelism-min = 2
//          # Parallelism (threads) ... ceil(available processors * factor)
//          parallelism-factor = 2.0
//          # Max number of threads to cap factor-based parallelism number to
//            parallelism-max = 10
//        }
//      # Throughput defines the maximum number of messages to be
//      # processed per actor before the thread jumps to the next actor.
//      # Set to 1 for as fair as possible.
//      throughput = 100
//    }
//    // 通过Props方式创建父Actor
//    val pActor = system.actorOf(Props[ParentActor], name = "pActor")
//
//    pActor ! "test"

  }



}
