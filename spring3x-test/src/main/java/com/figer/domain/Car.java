package com.figer.domain;

import org.apache.commons.logging.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//管理bean生命周期的接口
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
	private String carId;
	private String name;
	private int maxSpeed;
	
	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getName() {
		return name;
	}

	public Car() {
		System.out.println("调用car无参数构造器");
	}
	
	public void init(){
		System.out.println("init car");
		this.carId = "car-1";
	}
	
	public void setName(String name) {
		System.out.println("调用setName()设置属性");
		this.name = name;
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("调用DisposableBean.destroy().");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用InitializingBean.afterPropertiesSet().");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("调用BeanAware.setBeanName().");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用BeanFactoryAware.setBeanFactory().");
	}
	
	@Override
	public String toString() {
		return "car.carId:" + carId + ",car.carName:" + name + "car.maxSpeed:" + maxSpeed;
	}
	
	public static void main(String[] args) {
		System.out.println(Car.class.getClassLoader().getResource("").getPath());
		System.out.println(Log.class.getClassLoader().getResource("").getPath());
	}

}
