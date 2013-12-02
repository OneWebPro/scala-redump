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
  val array = "(\\s*array\\(.*\\))\\s*\\{(.*)\\}".r
  ///////////////////////////////////////////////////////////////
//  val array = "(?<=\\{)[^\\}]*(?=\\})".r
//  val arrayVar = "\\s*((array|Array)\\s*\\(\\s*\\d*\\s*\\))\\s*".r
//  val arrayPrint = "\\s*(Array)\\s*".r
//  val string = "\\s*(string\\s*\\(\\s*\\d*\\s*\\))\\s*".r
//  val int = "\\s*((integer|int)\\s*\\(\\s*-?\\w*\\s*\\))\\s*".r
//  val float = "\\s*(float\\s*\\(\\s*\\w*?.\\w*\\s*\\))\\s*".r
//  val boolean = "\\s*((boolean|bool)\\s*\\(\\s*(true|false)*\\s*\\))\\s*".r
//  val bracket = "(?<=\\()[^\\)]*(?=\\))".r
//  val text = "(\\s*=>\\s*(?!\\s*array)(?!\\s*(integer|int)\\s*\\(\\s*-?\\d*\\s*\\))(?!\\s*(boolean|bool)\\s*\\(\\s*(true|false)*\\s*\\))(?!\\s*float\\s*\\(\\s*\\d*?.\\d*\\s*\\))(.*?)\\s*(\\[(\\'\\w*\\'|\\d*)\\]))".r
//  val textBracket = "(\\s*\\'(.*?)\\s*(})\\s*?(})*\\',\\n\\t)".r
//  val textBracket2 = "(\\s*\\'(.*?)\\s*(\\))\\s*?(\\))*\\',\\n\\t)".r
//  val checkIsDateTime = "('(\\w*-\\w*-\\w*)\\s*\\(\\w*:\\w*\\)\\s*',\\s*)".r
//  val textLast = "(\\s*\\'\\w*\\'=>\\s*(?!\\s*array)(?!\\s*\\(int\\)\\s*-?\\d*\\s*,)(?!\\s*\\(float\\)\\s*\\d*?.\\d*\\s*)(?!\\s*\\')(.*?)(?!\\s*\\')\\s*(\\),))".r
//  val textLastPrint = "(\\s*\\'\\w*\\'\\s*=>\\s*(?!\\s*array)(?!\\s*\\(int\\)\\s*-?\\d*\\s*,)(?!\\s*\\(float\\)\\s*\\d*?.\\d*\\s*)(?!\\s*\\')(.*?)(?!\\s*\\')\\s*(\\)))".r
//  val variable_name = "(?<=\\[)[^]]+(?=\\])".r
//  val test = "(.*?)^(?!.*}).*$".r
}

