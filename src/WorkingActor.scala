import akka.actor.{Cancellable, ActorSystem, ActorLogging, Actor}
import akka.util.Timeout
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

/**
 * Created with IntelliJ IDEA.
 * User: mromanski
 * Date: 11.06.13
 * Time: 11:52
 */
object WorkingActor extends Actor with ActorLogging {

  implicit val timeout: Timeout = 5.second

  implicit val executionContext: ExecutionContext = ActorSystem("MySystem").dispatcher

  val system = ActorSystem("MySystem")


  var scheduler: Cancellable = _

  var number: Int = 0

  def drawWork: Unit = {
    print("\b \b")
    number += 1
    number match {
      case 0 => {
        print("|")
      }
      case 1 => {
        print("/")
      }
      case 2 => {
        print("|")
      }
      case 3 => {
        print("\\")
      }
      case _ => {
        number = 0
        drawWork
      }
    }
  }

  def receive: WorkingActor.Receive = {
    case "start" => {
      print("\n")
      scheduler = system.scheduler.schedule(0 milliseconds, 0.5 .second, self, "work")
    }
    case "work" => {
      drawWork
    }
    case "stop" => {
      print("\b \b")
      print("\n")
      scheduler.cancel
    }
  }
}
