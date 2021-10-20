package learning.day16;

/**
 * 回到上一步
 */
public class Test2 {
    public static void main(String[] args) {
        method1();
    }

    public static void method1(){
        System.out.println("method1");
        method2();
    }
    public static void method2(){
        System.out.println("method2");
    }
}


