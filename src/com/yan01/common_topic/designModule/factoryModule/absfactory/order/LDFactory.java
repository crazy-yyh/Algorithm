package com.yan01.common_topic.designModule.factoryModule.absfactory.order;


import com.yan01.common_topic.designModule.factoryModule.absfactory.pizza.LDCheesePizza;
import com.yan01.common_topic.designModule.factoryModule.absfactory.pizza.LDPepperPizza;
import com.yan01.common_topic.designModule.factoryModule.absfactory.pizza.Pizza;

public class LDFactory implements AbsFactory {

	@Override
	public Pizza createPizza(String orderType) {
		System.out.println("~ʹ�õ��ǳ��󹤳�ģʽ~");
		Pizza pizza = null;
		if (orderType.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		return pizza;
	}

}
