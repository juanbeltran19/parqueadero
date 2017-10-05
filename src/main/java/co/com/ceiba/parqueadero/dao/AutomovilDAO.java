package co.com.ceiba.parqueadero.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.management.RuntimeErrorException;
import co.com.ceiba.parqueadero.dto.AutomovilDTO;
import co.com.ceiba.parqueadero.dao.ConectarBD;

public class AutomovilDAO{
	
	private Connection conexion;
	private Statement sentencia; 
	private ResultSet resultado;
	private ConectarBD conectarBD;
	
	public List<AutomovilDTO> getAutomoviles() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		 	String url= "jdbc:mysql://localhost/bd_parqueadero"; 
		    conexion=DriverManager.getConnection(url,"root", "admin");		
		    sentencia=conexion.createStatement();
			String sql = "select placa, tipo, fechaingreso from automiviles";
			resultado = sentencia.executeQuery(sql);
			List<AutomovilDTO> lista = new ArrayList<>();
			while(resultado.next()) {
				AutomovilDTO dto = new AutomovilDTO();
				dto.setPlaca( resultado.getString("placa") );
				dto.setTipo( resultado.getString("tipo") );
				dto.setFechaIngreso( resultado.getString("fechaingreso") );
				lista.add(dto);
			}
			return lista;
		}catch(Exception ex) {
			throw new RuntimeException(ex); 
		}
	}
	
	public List<AutomovilDTO> getAutomovil(String placa) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		 	String url= "jdbc:mysql://localhost/bd_parqueadero"; 
		    conexion=DriverManager.getConnection(url,"root", "admin");		
		    sentencia=conexion.createStatement();
			String sql = "select placa, tipo, fechaingreso from automiviles where placa='"+placa+"'";
			resultado = sentencia.executeQuery(sql);
			List<AutomovilDTO> lista = new ArrayList<>();
			while(resultado.next()) {
				AutomovilDTO dto = new AutomovilDTO();
				dto.setPlaca( resultado.getString("placa") );
				dto.setTipo( resultado.getString("tipo") );
				dto.setFechaIngreso( resultado.getString("fechaingreso") );
				lista.add(dto);
			}
			return lista;
		}catch(Exception ex) {
			throw new RuntimeException(ex); 
		}
	}	

	public int getCantidadAutomovil(String tipo) {
		String sql = "";
		int cuentaAutomovil = 0;
		try {
			conectarBD = new ConectarBD();
			sql = "select count(tipo) from automiviles where tipo="+tipo+"";
			resultado = conectarBD.getSentencia().executeQuery(sql);
			if("Carro".equals(tipo)) {
				while(resultado.next()) {
					cuentaAutomovil = resultado.getInt(1);
				}
			}else {
				while(resultado.next()) {
					cuentaAutomovil = resultado.getInt(1);
				}				
			}
			return cuentaAutomovil;
		}catch(Exception ex) {
			throw new RuntimeException(ex); 
		}
	}	
	
	public int getCantidadCarros(String tipo) {
		String sql = "";
		int cuentaAutomovil = 0;
		try {
			conectarBD = new ConectarBD();
			sql = "select count(tipo) as cantidad from automiviles where tipo='"+tipo+"'";
			resultado = conectarBD.getSentencia().executeQuery(sql);
			while(resultado.next()) {
					cuentaAutomovil = resultado.getInt("cantidad");
			}
			return cuentaAutomovil;
		}catch(Exception ex) {
			throw new RuntimeException(ex); 
		}
	}
	
	public int getCantidadMotos(String tipo) {
		String sql = "";
		int cuentaAutomovil = 0;
		try {
			conectarBD = new ConectarBD();
			sql = "select count(tipo) as cantidad from automiviles where tipo='"+tipo+"'";
			resultado = conectarBD.getSentencia().executeQuery(sql);
			while(resultado.next()) {
				cuentaAutomovil = resultado.getInt("cantidad");
			}
			return cuentaAutomovil;
		}catch(Exception ex) {
			throw new RuntimeException(ex); 
		}
	}		
	
}
