package dumping

import scala.util.matching.Regex

/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 19:59
 */
object HtmlPatterns extends Enumeration{
  type Patterns = Regex
  val element = "(\\S+)=[\"']?((?:.(?![\"']?\\s+(?:\\S+)=|[>\"']))+.)[\"']?".r
  //val element = "(\\S+)=(\"|'| |)(.*)(\"|'| |>)".r
  val comments = "(?:[^<]|<[^!]|<![^-\\[]|<!\\[(?!CDATA)|<!\\[CDATA\\[.*?\\]\\]>|<!--(?:[^-]|-[^-])*-->)".r;
}

