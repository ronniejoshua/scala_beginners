package lectures.part1basics

object CallByNameOrCallByValue extends App {

  // Example 1
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // x: => Long implies this parameter is called by name
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }
   // Evaluates System.nanoTime() and uses the same VALUE throughout the function during runtime
   calledByValue(System.nanoTime())

   // Passes System.nanoTime() and evaluates the return value of the function during runtime.
   calledByName(System.nanoTime())



  // Example - 2
  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

  // This causes Stackoverflow Error
  // printFirst(infinite(), 34)

  // Because now the infinite() function is called by name
  // it's execution is delayed and never gets used in the function
  printFirst(34, infinite())

}
