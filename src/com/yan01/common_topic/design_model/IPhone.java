package com.yan01.common_topic.design_model;

/**
 * @author yyh
 * @create 2020-11-08 23:24
 */
public class IPhone implements Phone {

    public IPhone() {
        this.make();
    }

    @Override
    public void make() {
        System.out.println("make iphone");
    }
}
