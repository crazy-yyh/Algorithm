package com.yan01.common_topic.Thread_print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yyh
 * @create 2020-11-08 8:47
 */
public class PrintABCUseLock {

    public int times;

    public int state;

    private static Lock lock = new ReentrantLock();

    public PrintABCUseLock(int times){
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUseLock pl = new PrintABCUseLock(2);
        new Thread(() -> {
            pl.print("A",0);
        },"A").start();

        new Thread(() -> {
            pl.print("B",1);
        },"B").start();

        new Thread(() -> {
            pl.print("C",2);
        },"C").start();
    }


    public void print(String name,int tartgetNum){
        for (int i = 0; i < times;) {
            lock.lock();
            try{
                if(state % 3 == tartgetNum){
                    System.out.println(name);
                    i++;
                    state++;

                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }
}
