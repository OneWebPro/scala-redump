package dumping

/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 18:38
 */
object Undamper {

  val endChar: String = ",\n\t"

  //var changed : List[String] = List()

  def ->(s: String): String = {
    var s2 = s
    s2 = Patterns.array2.replaceAllIn(s2, "array")
    s2 = Patterns.string replaceAllIn(s2, "")
    s2 = s2.replaceAll( """<(?!\/?a(?=>|\s.*>))\/?.*?>""", "")
    s2 = s2.replace("\"", "")
    s2 = s2.replace("'", "")
    s2 = fixNames(s2)
    s2 = replaceVariables(s2)
    s2 = s2.replace("}", "),")
    s2 = s2.replace("{", "( \n\t")
    s2 = s2.replace("[", "")
    s2 = s2.replace("]", "")
    s2 = s2.replace("NULL", "NULL,\n\t")
    s2 = replaceLast(s2)
    s2 = s2 dropRight 1
    "<?php \n\t return " + s2 + ";"
  }

  private def fixNames(value: String): String = {
    var matches: String = value
    matches = Patterns.variable_name.replaceAllIn(matches, m => if (m.group(0).matches("\\s*(\\d*)\\s*")) m.group(0) else "'" + m.group(0) + "'")
    matches
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
        val replacment: String = "'" + m.group(5) + "'" + ",\n\t"
        val groupReplace = m.group(0).replace(m.group(5), replacment)
        matches = matches.replace(m.group(0), groupReplace)
      }
    }
    matches
  }

  def replaceLast(value: String): String = {
    var matches: String = value
    Patterns.textLast.findAllMatchIn(matches).foreach {
      (m) => {
        val replacment: String = "'" + m.group(2) + "'" + ",\n\t"
        val groupReplace = m.group(0).replace(m.group(2), replacment)
        matches = matches.replace(m.group(0), groupReplace)
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
