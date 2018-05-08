package Chap5

sealed trait LinkedList[A]{

  def length: Int = this match {
    case End() => 0
    case Pair(hd, tl) => 1 + tl.length
  }


  def contains(x: A): Boolean = this match {
    case End() => false
    case Pair(hd, tl) => if(hd == x) true else tl.contains(x)
  }

  def apply(n: Int): Result[A] = this match {


    case End() => Failure("Index out of bounds")
    case Pair(hd, tl) => if (n == 0) Success(hd) else tl.apply(n-1)
  }

  def fold(end:A, f:(A, A)=> A): A = this match {
    case End() => end
    case Pair(hd, tl) => f(hd, tl.fold(end, f))
  }

  def fold(end:Int, f:(Int, Int) => Int): Int = this match {
    case End() => end
    case Pair(hd,tl) => f(hd, tl.fold(end,f))
  }

  def sum(): Int = fold(0,_+_)
  def lengthy(): Int = fold(0, (_,_) => 1)
  def product(): Int = fold(1, _*_)
  
}

final case class End[A]() extends LinkedList[A]
final case class Pair[A](head:A, tail:LinkedList[A]) extends LinkedList[A]


