package com.example.jdbcdemo.domain;

public class Archive implements Comparable<Archive>{
	
	private long id;
	private String name;
	private int teamNumber;
	private String phone;
	
	public Archive(String name, int teamNumber, String phone) {
		super();
		this.name = name;
		this.teamNumber = teamNumber;
		this.phone = phone;
	}
	public Archive() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Archive(int i, String name1, int teamNumber1, String phone1) {
		super();
		this.name = name1;
		this.teamNumber = teamNumber1;
		this.phone = phone1;
	}
	public long getId() {
		return id;
	}
	public void setId(long i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int compareTo(Archive compareArchive) {
		 
		int compareTeamNumber = ((Archive) compareArchive).getTeamNumber(); 
		//ascending order
		return this.teamNumber - compareTeamNumber;
 
		//descending order
		//return compareQuantity - this.quantity;
 
	}	
}
