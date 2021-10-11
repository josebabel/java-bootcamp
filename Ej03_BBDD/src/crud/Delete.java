package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Coche;

public class Delete {

	public static void main(String[] args) {

		String connection = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try {
			Connection con = DriverManager.getConnection(connection, user, pass);
			
			PreparedStatement stmt = con.prepareStatement("DELETE FROM coches WHERE id = ?");
			
			Coche c = new Coche();
			c.setId(9);

			stmt.setInt(1, c.getId());
			
			int afectados = stmt.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros eliminados: "+ afectados);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
