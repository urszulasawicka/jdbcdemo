package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.example.jdbcdemo.domain.Archive;

public class ArchiveManager {
	private Connection connection;
	private Statement statement;

	private PreparedStatement addArchiveStmt;
	private PreparedStatement deleteAllArchivesStmt;
	private PreparedStatement getAllArchivesStmt;
	private PreparedStatement updateArchiveStmt;
	private PreparedStatement deleteArchiveStmt;
	private PreparedStatement searchArchiveStmt;

	private String createArchiveTable = "CREATE TABLE Archive(id bigint GENERATED BY DEFAULT AS IDENTITY, name varchar(20), teamNumber integer, phone varchar(20))";

	private String url = "jdbc:hsqldb:hsql://localhost/workdb";

	public ArchiveManager() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;

			while (rs.next()) {
				if ("Archive".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
			if (!tableExists)
				statement.executeUpdate(createArchiveTable);

			addArchiveStmt = connection
					.prepareStatement("INSERT INTO Archive (name, teamNumber, phone) VALUES (?,?,?)");
			getAllArchivesStmt = connection
					.prepareStatement("SELECT id, name, teamNumber, phone From Archive");
			deleteAllArchivesStmt = connection
					.prepareStatement("DELETE FROM Archive");
			updateArchiveStmt = connection
					.prepareStatement("UPDATE archive SET name = ?, phone = ? WHERE teamNumber = ?");
			deleteArchiveStmt = connection
					.prepareStatement("DELETE FROM Archive WHERE teamNumber = ?");
			searchArchiveStmt = connection
					.prepareStatement("SELECT id, name, teamNumber, phone From Archive WHERE teamNumber = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int addArchive(Archive archive) {
		int count = 0;
		try {
			addArchiveStmt.setString(1, archive.getName());
			addArchiveStmt.setInt(2, archive.getTeamNumber());
			addArchiveStmt.setString(3, archive.getPhone());
			count = addArchiveStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void clearArchives() {
		try {
			deleteAllArchivesStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Set<Archive> getAllArchives() {
		 Set<Archive> archives =new TreeSet<Archive>();
		//List<Archive> archives = new ArrayList<Archive>();
		try {
			ResultSet rs = getAllArchivesStmt.executeQuery();
			while (rs.next()) {
				Archive a = new Archive();
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setTeamNumber(rs.getInt("teamNumber"));
				a.setPhone(rs.getString("phone"));
				archives.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return archives;
	}

	public int updateArchive(Archive archive) {
		int count = 0;
		try {
			ResultSet rs = getAllArchivesStmt.executeQuery();
			while (rs.next()) {
				if(((Integer)rs.getInt("teamNumber")).equals((Integer)archive.getTeamNumber())){
					updateArchiveStmt.setString(1, archive.getName());
					updateArchiveStmt.setString(2, archive.getPhone());
					updateArchiveStmt.setInt(3, archive.getTeamNumber());
					count = updateArchiveStmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int deleteArchive(Archive archive) {
		int count = 0;
		try {
			ResultSet rs = getAllArchivesStmt.executeQuery();
			while (rs.next()) {
				if(((Integer)rs.getInt("teamNumber")).equals((Integer)archive.getTeamNumber())){
					deleteArchiveStmt.setInt(1, archive.getTeamNumber());
					count = deleteArchiveStmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int searchArchive(Archive archive) {
		int count = 0;
		try {
			ResultSet rs = getAllArchivesStmt.executeQuery();
			while (rs.next()) {
				if(((Integer)rs.getInt("teamNumber")).equals((Integer)archive.getTeamNumber())){
					count++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
