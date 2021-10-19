package persistence.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.entity.Coche;
import persistence.model.interfaces.DAOCoche;
import utils.ConexionBBDD;
import utils.ExcelFile;

public class CocheModel implements DAOCoche {

	private Connection con;

	/**
	 * Crea un registro Coche en la base de datos
	 * @param c Coche que daremos de alta
	 */
	@Override
	public boolean create(Coche c) {

		con = ConexionBBDD.conectar(con);

		if (con == null) {
			return false;
		}

		String sql = "INSERT INTO coches (matricula, marca, modelo, num_km) VALUES(?,?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getMatricula());
			stmt.setString(2, c.getMarca());
			stmt.setString(3, c.getModelo());
			stmt.setInt(4, c.getKilometros());

			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("No se pudo insertar el nuevo registro | Error: " + e.getMessage());
			return false;

		} finally {
			ConexionBBDD.cerrar(con);
		}

		return true;
	}
	
	/**
	 * Borra un registro Coche en la base de datos
	 * @param matricula para borrar el coche en cuestion
	 */
	@Override
	public boolean delete(String matricula) {
		con = ConexionBBDD.conectar(con);

		if (con == null) {
			return false;
		}

		String sql = "DELETE FROM coches WHERE matricula = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, matricula);
			
			int afectadas = stmt.executeUpdate();
			boolean res = (afectadas > 0) ? true : false;
			return res;
		} catch (SQLException e) {
			System.out.println("No se pudo eliminar el registro | Error: " + e.getMessage());
			return false;

		} finally {
			ConexionBBDD.cerrar(con);
		}
	}
	
	/**
	 * Modifica un registro Coche en la base de datos
	 * @param c Coche que queremos actualizar en la base de datos
	 */
	@Override
	public boolean update(Coche c) {
		con = ConexionBBDD.conectar(con);

		if (con == null) {
			return false;
		}

		String sql = "UPDATE coches SET marca = ?, modelo = ?, num_km = ? WHERE matricula = ?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getMarca());
			stmt.setString(2, c.getModelo());
			stmt.setInt(3, c.getKilometros());
			stmt.setString(4, c.getMatricula());
			
			int afectadas = stmt.executeUpdate();
			boolean res = (afectadas > 0) ? true : false;
			return res;
		} catch (SQLException e) {
			System.out.println("No se pudo actualizar el registro | Error: " + e.getMessage());
			return false;

		} finally {
			ConexionBBDD.cerrar(con);
		}
	}
	
	/**
	 * Devuelve un registro Coche de la base de datos
	 * @param matricula del coche que queremos conseguir
	 */
	@Override
	public Coche getOne(String matricula) {
		con = ConexionBBDD.conectar(con);

		if (con == null) {
			return null;
		}

		String sql = "SELECT * FROM coches WHERE matricula = ?";
		Coche c = new Coche();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, matricula);
			
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {	
				c.setId(result.getInt("id"));
				c.setMatricula(result.getString("matricula"));
				c.setMarca(result.getString("marca"));
				c.setModelo(result.getString("modelo"));
				c.setKilometros(result.getInt("num_km"));
			}
			
			Coche res = (c.getMatricula() == null) ? null : c;
			return res;

		} catch (SQLException e) {
			System.out.println("No se pudo obtener el registro | Error: " + e.getMessage());
			return null;

		} finally {
			ConexionBBDD.cerrar(con);
		}
	}

	/**
	 * Devuelve todos los registros Coche de la base de datos
	 */
	@Override
	public List<Coche> getAll() {
		con = ConexionBBDD.conectar(con);

		if (con == null) {
			return null;
		}

		String sql = "SELECT * FROM coches";
		List<Coche> listado = new ArrayList<Coche>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				Coche c = new Coche();
				c.setId(result.getInt("id"));
				c.setMatricula(result.getString("matricula"));
				c.setMarca(result.getString("marca"));
				c.setModelo(result.getString("modelo"));
				c.setKilometros(result.getInt("num_km"));
				
				listado.add(c);
			}

		} catch (SQLException e) {
			System.out.println("No se pudo obtener los registros | Error: " + e.getMessage());
			return null;

		} finally {
			ConexionBBDD.cerrar(con);
		}
		return listado;
	}

	/**
	 * Exporta la base de datos a un fichero Excel
	 */
	@Override
	public boolean exportToExcel() {
		con = ConexionBBDD.conectar(con);

		if (con == null) {
			return false;
		}

		String sql = "SELECT * FROM coches";
		List<Coche> listado = new ArrayList<Coche>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				Coche c = new Coche();
				c.setId(result.getInt("id"));
				c.setMatricula(result.getString("matricula"));
				c.setMarca(result.getString("marca"));
				c.setModelo(result.getString("modelo"));
				c.setKilometros(result.getInt("num_km"));
				
				listado.add(c);
			}

		} catch (SQLException e) {
			System.out.println("No se pudo obtener los registros | Error: " + e.getMessage());
			return false;

		} finally {
			ConexionBBDD.cerrar(con);
		}
		
		return ExcelFile.createFile(listado);
	}

}
