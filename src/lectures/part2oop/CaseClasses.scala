package lectures.part2oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString

    A Scala Case Class is like a regular class, except it is good for modeling immutable data.
    It also serves useful in pattern matching, such a class has a default apply() method which
    handles object construction. A scala case class also has all vals, which means they
    are immutable.

   */

  case class Person(name: String, age: Int){
  }


  // 1. class parameters are promoted to be fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented OOTB(out of the box)
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // returns true


  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)


  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)


  // 6. CCs are serializable/Distributed computing
  // Akka


  // 7. CCs have extractor patterns => CCs can be used in PATTERN MATCHING


  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
    Expand MyList - use case classes and case objects
   */
}