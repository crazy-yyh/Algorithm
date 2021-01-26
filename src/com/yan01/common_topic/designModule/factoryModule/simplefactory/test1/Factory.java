package com.yan01.common_topic.designModule.factoryModule.simplefactory.test1;

/**
 * @author yyh
 * @create 2020-11-08 23:22
 */
public class Factory {

    public Phone getPhone(String phone){
        if(phone.equalsIgnoreCase("MiPhone")){
            return new MiPhone();
        }else if(phone.equalsIgnoreCase("IPhone")){
            return new IPhone();
        }
        return null;
    }

    public static void main(String[] args) {
        Factory f = new Factory();
        System.out.println(f.getPhone("MiPhone"));
    }
}
