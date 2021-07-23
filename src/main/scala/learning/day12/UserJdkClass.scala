
import java.util.Currency

object UserJdkClass {
  def main(args: Array[String]): Unit = {
    val currencies= Currency.getAvailableCurrencies
    println(s"===========$currencies.size ===========")
  }

}
