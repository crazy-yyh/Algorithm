package com.yan01.common_topic.designModule.factoryModule.absfactory.order;


import com.yan01.common_topic.designModule.factoryModule.absfactory.pizza.BJCheesePizza;
import com.yan01.common_topic.designModule.factoryModule.absfactory.pizza.BJPepperPizza;
import com.yan01.common_topic.designModule.factoryModule.absfactory.pizza.Pizza;

//���ǹ�������
public class BJFactory implements AbsFactory {

	@Override
	public Pizza createPizza(String orderType) {
		System.out.println("~ʹ�õ��ǳ��󹤳�ģʽ~");
		// TODO Auto-generated method stub
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")){
			pizza = new BJPepperPizza();
		}
		return pizza;
	}

}
