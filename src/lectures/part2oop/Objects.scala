package lectures.part2oop


object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // Class methods or attributes
  // Object can have val, var and method definitions
  // Objects can be defined as classes with exception objects do not receive parameters
  // Scala object = SINGLETON INSTANCE ==> Type + its only instance
  // "class" - level functionality
  // Practice of writing Objects & Classes in the same scope is called COMPANIONS
  // Singleton Instance
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method => Build Person given some parameters
    // makes the singleton object Person callable
    def apply(mother: Person, father: Person): Person = {
        new Person("Bobbie")
    }

  }

  // instance-level functionality
  // regular instance
  class Person(val name: String) {
  }



  println(Person.N_EYES)
  println(Person.canFly)

  // Scala Class = Regular INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  // Scala object = SINGLETON INSTANCE
  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobbie = Person(mary, john)


  /*
  Scala Applications = is a Scala object with an important method/functionality of
  def main(args: Array[String]): Unit
   */



  val k = 6.67e-11

}