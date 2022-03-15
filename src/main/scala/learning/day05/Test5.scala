package learning.day05

/**
 * 学习目标： Execute Around Method模式
 *
 * 当我们进入一个同步代码块时，会在指定的对象上获得一个监视器（monitor），即锁（lock),在我们离开这个代码块时，监视器会自动释放，
 * 即使代码块中抛出了一个没有被处理的异常，释放操作也还是会发生。
 */
class Test5 {

}

class Resource private(){
  println("start transaction……")

  private def cleanUp():Unit ={println("Ending transaction^")}
  def op1() ={println("op1")}
  def op2() ={println("op2")}
  def op3() ={println("op3")}

}

object Resource{
  def use(codeBlock:Resource=>Unit): Unit ={
    val resource = new Resource

    try{
      codeBlock(resource)
    }finally {
      resource.cleanUp()
    }
  }
}

object Test5_1{
  def main(args: Array[String]): Unit = {
    Resource.use { resource =>
      resource.op1()
      resource.op2()
      resource.op3()
      resource.op1()
    }
  }
}
