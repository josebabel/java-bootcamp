package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Coche;

public class Update {

	public static void main(String[] args) {

		String connection = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try {
			Connection con = DriverManager.getConnection(connection, user, pass);
			
			PreparedStatement stmt = con.prepareStatement("UPDATE coches SET marca = ?, modelo = ?, num_km = ? WHERE id = ?");
			
			Coche c = new Coche();
			c.setId(9);
			c.setMarca("Audi");
			c.setModelo("A4");
			c.setNumKm(60000);
					
			stmt.setString(1, c.getMarca());
			stmt.setString(2, c.getModelo());
			stmt.setInt(3, c.getNumKm());
			stmt.setInt(4, c.getId());
			
			int afectados = stmt.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros actualizados: "+ afectados);
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
