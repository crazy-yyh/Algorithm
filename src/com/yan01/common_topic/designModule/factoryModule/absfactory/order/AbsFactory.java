package com.yan01.common_topic.designModule.factoryModule.absfactory.order;


import com.yan01.common_topic.designModule.factoryModule.absfactory.pizza.Pizza;

//һ�����󹤳�ģʽ�ĳ����(�ӿ�)
public interface AbsFactory {
	//������Ĺ��������� ����ʵ��
	public Pizza createPizza(String orderType);
}
