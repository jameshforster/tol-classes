package utils

/**
  * Created by james-forster on 09/04/18.
  */
object LevelUtils {

  val experienceBands: Int => Option[BigDecimal] = {
    case 1 => Some(5)
    case 2 => Some(10)
    case 3 => Some(25)
    case 4 => Some(100)
    case 5 => Some(500)
    case 6 => Some(2500)
    case 7 => Some(10000)
    case 8 => Some(25000)
    case 9 => Some(50000)
    case _ => None
  }
}
