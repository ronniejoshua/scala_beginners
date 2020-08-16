package exercises

// Using "type parameters" (Covariant)
abstract class MyListThree[+A] {

  /*
     head = first element of  the  list
     tail = remainder of the list
     isEmpty = is this list empty
     add(int) => new list with this element added
     toString => a string representation of the list
   */
  def head: A
  def tail: MyListThree[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListThree[B]

  def printElements: String
  // polymorphic call
  // use of override to avoid built in implementation of AnyRef Type
  override def toString: String = "[" + printElements + "]"

  // higher-order functions
  def map[B](transformer: MyTransformers[A, B]): MyListThree[B]
  def flatMap[B](transformer: MyTransformers[A, MyListThree[B]]): MyListThree[B]
  def filter(predicate: MyPredicate[A]): MyListThree[A]

  // Implementing concat
  def ++[B >:A](list: MyListThree[B]): MyListThree[B]
}




case object Empty extends MyListThree[Nothing] {

  // ??? is similar to pass in python
  // Pending implementation
  //def head: Int = ???
  // throw exceptions return "Nothing" Scala Type

  def head: Nothing = throw new NoSuchElementException
  def tail: MyListThree[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListThree[B] = new ConsThree(element, Empty)
  def printElements: String = ""

  def map[B](transformer: MyTransformers[Nothing, B]): MyListThree[B] = Empty
  def flatMap[B](transformer: MyTransformers[Nothing, MyListThree[B]]): MyListThree[B]= Empty
  def filter(predicate: MyPredicate[Nothing]): MyListThree[Nothing]= Empty

  def ++[B >:Nothing](list: MyListThree[B]): MyListThree[B] = list
}


case class ConsThree[+A](h: A, t: MyListThree[A]) extends MyListThree[A] {

  def head: A = h
  def tail: MyListThree[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListThree[B] = new ConsThree(element, this)
  def printElements: String = {
    if (t.isEmpty){
      "" + h
    } else {h + " " + t.printElements}
  }



  /*
      [1,2,3].filter(n % 2 == 0) =
        [2,3].filter(n % 2 == 0) =
        = new Cons(2, [3].filter(n % 2 == 0))
        = new Cons(2, Empty.filter(n % 2 == 0))
        = new Cons(2, Empty)
     */
  def filter(predicate: MyPredicate[A]): MyListThree[A] =  {
    if (predicate.test(h)) new ConsThree(h,t.filter(predicate))
    else t.filter(predicate)
  }


  /*
    [1,2,3].map(n * 2)
      = new Cons(2, [2,3].map(n * 2))
      = new Cons(2, new Cons(4, [3].map(n * 2)))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
      = new Cons(2, new Cons(4, new Cons(6, Empty))))
   */
  def map[B](transformer: MyTransformers[A, B]): MyListThree[B] = {
    new ConsThree(transformer.transform(h), t.map(transformer))
  }

  /*
      [1,2] ++ [3,4,5]
      = new Cons(1, [2] ++ [3,4,5])
      = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
      = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  def ++[B >:A](list: MyListThree[B]): MyListThree[B] = new ConsThree(h, t ++ list)

  /*
      [1,2].flatMap(n => [n, n+1])
      = [1,2] ++ [2].flatMap(n => [n, n+1])
      = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
      = [1,2] ++ [2,3] ++ Empty
      = [1,2,2,3]
  */
  def flatMap[B](transformer: MyTransformers[A, MyListThree[B]]): MyListThree[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }

}


trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformers[-A, B] {
  def transform(element: A): B
}

object ListTestThree extends  App {

  val list_ofIntegers: MyListThree[Int] = new ConsThree(1, new ConsThree(2, new ConsThree(3, Empty)))
  val clist_ofIntegers: MyListThree[Int] = new ConsThree(1, new ConsThree(2, new ConsThree(3, Empty)))
  val list_ofStrings: MyListThree[String] = new ConsThree("Hello", new ConsThree("Scala", Empty))
  val alist_ofIntegers: MyListThree[Int] = new ConsThree(4, new ConsThree(5, new ConsThree(6, Empty)))


  println(list_ofIntegers.toString)
  println(list_ofStrings.toString)

  println(list_ofIntegers.map(new MyTransformers[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }))

  println(list_ofIntegers.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 ==0
  }).toString)

  println((list_ofIntegers ++ alist_ofIntegers).toString)
  println(list_ofIntegers.flatMap(new MyTransformers[Int, MyListThree[Int]]{
    override def transform(element: Int): MyListThree[Int] =
      new ConsThree(element, new ConsThree(element * 1, Empty))
  }))

  println(clist_ofIntegers == list_ofIntegers)
}