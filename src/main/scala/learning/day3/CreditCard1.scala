//package learning.day3

import scala.beans.BeanProperty

/**
 * 使用javap -p CreditCard1。class后得到的结果如下：
 * Compiled from "CreditCard1.scala"
 * public class CreditCard1 {
 * private final int number;
 * private int creditLimit;
 * public int number();
 * public int creditLimit();
 * public void creditLimit_$eq(int);
 * public int getNumber();
 * public CreditCard1(int, int);
 * }
 *
 * 注意：在这里要使用@BeanProperty，一定要用val和val来对变量进行声明，否则即使加上BeanProperty注解，依然生成不了javaBean风格的实例
 */
class CreditCard1(@BeanProperty val number:Int, var creditLimit:Int)
