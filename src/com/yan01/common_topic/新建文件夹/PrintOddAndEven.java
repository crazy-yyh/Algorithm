package com.yan01.common_topic.Thread_print;

/**
 * @author yyh
 * @create 2020-11-08 8:33
 */
public class PrintOddAndEven {

    public static void main(String[] args) {
        new Thread(() ->{
            print();
        },"奇").start();

        new Thread(() -> {
            print();
        },"偶").start();
    }



    public static class Handler{
        public int value =1;
        public boolean odd = true;
    }

    public static Handler handler = new Handler();

    public static void print(){
        while(handler.value <= 100){
            synchronized(handler){
                if(Thread.currentThread().getName() == "奇"){
                    System.out.println(Thread.currentThread().getName() + "----> "+ handler.value);
                    handler.value++;
//                    handler.odd = !handler.odd;
                    handler.notify();

                    try{
                        handler.wait();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }else{
                    try{
                        handler.wait();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "----> "+ handler.value);
                    handler.value++;
//                    handler.odd = !handler.odd;
                    handler.notify();

                }


            }
        }
    }
}
