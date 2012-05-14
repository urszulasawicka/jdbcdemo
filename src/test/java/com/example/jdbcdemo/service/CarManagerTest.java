package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.jdbcdemo.domain.Car;

public class CarManagerTest {
	CarManager carManager = new CarManager();
	private final static String MODEL = "Test";
	private final static String MAKE = "Test1";
	private final static int YOP = 1945;
	
	@Test
	public void checkConnection(){
		assertNotNull(carManager.getConnection());
	}
	
	@Test
	public void checkAddCar(){
		Car car = new Car(MODEL, MAKE, YOP);
		assertEquals(1,carManager.addCar(car));
	}

}
