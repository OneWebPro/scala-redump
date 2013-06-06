import java.util.regex.Pattern
import scala.util.matching.Regex

/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 18:38
 */
object Undamper {

  def ->(s: String): String = {
    var s2 = ""
    val m = Patterns.array.findAllIn(s).matchData.toArray
    if (m.size > 0) {
      s2 = Patterns.array2.replaceAllIn("array(\n" + m(0).group(0).replace("[", "").replace("]", "").replace("{", "(").replace("}", "),") + "\n);", "array")
      s2 = Patterns.string replaceAllIn(s2, "")
      s2 = replaceVariables(s2)
    }
    s2
  }

  private def replaceVariables(value: String): String = {
    var matches: String = value
    Patterns.int.findAllMatchIn(matches).foreach {
      (m) => {
        val ms = Patterns.bracket.findAllMatchIn(m.group(0)).toArray
        val value = ms(0).group(0)
        matches = matches.replace(m.group(0), "(int)" + value  + ",")
      }
    }
    Patterns.float.findAllMatchIn(matches).foreach {
      (m) => {
        val ms = Patterns.bracket.findAllMatchIn(m.group(0)).toArray
        val value = ms(0).group(0)
        matches = matches.replace(m.group(0), "(float)" + value + ",")
      }
    }
    Patterns.boolean.findAllMatchIn(matches).foreach {
      (m) => {
        val ms = Patterns.bracket.findAllMatchIn(m.group(0)).toArray
        val value = ms(0).group(0)
        matches = matches.replace(m.group(0), value  + ",")
      }
    }
    matches
  }

}
