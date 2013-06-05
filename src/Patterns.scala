import scala.util.matching.Regex

/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 19:59
 */
object Patterns extends Enumeration{
  type Patterns = Regex
  val array = "^(\\w*)(\\s*)((array|Array)\\s*\\(\\s*\\d*\\s*\\))(\\s*)(\\{)(\\s*)(.*)(\\s*)(\\})(.*)".r
  val variable_name = "^(\\w*)(\\s*)(\\[)(\\s*)(\"\\w*\")(\\s*)(\\])(\\w*)(\\s*)(.*)".r
  var variable_value ="^(\\w*)(\\s*)(\"(.*)\"|'(.*)')(\\w*)(\\s*)(.*)".r
  val integer = "^(\\w*)(\\s*)(integer\\s*\\(\\s*\\d*\\s*\\))(\\w*)(\\s*)(.*)".r
  val float = "^(\\w*)(\\s*)(float\\s*\\(\\s*\\d*\\s*\\))(\\w*)(\\s*)(.*)".r
  val boolean = "^(\\w*)(\\s*)(boolean\\s*\\(\\s*(true|false)\\s*\\))(\\w*)(\\s*)(.*)".r
  val brackets ="^(\\w*)(\\s*)\\(\\d*\\)(\\w*)(\\s*)(.*)".r
}
