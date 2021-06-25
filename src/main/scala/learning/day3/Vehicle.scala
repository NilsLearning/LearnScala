package learning.day3

/**
 * 学习目标： 拓展一个类
 * 其一， 方法的重载必须使用override关键字，其二，只有主构造器能传递参数给基类的构造器
 *
 */
class Vehicle(val id: Int,val year: Int) {
  override def toString =s"id = $id ; year =$year"
}
// 在car的主构造器相应的参数前加上关键字override，看到这个关键字，scala编译器就不会为这个属性生成字段，而是会将这些属性的访问器方法路由到基类的相应方法
class Car(override val id:Int,override val year: Int,val fueLevel: Int) extends Vehicle(id,year){
  override def toString = s"${super.toString} fuelevel = $fueLevel"
}
object Test3{
  def main(args: Array[String]): Unit = {
    val car = new Car(1,2,4)
    println(car)
  }
}
