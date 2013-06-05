import java.util.regex.Pattern
import scala.util.matching.Regex

/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 18:38
 */
object Undamper {

  def ->(s : String) : String = {
    var s2 = ""
        val arrays = Patterns.variable_name findAllMatchIn  s
        for(array <- arrays){
          print(array)
        }
    s2
  }

}
