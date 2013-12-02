package dumping


class Element(valueName: String, valueType: String, value: String) {
  def map: String = {
    "'" + valueName + "' => \n \t" + {
      Types.checkType(valueType) match {
        case Types.STRING => {
          if (value.isEmpty) {
            "NULL"
          }
          else {
            "'" + clearHtml(value) + "'"
          }
        }
        case Types.BOOLEAN => {
          value
        }
        case Types.FLOAT => {
          "(float) " + value
        }
      }
    } + ","
  }

  def clearHtml(element: String): String = {
    element
  }
}
