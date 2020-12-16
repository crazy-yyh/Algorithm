package com.yan01.common_topic.designModule.singleTonModule;


/**
 * 懒汉式（线程不安全）
 *
 * 优缺点说明
 * 1)起到了 Lazy loading的效果,但是只能在单线程下使用
 * 如果在多线程下,一个线程进入了if( singleton=nul)判断语句块,还未来得及往下执行,另一个线程也通过
 * 了这个判断语句,这时便会产生多个实例。所以在多线程环境下不可使用这种方式
 * 3)结论:在实际开发中,不要使用这种方式
 */
public class SingleTonTest3 {

    private static SingleTonTest3 instance;

    private SingleTonTest3(){}

    public static SingleTonTest3 getInstance(){

        if(instance == null){
            instance = new SingleTonTest3();
        }

        return instance;
    }

    //测试
    public static void main(String[] args) {

        SingleTonTest3 instance = SingleTonTest3.getInstance();

        SingleTonTest3 instance2 = SingleTonTest3.getInstance();

        System.out.println(instance == instance2);

        System.out.println("instance.hashCode = "+ instance.hashCode());
        System.out.println("instance.hashCode2 = "+ instance2.hashCode());
    }
}
