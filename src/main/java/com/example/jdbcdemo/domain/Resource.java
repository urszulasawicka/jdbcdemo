package com.example.jdbcdemo.domain;

public class Resource {
	
	private long id;
	private String name;
	private String author;
	private int date;
	private int teamNumber;
	
	public Resource() {
		super();
	}
	public Resource(String name, String author, int date) {
		super();
		this.name = name;
		this.author = author;
		this.date = date;
	}
	public Resource(long id, String name, String author, int date) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.date = date;
	}
	public Resource(String name1, String author1, int date1, int teamnumber1) {
		super();
		this.name = name1;
		this.author = author1;
		this.date = date1;
		this.teamNumber = teamnumber1;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}

}
