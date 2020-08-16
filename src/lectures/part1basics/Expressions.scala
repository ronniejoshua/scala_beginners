package lectures.part1basics

object Expressions  extends App {

  // Expression
  val x: Int = 1 + 2
  println(x)

  // + - * / & | ^ << >> >>> (right shift with zero extension)
  println(2 + 3 * 4)

  // == != > >= < <=
  println(1 == x)

  // ! && ||
  println(!(1 == x))


  // also works with -= *= /= ..... side effects
  // changing a variable is called side effect
  var aVariable: Int = 2
  aVariable += 3
  println(aVariable)


  // Statements/Instructions/Imperative (DO) vs Expressions/Functional (VALUE)

  // IF expression gives back a value
  val aCondition: Boolean = true
  val aConditionedValue: Int = if(aCondition) 5 else 3

  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  // Avoid using while and for loops
  var i: Int = 0
  val aWhile: Unit = while (i < 10) {
    println(i)
    i += 1
  }


  // Everything in Scala is an Expression!
  // UNIT === void == None
  // UNIT is represented by ()
  // Special type in Scala
  // Side effects in scala are Expression that return UNIT type
  // side effects: println(), whiles, reassigning
  val aWeirdValue: Unit = (aVariable = 3)
  println(aWeirdValue)


  // Code blocks
  // Code blocks are expression - and the value it returns is the last expression executed in it

  val aCodeBlock: String = {
    val y: Int = 2
    val z: Int = y + 1
    if (z > 2) "hello" else "goodbye"
  }
  // Code blocks have their own scope, and val z is not available outside the code block
  // the following will return an error as val z is not available outside the scope
  // val anotherValue: Int = z + 1



  // Exercise 1. difference between "hello world" vs println("hello world")?
  // "Hello, World" returns a Value of string while println("Hello, World") is an side effect as it
  // return value UNIT


  // Exercise 2.
  val someValue: Boolean = {
    2 < 3
  }
  println(someValue)

  val someOtherValue: Int = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue)
}
