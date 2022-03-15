import java.time.LocalDate
//package learning.day4
/**
 * 学习目标： 值类
 * 在Test8中创建的隐式对象DateHelper，通过使用Javap -c 【类名】，可以分析到在执行隐式转换的时候，都会创建一个Datehelper的实例，
 * 然后在它上面调用了Days方法，每次调用流式方法，都会导致创建对象的开销，结果就是：所作的隐式转换越多，所创建的短声明周期的垃圾对象也就越多
 * Scala的值对象直接解决了这一个问题，这些小的垃圾对象将会被消除，编译器将会使用没有中间对象的函数组合来直编译这些流式方法的调用，要创建一个流
 * 对象，只需要从AnyVal拓展你的类即可。
 */
class Test9(val name:String, age: String)
/**
public class Test9 {
  public java.lang.String name();
    Code:
       0: aload_0
       1: getfield      #13                 // Field name:Ljava/lang/String;
       4: areturn

  public Test9(java.lang.String);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #13                 // Field name:Ljava/lang/String;
       5: aload_0
       6: invokespecial #20                 // Method java/lang/Object."<init>":()V
       9: return
}
*/
/**
public class Test9 {
  private final java.lang.String name;
  public java.lang.String name();
  public Test9(java.lang.String);
}
*/

object DataUtil {
  var ago = "ago"
  var after = "after"
  implicit class DateHelper(val offset: Int) extends AnyVal {
    def days(when:String)={
      val now = LocalDate.now
      when match{
        case "ago" => now.minusDays(offset)
        case "after" => now.plusDays(offset)
        case _ => now
      }
    }
  }
}


