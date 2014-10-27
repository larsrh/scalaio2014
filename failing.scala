import scalaz._
import Scalaz._

object failing {

  def stringToInt(x: String): ValidationNel[String, Int] =
    try {
      Success(x.toInt)
    }
    catch {
      case _: NumberFormatException =>
        Failure(NonEmptyList(s"Invalid number $x"))
    }

  def stringToPositiveInt(x: String): ValidationNel[String, Option[Int]] =
    try {
      val n = x.toInt
      if (n > 0)
        Success(Some(n))
      else
        Success(None)
    }
    catch {
      case _: NumberFormatException =>
        Failure(NonEmptyList(s"Invalid number $x"))
    }

}
