package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	
	public static Connection conectar(Connection conexion) {
		
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String usuario = "root";
		String password = "";
		
		try {
			conexion = DriverManager.getConnection(url, usuario, password);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conexion;
	}
	
	public static boolean cerrar(Connection conexion) {
		
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
