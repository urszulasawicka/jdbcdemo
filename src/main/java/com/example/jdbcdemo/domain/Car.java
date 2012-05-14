package com.example.jdbcdemo.domain;

public class Car {
	
	private Long id;
	private String model = "test";
	private String make = "test1";
	private int yop = 1990;
	
	public Car(){
		
	}
	
	public Car(String model, String make, int yop){
		this.model = model;
		this.make = make;
		this.yop = yop;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}
	
	

}
