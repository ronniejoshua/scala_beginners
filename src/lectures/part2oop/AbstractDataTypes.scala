package lectures.part2oop

object AbstractDataTypes extends App {

  /*
    Abstract classes are classes that contain one or more abstract methods. An
    abstract method is a method that is declared, but contains no implementation.
    Abstract classes cannot be instantiated, and require subclasses to provide
    implementations for the abstract methods.
   */
  abstract class Animal {
    // Can have abstract and non abstract attributes

    // Note there is no assignment of value or signature to abstract
    // attributes and behind
    // val creatureType: String
    def eat(): Unit

    val creatureType: String = "wild"
  }

  class Dog extends Animal {

    override val creatureType: String = "Canine"
    override def eat(): Unit = println("crunch crunch")

  }

  /*
  A trait encapsulates method and field definitions, which can then be reused by
  mixing them into classes. Unlike class inheritance, in which each class must
  inherit from just one superclass, a class can mix in any number of traits.

  Traits are used to define object types by specifying the signature of the supported methods.
  Scala also allows traits to be partially implemented but traits may not have constructor parameters.

  A trait definition looks just like a class definition except that it uses the keyword trait.
   */
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {

    override val creatureType: String = "croc"

    def eat(): Unit = println("nomnomnom")

    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters[__init__(Parameters)]
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"
}