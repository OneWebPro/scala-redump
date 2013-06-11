/**
 * Created with IntelliJ IDEA.
 * User: loki
 * Date: 05.06.13
 * Time: 18:50
 */
object Error extends Enumeration{
  type Error = Value
  val NO_FILE = Value(1, "File not exists.")
  val NOT_READABLE = Value(2, "File is not readable.")
}
