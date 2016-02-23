package com.figer.beanfactory;

import com.figer.domain.Car;

public class CarFactory {
	public static Car getInstance(){
		Car car = new Car();
		car.setCarId("car-factory-static");
		car.setName("newCar");
		return car;
	}
	
	public Car createCar(){
		Car car = new Car();
		car.setCarId("car-factory");
		car.setName("newCar");
		return car;
	}
}
