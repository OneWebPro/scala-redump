package actors

import akka.actor.{ActorLogging, Actor, Cancellable, ActorSystem}
import akka.util.Timeout
import assets.Messages
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

/**
 * Created with IntelliJ IDEA.
 * User: mromanski
 * Date: 11.06.13
 * Time: 14:09
 */
object TimerActor extends Actor with ActorLogging{

  implicit val timeout: Timeout = 5.second

  implicit val executionContext: ExecutionContext = ActorSystem("MySystem").dispatcher

  val system = ActorSystem("MySystem")

  var scheduler: Cancellable = _

  var time : Int = 0

  def receive: TimerActor.Receive = {
    case "start" => {
      scheduler = system.scheduler.schedule(0 milliseconds, 1.second, self, "add")
    }
    case "add" => {
       time +=1
    }
    case "stop" => {
      scheduler.cancel()
      println("Elapsed time: " + time.seconds)
      Messages.line()
      sys.exit()
    }
  }
}
