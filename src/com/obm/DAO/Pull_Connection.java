package com.obm.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Pull_Connection{
	private String pathDB = "jdbc:sqlite:DataBase.db";
	private int limit = 0; 
	private List<Connection> listCon = new ArrayList<>();
	public Connection connection = null;
	
	
	public Connection creatConnecion(){
		if(limit == 10) {
			JOptionPane.showMessageDialog(null, "O limite de coneções doi atingido\n Feche as coneções para abirir novas");
			return null;
		}
		if(limit <0)
		limit=0;
		limit++;
		if(limit<=10) {
			try {
				this.connection = DriverManager.getConnection(pathDB);
				listCon.add(connection);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao criar coneção, feche todas as coneções e tente novamente\n"+e.getMessage());
			}
		}
		return connection;
	}
	public Connection getConnecti(Pull_Connection c) {
		return c.connection;
	}
	public void closeConnecti(Pull_Connection c) {
		try {
			c.connection.close();
			limit--;
		} catch (SQLException e) {
		}
		
	}
	public int getLimit() {
		return limit;
	}
}
