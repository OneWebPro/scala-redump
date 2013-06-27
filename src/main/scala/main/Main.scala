package main

import akka.actor.{Props, ActorSystem}
import akka.util.Timeout
import java.io.FileWriter
import java.nio.file.{FileSystems, Files}
import pl.project13.scala.rainbow.Rainbow._
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import akka.pattern.ask
import actors._
import assets._
import dumping._


/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 18:27
 */
object Main extends App {

  implicit val timeout: Timeout = 5.second

  implicit val executionContext: ExecutionContext = ActorSystem("MySystem").dispatcher

  val system = ActorSystem("MySystem")

  val actor = system.actorOf(Props(WorkingActor))

  val time = system.actorOf(Props(TimerActor))

  time ! "start"

  Messages.hello()

  var loadFile = ""
  var saveFile = ""

  if (args.size >= 1)
  loadFile = args(0)

  if (args.size >= 2)
    saveFile = args(1)

  if (loadFile.isEmpty)
    loadFile = "temp.dump"

  if (saveFile.isEmpty)
    saveFile = "temp.array.php"

  Messages.files(loadFile,saveFile)

  if (!Files.exists(FileSystems.getDefault.getPath(loadFile))) {
    Exception :>(Error.NO_FILE, loadFile)
  }
  if (!Files.isReadable(FileSystems.getDefault.getPath(loadFile))) {
    Exception :>(Error.NOT_READABLE, loadFile)
  }

  if (!Files.exists(FileSystems.getDefault.getPath(saveFile)))
    Files.createFile(FileSystems.getDefault.getPath(saveFile))

  actor ! "start"

  writeToFile(saveFile, Undamper -> scala.io.Source.fromFile(loadFile).getLines().mkString)

  actor ? "stop"

  Messages.end(loadFile,saveFile)

  time ! "stop"

  def using[A <: {def close()}, B](param: A)(f: A => B): B = {
    try {
      f(param)
    } finally {
      param.close()
    }
  }


  def writeToFile(fileName: String, data: String) {
    using(new FileWriter(fileName)) {
      fileWriter => fileWriter.write(data)
    }
  }
}
