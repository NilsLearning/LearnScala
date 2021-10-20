package learning.day16;

public class Test3 {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("=====1");
        },"线程1").start();

        new Thread(()->{
            System.out.println("====2");
        },"线程2").start();

        System.out.println("=========3");
    }
}
