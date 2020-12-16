package com.yan01.common_topic.designModule.singleTonModule;

/**
 * 枚举
 *
 * 这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题,而且还能防止反序列化重新创建新的对象。
 *
 * 2)这种方式是 Effective java作者 Josh bloch提倡的方式
 *
 * 3)结论:推荐使用
 */

public class SingleTonTest8 {

    //测试
    public static void main(String[] args) {

        Singleton instance = Singleton.INSTANCE;

        Singleton instance2 = Singleton.INSTANCE;

        System.out.println(instance == instance2);

        System.out.println("instance.hashCode = "+ instance.hashCode());
        System.out.println("instance.hashCode2 = "+ instance2.hashCode());

        instance.sayOK();
    }

}

enum Singleton{

    //属性
    INSTANCE;

    public void sayOK(){
        System.out.println("ok");
    }
}
