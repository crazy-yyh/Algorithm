package com.yan01.common_topic.designModule.singleTonModule;

/**
 * 静态内部类
 *
 * 优缺点说明
 * 1)这种方式采用了类装载的机制来保证初始化实例时只有一个线程
 *
 * 2)静态内部类方式在 Singleton类被装载时并不会立即实例化,而是在需要实例化时,调用 getInstance方法,才
 * 会装载 SingletonInstance类,从而完成 Singleton的实例化
 *
 *  3)类的静态属性只会在第一次加载类的时候初始化,所以在这里,JVM帮助我们保证了线程的安全性,在类进行初始化时,别的线程是无法进入的
 *
 * 4)优点:避免了线程不安全,利用静态内部类特点实现延迟加载,效率高
 *
 *  5)结论:推荐使用
 */
public class SingleTonTest7 {

    private static volatile SingleTonTest7 instance;

    private SingleTonTest7(){}

    private static class SingletonInstance{

        private static final SingleTonTest7 INSTANCE = new SingleTonTest7();
    }

    public static synchronized SingleTonTest7 getInstance(){

        return SingletonInstance.INSTANCE;
    }

    //测试
    public static void main(String[] args) {

        SingleTonTest7 instance = SingleTonTest7.getInstance();

        SingleTonTest7 instance2 = SingleTonTest7.getInstance();

        System.out.println(instance == instance2);

        System.out.println("instance.hashCode = "+ instance.hashCode());
        System.out.println("instance.hashCode2 = "+ instance2.hashCode());
    }

}
