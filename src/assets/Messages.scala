package assets

/**
 * Created with IntelliJ IDEA.
 * User: mromanski
 * Date: 07.06.13
 * Time: 08:13
 */

import java.nio.file.FileSystems
import pl.project13.scala.rainbow.Rainbow._

object Messages {

  val v: String = "1.0.0"

  def hello() {
    line
    println("Created by loki@onewebpro!!".red)
    println("Hello User! Im in version: " + v.green)
    println("WE ARE LEGION!".red)
    println("I will ReDump your var_dump array!")
    println("You can set two paths, starting this app.\nFirst is for file to load, second is path to save file.")
    println("Or I will set defaults files. Temporary is " + "temp.dump".red + " for file with dump.\nAnd " + "temp.array.php".red + " for result.")
    println("Now I start ReDumping ser.")
    line
  }

  def files(loadFile: String, saveFile: String) {
    println("Loading file ser!")
    line
    val loadPath = FileSystems.getDefault.getPath(loadFile).toFile.getAbsolutePath
    val savePath = FileSystems.getDefault.getPath(saveFile).toFile.getAbsolutePath
    println("Actual file to load => [ '" + loadPath.red + "' ];")
    println("Actual file to save => [ '" + savePath.red + "' ];")
    line
  }

  def end(loadFile: String, saveFile: String) {
    println("ReDump Success!".green)
    line
    val loadPath = FileSystems.getDefault.getPath(loadFile).toFile.getAbsolutePath
    val savePath = FileSystems.getDefault.getPath(saveFile).toFile.getAbsolutePath
    println("Data loaded from => [ '" + loadPath.red + "' ];")
    println("Data saved to => [ '" + savePath.red + "' ];")
    line
  }


  def line() {
    var s = "*"
    for (a <- 1 to 10)
      s += "*"
    println(s)
  }
}
