package com.yan01.common_topic.designModule.singleTonModule;


/**
 * 饿汉式（静态代码块）
 *
 * 优缺点说明
 * 1)这种方式和上面的方式其实类似,只不过将类实例化的过程放在了静态代码块中,也是在类装载的时候,就执
 * 行静态代码块中的代码,初始化类的实例。优缺点和上面是一样的
 * 2)结论:这种单例模式可用,但是可能造成内存浪费
 *
 */
public class SingleTonTest2 {

    private static SingleTonTest2 instance;

    private SingleTonTest2(){}

    static{
        instance = new SingleTonTest2();
    }

    public static SingleTonTest2 getInstance(){
        return instance;
    }


    //测试
    public static void main(String[] args) {

        SingleTonTest2 instance = SingleTonTest2.getInstance();

        SingleTonTest2 instance2 = SingleTonTest2.getInstance();

        System.out.println(instance == instance2);

        System.out.println("instance.hashCode = "+ instance.hashCode());
        System.out.println("instance.hashCode2 = "+ instance2.hashCode());
    }
}
