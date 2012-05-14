package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.jdbcdemo.domain.Car;

public class CarManager {
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement addCarStmt;
	
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	private String createCarTable = "CREATE TABLE Car(id bigint GENERATED BY DEFAULT AS IDENTITY, model varchar(20), make varchar(20), yop integer)";
	public CarManager(){
		
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();
			
			//czy tabela istnieje
			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Car".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createCarTable);
			
			addCarStmt = connection
					.prepareStatement("INSERT INTO Car (model, make, yop) VALUES (?, ?, ?)");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//package scope
	Connection getConnection(){
		return connection;
	}
	
	public int addCar(Car car){
		int count = 0;
		try {
			addCarStmt.setString(1, car.getModel());
			addCarStmt.setString(2, car.getMake());
			addCarStmt.setInt(3, car.getYop());
			count = addCarStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}