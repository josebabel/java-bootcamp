package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Coche;

public class Create {

	public static void main(String[] args) {
		
		String connection = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try {
			Connection con = DriverManager.getConnection(connection, user, pass);
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO coches (marca, modelo, num_km) VALUES(?, ?, ?)");
			
			Coche c = new Coche();
			c.setMarca("Audi");
			c.setModelo("A4");
			c.setNumKm(35000);
			
			stmt.setString(1, c.getMarca());
			stmt.setString(2, c.getModelo());
			stmt.setInt(3, c.getNumKm());
			
			int afectados = stmt.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros insertados: "+afectados);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
