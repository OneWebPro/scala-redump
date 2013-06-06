import java.io.FileWriter
import java.nio.file.{FileSystems, Files}
import pl.project13.scala.rainbow.Rainbow._

/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 18:27
 */
object Main extends App {

  var loadFile = ""
  var saveFile = ""


  if(args.size >= 1)
    loadFile = args(0)

  if(args.size >= 2)
    saveFile = args(1)

  if (loadFile.isEmpty)
    loadFile = "temp.dump"

  if (saveFile.isEmpty)
    saveFile = "temp.array"

  if (!Files.exists(FileSystems.getDefault().getPath(loadFile))) {
    Exception :>(Error.NO_FILE, loadFile)
  }
  if (!Files.isReadable(FileSystems.getDefault().getPath(loadFile))) {
    Exception :>(Error.NOT_READABLE, loadFile)
  }

  if (!Files.exists(FileSystems.getDefault().getPath(saveFile)))
    Files.createFile(FileSystems.getDefault().getPath(saveFile))

  writeToFile(saveFile, Undamper -> scala.io.Source.fromFile(loadFile).getLines().mkString)
  println("ReDump Success".green)

  def using[A <: {def close() : Unit}, B](param: A)(f: A => B): B =
    try {
      f(param)
    } finally {
      param.close()
    }

  def writeToFile(fileName: String, data: String) =
    using(new FileWriter(fileName)) {
      fileWriter => fileWriter.write(data)
    }
}
