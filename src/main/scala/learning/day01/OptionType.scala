package learning.day01

object OptionType extends Enumeration {
    val add = "a"
    val delete = "d"

  def main(args:Array[String]): Unit ={
    print(OptionType.add.getClass)
  }
}
