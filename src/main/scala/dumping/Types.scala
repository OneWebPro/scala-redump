package dumping

object Types extends Enumeration {
  type Types = Value

  val STRING = Value(1, "String")
  val BOOLEAN = Value(1, "Boolean")
  val FLOAT = Value(1, "Float")

  def checkType(element: String): Types.Value = Types.withName(element)

}
