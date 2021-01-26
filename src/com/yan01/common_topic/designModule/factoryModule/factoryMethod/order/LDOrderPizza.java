package com.yan01.common_topic.designModule.factoryModule.factoryMethod.order;


import com.yan01.common_topic.designModule.factoryModule.factoryMethod.pizza.LDCheesePizza;
import com.yan01.common_topic.designModule.factoryModule.factoryMethod.pizza.LDPepperPizza;
import com.yan01.common_topic.designModule.factoryModule.factoryMethod.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {

	
	@Override
	Pizza createPizza(String orderType) {
	
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		// TODO Auto-generated method stub
		return pizza;
	}

}
