import scala.beans.BeanProperty
//package learning.day3

/**
 * 学习目标：  scala编译器生成的访问器
 */
class CreditCard(val number:Int,var creditLimit:Int)

/**
 * 以上代码先经过 scalac CreditCard.scala编译后得到 CreditCard.class文件
 * 然后再经过 javap -p CreditCard.class
 * --------------------------------------
 * Compiled from "CreditCard.scala"
 * public class CreditCard {
 * private final int number;
 * private int creditLimit;
 * public int number();
 * public int creditLimit();           ---getter方法
 * public void creditLimit_$eq(int);   ---setter方法
 * public CreditCard(int, int);
 * }
 * -----------------------------------
 * scala编译器默认生成的访问器并不遵循JavaBean方法的命名规则，但是可以通过添加scala.bean.BeanProperty注解来实现
 */
class CreditCard11(@BeanProperty val number:Int, var creditLimit:Int)

