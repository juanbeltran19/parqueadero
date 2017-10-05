package co.com.ceiba.parqueadero.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectarBD {
	
	private Connection conexion;
	private Statement sentencia; 
	
	public ConectarBD() throws Exception{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	 	String url= "jdbc:mysql://localhost/bd_parqueadero"; 
	    conexion=DriverManager.getConnection(url,"root", "admin");		
	    sentencia=conexion.createStatement();				
	}
	
	public Statement getSentencia() {
		return sentencia;
	}
	
}
