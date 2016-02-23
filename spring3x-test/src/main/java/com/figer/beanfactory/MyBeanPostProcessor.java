package com.figer.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.figer.domain.Car;

public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("car".equals(beanName)) {
			Car car = (Car)bean;
			if (null == car.getName() || "".equals(car.getName())) {
				car.setName("figer");
				System.out.println("set car name by BeanPostProcessor.postProcessBeforeInitialization");
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

}
