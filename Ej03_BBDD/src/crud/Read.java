package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Coche;

public class Read {
	
	public static void main(String[] args) {
		
		String connection = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try {
			Connection con = DriverManager.getConnection(connection, user, pass);
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM coches");
			
			ResultSet list = stmt.executeQuery();
			
			while(list.next()) {
				Coche c = new Coche();
				
				c.setId(list.getInt("id"));
				c.setMarca(list.getString("marca"));
				c.setModelo(list.getString("modelo"));
				c.setNumKm(list.getInt("num_km"));
				
				System.out.println(c.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
