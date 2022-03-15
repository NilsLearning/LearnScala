//package learning.day2

import java.util

/**
 * 学习目标： 体验Java的基础类型在scala中是对象
 * scala的富包装类与java之间在原始类型之间的差异
 * 与java不同，scala中将所有的类型都视为对象
 * java的原始类型不允许方法调用，比如一个int类型的数量变量，不能调用toString()方法，另外，自动装箱还涉及类型转换的开销，会带来一些负面的开销
 * scala将Scala.Int视作Java的基本类型int，这是纯粹的编译期就转换完成的
 */
object Test2 {
  def main(args:Array[String]): Unit ={
   val capacity = 10
    val list= new util.ArrayList[String]
    list.ensureCapacity(capacity)
  }

}
