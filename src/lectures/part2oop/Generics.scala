package lectures.part2oop

object Generics extends App {

  // Generic classes in Scala
  /*
    The classes that takes a type just like a parameter are known to be Generic Classes
    in Scala. This classes takes a type like a parameter inside the square brackets i.e, [ ].
    This classes are utilized explicitly for the progress of the collection classes in Scala.
   */
  // [] is called type Parameterized => Making Objects and classes generic
  // Using [A] vs [+A]
  class MyList[+A] {

    // use the type A / Lower Bound types
    def add[B >: A](element: B): MyList[B] = ???

    /*
      A = Cat
      B = Animal
     */

  }

  // Using multiple Parameters as Generic type
  class MyMap[Key, Value]{

  }

  // Applications of Generic type A
  // Parameterized with type given in []
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]


  // generic methods
  // Note: Objects cannot be type parameterized

  // companion for class MyList
  object MyList {
    // method empty type parameterized with A
    // ??? == pass
    def empty[A]: MyList[A] = ???

  }

  val emptyListOfIntegers = MyList.empty[Int]



  // variance problem
  class Animal{}
  class Cat extends Animal{}
  class Dog extends Animal{}

  // If cat extends Animal than does a list of cats extend a list of Animals?

  // Yes, this behavior is called Covariance
  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  // [+A] Reflects Covariance type Parameter

  class CovariantList[+A]{}

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // ??? HARD QUESTION => we return a list of Animals
  // animalList.add(new Dog)


  // 2. NO = INVARIANCE
  // list of cats and list of animals are two separate things
  class InvariantList[A]{}

  // following is not allowed
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, NO! CONTRAVARIANCE
  // [-A] Reflects CONTRAVARIANCE type Parameter
  // A trainer of animal can also be a trainer of cat
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Upper Bounded Types
  // Class cage only accepts type parameters A which are sub-types of type Animal
  // sub-type <: super-type

  class Cage[A <: Animal](animal: A){}
  val cage = new Cage(new Dog)


  // Lower Bounded Types
  // sub-type >: super-type
  // Cage only accepts something that is supertype of Animal
  // class Cage[A >: Animal](animal: A){}

  class Car{}
  // generic type needs proper bounded type
  // val newCage = new Cage(new Car)

  // Exercise
  // expand MyList to be generic
}
