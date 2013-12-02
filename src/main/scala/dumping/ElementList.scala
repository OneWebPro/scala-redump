package dumping

class ElementList(name: String) {

  var list: List[Element] = List.empty

  var elements: List[ElementList] = List.empty

  def getList: String = {
    "return array(\n\t" + getValues + "\n);"
  }

  def getValues: String = elements.map(element => element.map).mkString("\n")

  def addValue(element: ElementList) = elements = (element :: elements.reverse).reverse

  def addList(element: Element) = list = (element :: list.reverse).reverse

  def map: String = {
    val elements = for (element <- list) yield {
      element.map
    }
    "'" + name + "' => " + "array (\n" + elements.mkString + "\n),"
  }

}
