package com.yan01.common_topic.designModule.singleTonModule;


/**
 * 懒汉式（线程安全 同步方法）
 *
 * 优缺点说明
 * )解决了线程安全问题
 * 2)效率太低了,每个线程在想获得类的实例时候,执行 getInstance∽方法都要进行同步。而其实这个方法只执行
 * 实例化代码就够了,后面的想获得该类实例,直接 return就行了。方法进行同步效率太低
 * 3)结论:在实际开发中,不推荐使用这种方式
 */
public class SingleTonTest4 {

    private static SingleTonTest4 instance;

    private SingleTonTest4(){}

    public static synchronized SingleTonTest4 getInstance(){

        if(instance == null){
            instance = new SingleTonTest4();
        }

        return instance;
    }

    //测试
    public static void main(String[] args) {

        SingleTonTest4 instance = SingleTonTest4.getInstance();

        SingleTonTest4 instance2 = SingleTonTest4.getInstance();

        System.out.println(instance == instance2);

        System.out.println("instance.hashCode = "+ instance.hashCode());
        System.out.println("instance.hashCode2 = "+ instance2.hashCode());
    }

}
