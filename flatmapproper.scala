import scalaz._
import Scalaz._

import scalaz.concurrent._

object flatmapproper {

  def factorsPresentT(n: Int): OptionT[List, Int] =
    OptionT(
      (1 to n).map { i =>
        if (n % i == 0)
          Some(n / i)
        else
          None
      }.toList
    )

  def expensiveComputationT(n: Int): OptionT[Task, Int] =
    OptionT(
      if (n == 1)
        Task.delay(None)
      else if (n % 2 == 0)
        Task.delay(Some(n / 2))
      else
        Task.delay(Some(n * 3 + 1))
    )

}
