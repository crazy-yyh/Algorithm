package com.yan01.common_topic.designModule.factoryModule.factoryMethod.order;


import com.yan01.common_topic.designModule.factoryModule.factoryMethod.pizza.BJCheesePizza;
import com.yan01.common_topic.designModule.factoryModule.factoryMethod.pizza.BJPepperPizza;
import com.yan01.common_topic.designModule.factoryModule.factoryMethod.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {

	
	@Override
	Pizza createPizza(String orderType) {
	
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new BJPepperPizza();
		}
		// TODO Auto-generated method stub
		return pizza;
	}

}
