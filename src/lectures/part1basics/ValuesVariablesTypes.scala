package lectures.part1basics

object ValuesVariablesTypes extends App {

  val num: Int = 42
  println(num)

  // val's are immutable | val = Values
  // num = 24  is not allowed

  val aString: String = "hello"

  // Compiler can infer types, hence type declaration is optional
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = num
  val aShort: Short = 4613
  val aLong: Long = 5273985273895237L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // var's are mutable | var = Variables
  var aVariable: Int = 4
  aVariable = 5 // side effects

}
