package com.yan01.common_topic.moreThreads;

/**
 * @author yyh
 * @create 2020-11-08 8:58
 */
public class NumAndLetterPrinter {

//    private static char a = 'A';
//
//    private static int num = 0;


    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            printNumAndLetter();
        },"numThread").start();

        new Thread(() ->{
            printNumAndLetter();
        },"letterThread").start();
    }



    public static void printNumAndLetter(){

        for (int i = 0; i < 26; i++) {
            synchronized(lock){
                if(Thread.currentThread().getName() == "numThread"){
                    System.out.print(i+1);
                    lock.notifyAll();
                    try{
                        lock.wait();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                if(Thread.currentThread().getName() == "letterThread"){
                    System.out.println((char)('A'+i));
                    lock.notifyAll();
                    try{
                        lock.wait();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
