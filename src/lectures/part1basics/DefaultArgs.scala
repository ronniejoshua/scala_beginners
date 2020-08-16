package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  // Example 1
  @tailrec
  def trFact(n: Int, acc: Int = 1): Int = {
    // Base Case
    if (n <= 1) acc
    // Recursive Case
    else trFact(n-1, n*acc)
  }

  val fact10 = trFact(10, 2)

  // Example 2
  // Take into account the positional arguments
  // Take into account the keyword arguments
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = {
    println("saving picture")
  }

  savePicture(width = 800)

  savePicture(height = 600, width = 800, format = "bmp")

}
