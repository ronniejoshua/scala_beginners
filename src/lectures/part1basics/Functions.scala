package lectures.part1basics

object Functions extends App {

  // Example 1
  def aFunction(a: String, b: Int): String = {
    // String Concatenation
    a + " " + b
  }
  println(aFunction("hello", 3))


  // Example 2
  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())

  // Can be invoked without calling the function
  println(aParameterlessFunction)


  // Example 3
  // Objective: When you need loops, use recursion
  // Recursive Function
  def aRepeatedFunction(aString: String, n: Int): String = {
    // Base case
    if (n == 1) aString
    // Recursive Case
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello",3))


  // Example 4
  // Functions with side effects
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  // Example 5
  def aBigFunction(n: Int): Int = {

    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  // Exercises
  /*
    1.  A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2.  Factorial function 1 * 2 * 3 * .. * n
    3.  A Fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n - 2)
    4.  Tests if a number is prime.
   */




  // Exercise 1
  def greetingForKids(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }

  println(greetingForKids("David", 12))




  // Exercise 2
  def factorial(n: Int): Int = {
    //Base case
    if (n <= 0) 1

    // Recursive Case
    else n * factorial(n-1)
  }

  println(factorial(5))




  // Exercise 3
  def fibonacci(n: Int): Int = {
    // Base case
    if (n <= 2) 1
    // Recursive Case
    else fibonacci(n-1) + fibonacci(n-2)
  }

  // 1 1 2 3 5 8 13 21
  println(fibonacci(8))



  // Exercise 4
  /*
   A prime number (or a prime) is a natural number greater than 1 that is not
   a product of two smaller natural numbers. A natural number greater than 1
   that is not prime is called a composite number. For example, 5 is prime
   because the only ways of writing it as a product, 1 × 5 or 5 × 1, involve 5
   itself. However, 4 is composite because it is a product (2 × 2) in which both
   numbers are smaller than 4.
   */
  def isPrime(n: Int): Boolean = {

    @scala.annotation.tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }


  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))

}
