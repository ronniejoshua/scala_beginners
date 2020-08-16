package exercises

// Using "type parameters" (Covariant)
abstract class MyListTwo[+A] {

  /*
     head = first element of  the  list
     tail = remainder of the list
     isEmpty = is this list empty
     add(int) => new list with this element added
     toString => a string representation of the list
   */
  def head: A
  def tail: MyListTwo[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListTwo[B]

  def printElements: String
  // polymorphic call
  // use of override to avoid built in implementation of AnyRef Type
  override def toString: String = "[" + printElements + "]"
}




object EmptyTwo extends MyListTwo[Nothing] {

  // ??? is similar to pass in python
  // Pending implementation
  //def head: Int = ???
  // throw exceptions return "Nothing" Scala Type

  def head: Nothing = throw new NoSuchElementException
  def tail: MyListTwo[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListTwo[B] = new ConsTwo(element, EmptyTwo)
  def printElements: String = ""
}


class ConsTwo[+A](h: A, t: MyListTwo[A]) extends MyListTwo[A] {
  def head: A = h
  def tail: MyListTwo[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListTwo[B] = new ConsTwo(element, this)
  def printElements: String = {
    if (t.isEmpty){
      "" + h
    } else {h + " " + t.printElements}
  }

}

object ListTestTwo extends  App {

  val list_ofIntegers: MyListTwo[Int] = new ConsTwo(1, new ConsTwo(2, new ConsTwo(3, EmptyTwo)))
  val list_ofStrings: MyListTwo[String] = new ConsTwo("Hello", new ConsTwo("Scala", EmptyTwo))

  println(list_ofIntegers.toString)
  println(list_ofStrings.toString)
}