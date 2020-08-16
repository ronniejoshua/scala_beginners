package lectures.part2oop


object OOPBasics extends App {

  // Example 1
  // Create an object instance from a class
  val person = new Person("John", 26)

  // accessing the class attribute/fields
  println(person.x)

  // Calling a class method, with argument
  person.greet("Daniel")

  // Calling a class method without argument
  person.greet()

  // Example 2
  // Instantiating the classes
  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge())
  // This returns false, though the data attributes are the same
  println(novel.isWrittenBy(imposter))


  // Example 3
  // The call to inc returns a new Counter, and on that we call inc(n-1).
  val counter = new Counter()
  counter.inc().print()
  counter.inc().inc().inc().print()
  counter.inc(10).print()
}



/*
  Class definitions can sit on top level code hence can be outside the object definition
  Class parameters are not accessible in the same way as class attribute
  class Person(name: String, val age: Int = 0)  in this case can access age attribute
  class Person(name: String, age: Int = 0)  cannot access age attribute because it is a
    class parameter and not a member
   */

// constructor
class Person(name: String, val age: Int = 0) {
  // body - Get's evaluated when the class is instantiated
  // (Class is used for object creation)
  // This is a field/accessible attribute
  val x = 2

  println(1 + 3)

  // method/functionality/Behavior
  def greet(name: String): Unit = {
    // this refers to instantiated object and its attribute. In python self.
    // this.name is from the initialization and name is from the function parameter
    println(s"${this.name} says: Hi, $name")
  }

  // overloading : having something/method with the same name but different signature
  // In this method definition this.name is implied
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors/class methods in python
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}



/*
    Exercise
    Novel and a Writer
    Writer: first name, surname, year
      - method fullname
    Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy (new year of release) = new instance of Novel
   */

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = {
    firstName + " " + surname
  }
}

// Using Writer as another Data Structure
class Novel(name: String, year: Int, author: Writer) {

  def authorAge(): Int = {year - author.year}

  def isWrittenBy(author: Writer): Boolean = {author == this.author}

  // Class method
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)

}


/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Counter(val count: Int = 0) {


  def inc(): Counter = {
    println("incrementing")
    // immutability - Avoid mutating the instantiated object - Create a New instance
    // fundamental principle of Functional Programming
    new Counter(this.count + 1)
  }

  def dec(): Counter = {
    println("decrementing")
    new Counter(this.count - 1)
  }

  /*
  def inc(n: Int): Counter = {new Counter(count + n)}
  def dec(n: Int): Counter = {new Counter(count - n)}
   */

  // Overloaded Method
  def inc(n: Int): Counter = {
    // Base case - if the increment is negative or zero, return the same instance
    if (n <= 0) this
    // Recursive case
    // The call to inc returns a new Counter, and on that we call inc(n-1).
    else inc().inc(n - 1)
  }

  // Overloaded Method
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec().dec(n - 1)
  }

  def print(): Unit = {
    println(this.count)
  }
}

