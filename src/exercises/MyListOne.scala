package exercises

abstract class MyListOne {

  /*
     head = first element of  the  list
     tail = remainder of the list
     isEmpty = is this list empty
     add(int) => new list with this element added
     toString => a string representation of the list
   */
  def head: Int
  def tail: MyListOne
  def isEmpty: Boolean
  def add(element: Int): MyListOne

  def printElements: String
  // polymorphic call
  // use of override to avoid built in implementation of AnyRef Type
  override def toString: String = "[" + printElements + "]"
}

object EmptyOne extends MyListOne {

  // ??? is similar to pass in python
  // Pending implementation
  //def head: Int = ???
  // throw exceptions return "Nothing" Scala Type

  def head: Int = throw new NoSuchElementException
  def tail: MyListOne = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyListOne = new ConsOne(element, EmptyOne)
  def printElements: String = ""
}

class ConsOne(h: Int, t: MyListOne) extends MyListOne {
  def head: Int = h
  def tail: MyListOne = t
  def isEmpty: Boolean = false
  def add(element: Int): MyListOne = new ConsOne(element, this)
  def printElements: String = {
    if (t.isEmpty){
      "" + h
    } else {h + " " + t.printElements}
  }

}

object ListTestOne extends  App{

  val list1 = new ConsOne(1, new ConsOne(2, new ConsOne(3, EmptyOne)))
  val list2 = new ConsOne(1, EmptyOne)

  println(list1.head)
  println(list2.head)
  println(list1.tail.head)
  println(list1.add(4).head)
  println(list1.isEmpty)
  println(list1.toString)
}