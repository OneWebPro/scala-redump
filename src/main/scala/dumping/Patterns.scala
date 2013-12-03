package dumping

import scala.util.matching.Regex

/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 19:59
 */
object Patterns extends Enumeration{
  type Patterns = Regex
  val variablesNames = "(?<=\\[).*?(?=\\])".r
  val arrayBody = "[^\\{]*(\\{.*\\})[^\\}]*".r
  val variableInArray = ".(?<=\\[)(.*?)(?=\\]).(?<=\\s*\\])(.*?)(?=\\[)".r
  val arrayVariable = "\\[(.*?)\\]\\s*=>\\s*array\\(\\d*\\)\\s*\\{(?<=\\{)(.*?)(?=\\})".r
  val int = ".(?<=\\[)(.*?)(?=\\]).\\s*=>\\s*(int|integer)\\s*\\((\\d*)\\)".r
  val string = ".(?<=\\[)(.*?)(?=\\]).\\s*=>\\s*string\\s*\\(\\d\\)\\s*(\".*?\"|\'.*?\')".r
  val float = ".(?<=\\[)(.*?)(?=\\]).\\s*=>\\s*(float)\\s*\\((\\d*(.|,)?\\d*?)\\)".r
  val boolean = ".(?<=\\[)(.*?)(?=\\]).\\s*=>\\s*(boolean|bool)\\s*\\((true|false)\\)".r
}

