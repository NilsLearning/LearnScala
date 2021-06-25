package learning.day4

/**
 * 学习目标： 协变和逆变
 * scala的协变是"使用侧协变",而不是"定义侧协变"
 * 逆变是"使用侧逆变",而不是"定义侧逆变"
 */
class Test5 {

}


class Pet(name:String){
  override def toString: String = s"$name"
}

class Dog(name:String) extends Pet(name)

object Test5_1{
  def main(args: Array[String]): Unit = {
    val dogs = Array(new Dog("nils"),new Dog("jack"))
    petsContainer(dogs)
    val pets = new Array[Pet](2)
    copyPets(dogs,pets)
    petsContainer1(pets)
  }

  /**
   * 协变Demo
   * 在这里 T <: Pet 表示由T表示的类派生自Pet类，这个语法用于定义一个上界，
   * 通过指定上界，我们告诉Scala数组参数的类型参数T必须至少是一个Pet的数组，但是也可以是任何派生自Pet类型的类的实例数组
   * 如果不通过协变，我们调用的是”petsContainer1“方法，那么将scala将会出现编译器无法通过的报错
   */
  def petsContainer[T <:Pet](array: Array[T]): Unit ={
    println(array.mkString(", "))
  }

  def petsContainer1(array: Array[Pet]): Unit ={
    println("hello" + array.mkString(", "))
  }

  /**
   * 逆变Demo
   * 接收数组中元素类型是源数组中元素类型的超类型也是可以的，这里我们需要一个下界
   */
  def copyPets[S,D >: S](fromArray: Array[S],toArray: Array[D])={
    fromArray.copyToArray(toArray)
  }
}