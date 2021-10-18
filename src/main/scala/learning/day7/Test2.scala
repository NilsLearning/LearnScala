package learning.day7

/**
 * 学习目标： Map
 * 使用filterKeys去查找指定的key
 * 使用filter过滤指定的key和value
 * 使用get()方法得到的value是Option类型
 * 使用apply()方法得到的value是T值，注意要放在try当中
 * 使用updated()方法在Map中添加元素,会生成一个新Map
 * 使用隐式调用向map中添加值,注意声明的Map是一个可变的Map
 */
class Test2 {

}

object Test2_1{
  def main(args: Array[String]): Unit = {
    val feeds = Map("key1"-> "sda",
    "key2"->"sdaa",
    "uey2"->"sdaa",
    "key3" -> "hu")
    val feeds1 = feeds.filterKeys(_ startsWith "k")
    println(feeds1.toString())
    val feeds2 = feeds.filter(ele =>ele._1.contains("k") && ele._2.startsWith("h"))
    println("feeds2================"+feeds2)
    println("get方法得到的结果=============="+feeds.get("key1"))
    println("apply方法得到的结果=========="+feeds("key1"))
    val feedsUpdated = feeds.updated("key4", "hello")
    println("updated的结果======"+feedsUpdated.toString())
    val implicitMap = scala.collection.mutable.Map("11"->"2w31")
    implicitMap("22")="2313"
    println(implicitMap.toString())

//    val v2 = feeds.filter(key => key.equals("key1")).toList
//    println("v2======"+v2)

//    feeds("key5")="ji"
//    print(feeds("key5"))
//    feeds filter { ele => val (key,value) = ele(key startsWith "D") && (value ) }
  }
}