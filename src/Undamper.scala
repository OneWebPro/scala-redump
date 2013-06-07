import java.util.regex.Pattern
import scala.util.matching.Regex

/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 18:38
 */
object Undamper {

  val endChar: String = ",\n\t"

  def ->(s: String): String = {
    var s2 = s
    s2 = Patterns.array2.replaceAllIn(s2, "array")
    s2 = Patterns.string replaceAllIn(s2, "")
    s2 = s2.replaceAll( """<(?!\/?a(?=>|\s.*>))\/?.*?>""", "")
    s2 = replaceVariables(s2)
    s2 = s2.replace("}", "),")
    s2 = s2.replace("{", "( \n\t")
    s2 = s2.replace("[", "")
    s2 = s2.replace("]", "")
    s2 = s2.replace("NULL", "NULL,\n\t")
    s2 = s2.replace("0=>array(", "\t0=>array(")
    s2 = s2 dropRight 1
    "<?php \n\t return " + s2 + ";"
  }

  private def replaceVariables(value: String): String = {
    var matches: String = value
    matches = replaceString(matches)
    matches = replaceInt(matches)
    matches = replaceFloat(matches)
    matches = replaceBoolean(matches)
    matches
  }


  def replaceString(value: String): String = {
    var matches: String = value
    Patterns.text.findAllMatchIn(matches).foreach {
      (m) => {
        val change = m.group(2)
        Patterns.textNumber.findAllMatchIn(matches).foreach {
          (m2) => {
            val change2 = m2.group(2)
            if (change2.charAt(0) == "\"".charAt(0) && change2.charAt(change2.length - 1) == "\"".charAt(0)) {
              val to_change2 = change2 dropRight 1 drop 1
              matches = matches.replace(change2, "\'" + to_change2.replace("\'","") + "\',\n\t")
            }
          }
        }
        if (change.charAt(0) == "\"".charAt(0) && change.charAt(change.length - 1) == "\"".charAt(0)) {
          val to_change = change dropRight 1 drop 1
          matches = matches.replace(change, "\'" + to_change.replace("\'","") + "\',\n\t")
        }
      }
    }
    matches
  }

  def replaceInt(value: String): String = {
    var matches: String = value
    Patterns.int.findAllMatchIn(matches).foreach {
      (m) => {
        val ms = Patterns.bracket.findAllMatchIn(m.group(0)).toArray
        val value = ms(0).group(0)
        matches = matches.replace(m.group(0), "(int)" + value + endChar)
      }
    }
    matches
  }

  def replaceFloat(value: String): String = {
    var matches: String = value
    Patterns.float.findAllMatchIn(matches).foreach {
      (m) => {
        val ms = Patterns.bracket.findAllMatchIn(m.group(0)).toArray
        val value = ms(0).group(0)
        matches = matches.replace(m.group(0), "(float)" + value + endChar)
      }
    }
    matches
  }

  def replaceBoolean(value: String): String = {
    var matches: String = value
    Patterns.boolean.findAllMatchIn(matches).foreach {
      (m) => {
        val ms = Patterns.bracket.findAllMatchIn(m.group(0)).toArray
        val value = ms(0).group(0)
        matches = matches.replace(m.group(0), value + endChar)
      }
    }
    matches
  }

}
