package com.yan01.common_topic.designModule.singleTonModule;

/**
 * 双重检查
 *
 * 优缺点说明
 * Double- Check概念是多线程开发中常使用到的,如代码中所示,我们进行了两次i( singleton=nul检查,这样就可以保证线程安全了。
 *
 * 2)这样,实例化代码只用执行一次,后面再次访问时,判断if( singleton==nul),直接 return实例化对象,也避免的反复进行方法同步
 *
 * 3)线程安全;延迟加载;效率较高
 *
 * 4)结论:在实际开发中,推荐使用这种单例设计模式
 */
public class SingleTonTest6 {


    private static SingleTonTest6 instance;

    private SingleTonTest6(){}

    public static SingleTonTest6 getInstance(){

        if(instance == null){

            synchronized(SingleTonTest6.class){
                if(instance == null){
                    instance = new SingleTonTest6();
                }
            }
        }

        return instance;
    }

    //测试
    public static void main(String[] args) {

        SingleTonTest6 instance = SingleTonTest6.getInstance();

        SingleTonTest6 instance2 = SingleTonTest6.getInstance();

        System.out.println(instance == instance2);

        System.out.println("instance.hashCode = "+ instance.hashCode());
        System.out.println("instance.hashCode2 = "+ instance2.hashCode());
    }
}
