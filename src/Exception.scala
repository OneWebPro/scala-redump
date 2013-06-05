/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 19:12
 */

import pl.project13.scala.rainbow.Rainbow._
object Exception {
  def :> (error: Error.Value, file: String) {
    println("[ '" + file.red + "' ] = > " + error.toString.red)
    sys.exit(1)
  }
}
