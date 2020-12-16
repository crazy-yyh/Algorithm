package com.yan01.common_topic.designModule.singleTonModule;

/**
 * 懒汉式（线程安全，同步代码块)
 *
 * 不推荐使用
 */
public class SingleTonTest5 {

    private static SingleTonTest5 instance;

    private SingleTonTest5(){}

    public static SingleTonTest5 getInstance(){

        if(instance == null){

            synchronized(SingleTonTest5.class){
                instance = new SingleTonTest5();
            }
        }

        return instance;
    }
}
