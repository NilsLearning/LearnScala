package learning.day3

/**
 * 学习目标： scala的构造器
 * 主构造器和辅助构造器
 */
class Person(val firstName: String, val lastName: String) {
    // 这里使用下划线表示初始化var的默认值，对于Int就是0，对于String就是null
    var position:String = _

    println(s"Creating $toString ")
  // scala强制规定：辅助构造器的第一行有效语句必须调用注构造器或者其它辅助构造器，注意这里使用的是this
    def this(firstName:String,lastName:String,positionHeld:String){
      this(firstName,lastName)
      position = positionHeld
    }
  def this(firstName:String,lastName:String,positionHeld:String,number: Int){
    this(firstName,lastName)
    position = positionHeld
  }

  override def toString: String = {
    s"firstName =$firstName lastName = $lastName holds position = $position"
  }

}

object Test1{
  def main(args: Array[String]): Unit = {
    val john = new Person("john","smith","ana")
    println(john)
    val john1 = new Person("john","smith","ana",1)
    println(john1)
    val nils = new Person("nils","yang")
    println(nils)
  }
}