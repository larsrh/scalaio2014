import scalaz._
import Scalaz._

import scalaz.concurrent._

object flatmap {

  def flatMapForOption[A, B, F[_] : Monad]
    (f: A => F[Option[B]], foa: F[Option[A]]): F[Option[B]] =
      foa.flatMap {
        case None => none.pure[F]
        case Some(a) =>
          val fa = f(a)
          fa
      }


  def factorsPresent(n: Int): List[Option[Int]] =
    (1 to n).map { i =>
      if (n % i == 0)
        Some(n / i)
      else
        None
    }.toList

  def expensiveComputation(n: Int): Task[Option[Int]] =
    if (n == 1)
      Task.delay(None)
    else if (n % 2 == 0)
      Task.delay(Some(n / 2))
    else
      Task.delay(Some(n * 3 + 1))

}
