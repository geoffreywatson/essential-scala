package Chap5




object Main extends App {

  val example1 = Pair(1, Pair(2, Pair(3, End())))
  assert(example1.length == 3)
  assert(example1.tail.length == 2)
  assert(End().length == 0)

  val example2 = Pair(1, Pair(2, Pair(3, End())))
  assert(example2.contains(3) == true)
  assert(example2.contains(4) == false)
  assert(End().contains(0) == false)
  // This should not compile
  // example.contains("not an Int")

  val example3 = Pair(1, Pair(2, Pair(3, Pair(4,End()))))
//  assert(example3(0) == 1)
//  assert(example3(1) == 2)
//  assert(example3(2) == 3)
//  assert(try {
//    example3(3)
//    false
//  } catch {
//    case e: Exception => true
//  })

  assert(example3(0) == Success(1))
  assert(example3(1) == Success(2))
  assert(example3(2) == Success(3))
  assert(example3(4) == Failure("Index out of bounds"))

  val example4 = Pair("hello", Pair("Geoff", Pair("Watson", End())))
  assert(example3.fold(0,(x:Int, y:Int) => x + y) == 10)
  assert(example3.fold(1,(x:Int, y:Int) => x * y) == 24)

  assert(example4.fold("", (x:String,y:String) => y match {
    case z if z.isEmpty => x + y + "!"
    case _ => x + ", " + y
   }) == "hello, Geoff, Watson!")



}
