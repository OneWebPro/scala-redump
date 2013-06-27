package assets

/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 19:12
 */

import pl.project13.scala.rainbow.Rainbow._

object Exception {
  def :> (error: assets.Error.Value, file: String) {
    println("[ '" + file.red + "' ] = > " + error.toString.red)
    Messages.line
    sys.exit(1)
  }
}
