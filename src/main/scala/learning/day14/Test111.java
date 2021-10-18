package learning.day14;

import java.util.concurrent.atomic.AtomicInteger;

public class Test111 {
    public static void main(String[] args) {
        Test111 tste = new Test111();
        tste.test2();

    }

    public void test1(AtomicInteger va){
        System.out.println("test1 execute");
        System.out.println(va.get());
        if (va.get()> 2) {
            throw new RuntimeException();
        }else{
            throw new NullPointerException();
        }

    }

    public void test2(){
        AtomicInteger va = new  AtomicInteger();
        va.set(3);
        for(;;){
            try{
            test1(va);
        } catch (RuntimeException ignored){
            va.getAndDecrement();
            System.out.println("va====="+va);
            if(va.get()>0){
                test1(va);
            }else{
                System.out.println("end");
                return;
            }

        }

        }

//        try{
//            test1();
//        } catch (RuntimeException ignored){
//            va.getAndDecrement();
//            System.out.println("va====="+va);
//            if(va.get()>0){
//                test1();
//            }
//        }
    }


}
