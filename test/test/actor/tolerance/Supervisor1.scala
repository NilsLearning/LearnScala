package test.actor.tolerance

import akka.actor.{Actor, Props}
import akka.event.Logging

class Supervisor1 extends Actor {
  val log = Logging(context.system, this)

  import akka.actor.OneForOneStrategy
  import akka.actor.SupervisorStrategy._
  import scala.concurrent.duration._

  /**
   * Escalate 的意思是上报自己的异常到ActorSystem的顶级actor
   * 监管者自己是被ActorSystem的顶级actor所监管的，
   * 顶级actor的缺省策略是对所有的Exception情况（注意ActorInitializationException和ActorKilledException例外）进行重启.
   * 由于缺省的重启指令会杀死所有的子actor，所以我们知道（期望）可怜的子actor最终无法从这个失败中幸免
   */
  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 5, withinTimeRange = 50 second) {
      case _: ArithmeticException => Resume
      case _: NullPointerException =>
        log.info("======执行停止子Actor.")
        Escalate
      case _: IllegalArgumentException => Stop
      case _: Exception => Escalate
    }

  def receive = {
    case p: Props => sender() ! context.actorOf(p)
    case ("newChild", name: String) => context.actorOf(Props[Child], name)
  }

  override def preStart {
    log.info("======actor:" + self.toString() + ", 监视者 启动 ")
  }
}

class Supervisor2 extends Actor {
  val log = Logging(context.system, this)

  import akka.actor.OneForOneStrategy
  import akka.actor.SupervisorStrategy._
  import scala.concurrent.duration._

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 5, withinTimeRange = 50 second) {
      case _: ArithmeticException => Resume
      case _: NullPointerException =>
        log.info("======执行停止子Actor.")
        Escalate
      case _: IllegalArgumentException => Stop
      case _: Exception => Escalate
    }

  def receive = {
    case p: Props => sender() ! context.actorOf(p)
    case ("newChild", name: String) => context.actorOf(Props[Child], name)
  }

  override def preStart {
    log.info("======actor:" + self.toString() + ", 监视者 启动 ")
  }

  /**
   * 在 actor 正常终止后执行,异常重启时不会执行。
   */
  override def postStop {
    log.info("======actor:" + self.toString() + ",监视者 停止 .")
  }

  override def preRestart(reason: Throwable, msg: Option[Any]): Unit = {
    log.info("======actor:" + self.toString() + ", 监视者 预重启, reason:" + reason + msg)
  }
}


