package com.yan01.common_topic.designModule.factoryModule;

/**
 * @author yyh
 * @create 2020-11-08 23:23
 */
public class MiPhone implements Phone {

    public MiPhone(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("make xiaomi phone");
    }
}
