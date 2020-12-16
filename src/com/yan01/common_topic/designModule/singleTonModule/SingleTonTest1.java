package com.yan01.common_topic.designModule.singleTonModule;


/**
 * 饿汉式（静态变量）
 *
 * 1.构造器私有化（防止new)
 * 2.类的内部创建对象
 * 3.向外暴露一个静态的公共方法
 *
 * 优缺点说明
 * 1)优点:这种写法比较简单,就是在类装载的时候就完成实例化。避免了线程同步问题。
 * 2)缺点:在类装载的时候就完成实例化,没有达到 Lazy Loading的效果。如果从始至终从未使用过这个实例,则
 * 会造成内存的浪费
 *
 * 这种方式基于 classloader机制避免了多线程的同步问题,不过, instance在类装载时就实例化,在单例模式中大
 * 多数都是调用 getInstance方法,但是导致类装载的原因有很多种,因此不能确定有其他的方式(或者其他的静
 * 态方法)导致类裝载,这时候初始化 instance就没有达到 lazy loading的效果
 *
 * 4)结论:这种单例模式可用,可能造成内存浪费
 */
public class SingleTonTest1{

    private final static SingleTonTest1 instance = new SingleTonTest1();

    private SingleTonTest1(){}

    public static SingleTonTest1 getInstance(){
        return instance;
    }



    //测试
    public static void main(String[] args) {

        SingleTonTest1 instance = SingleTonTest1.getInstance();

        SingleTonTest1 instance2 = SingleTonTest1.getInstance();

        System.out.println(instance == instance2);

        System.out.println("instance.hashCode = "+ instance.hashCode());
        System.out.println("instance.hashCode2 = "+ instance2.hashCode());
    }
}
