import scala.util.matching.Regex

/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 19:59
 */
object Patterns extends Enumeration{
  type Patterns = Regex
  val array = "(?<=\\{)[^\\}]*(?=\\})".r
  val array2 = "\\s*((array|Array)\\s*\\(\\s*\\d*\\s*\\))\\s*".r
  val string = "\\s*(string\\s*\\(\\s*\\d*\\s*\\))\\s*".r
  val int = "\\s*((integer|int)\\s*\\(\\s*-?\\w*\\s*\\))\\s*".r
  val float = "\\s*(float\\s*\\(\\s*\\w*?.\\w*\\s*\\))\\s*".r
  val boolean = "\\s*((boolean|bool)\\s*\\(\\s*(true|false)*\\s*\\))\\s*".r
  val bracket = "(?<=\\()[^\\)]*(?=\\))".r
  val text = "(\\s*=>\\s*(?!\\s*array)(.*?)\\s*\\[\"\\w*\"\\])".r
  val textNumber = "(\\s*=>\\s*(?!\\s*array)(.*?)\\s*\\[\\d*\\])".r
  /*val variable_name = "(?<=\\[)[^]]+(?=\\])".r
  var variable_value ="^(\\w*)(\\s*)(\"(.*)\"|'(.*)')(\\w*)(\\s*)(.*)".r
  val integer = "^(\\w*)(\\s*)(integer\\s*\\(\\s*\\d*\\s*\\))(\\w*)(\\s*)(.*)".r
  val float = "^(\\w*)(\\s*)(float\\s*\\(\\s*\\d*\\s*\\))(\\w*)(\\s*)(.*)".r
  val boolean = "^(\\w*)(\\s*)(boolean\\s*\\(\\s*(true|false)\\s*\\))(\\w*)(\\s*)(.*)".r
  val brackets ="^(\\w*)(\\s*)\\(\\d*\\)(\\w*)(\\s*)(.*)".r*/
}
