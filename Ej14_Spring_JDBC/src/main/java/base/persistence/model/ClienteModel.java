package base.persistence.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import base.persistence.entity.Cliente;
import base.persistence.model.interfaces.ClienteDAO;

@Repository
public class ClienteModel implements ClienteDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ClienteModelRowMapper clienteModelRowMapper;
	
	@Override
	public int crear(Cliente c) {
		String query = "INSERT INTO clientes (nombre, edad) VALUES(?, ?)";
		int rows = jdbcTemplate.update(query, c.getNombre(), c.getEdad());
		return rows;
	}

	@Override
	public int eliminar(int id) {
		String query = "DELETE FROM clientes WHERE id = ?";
		int rows = jdbcTemplate.update(query, id);
		return rows;
	}

	@Override
	public int modificar(Cliente c) {
		String query = "UPDATE clientes SET nombre = ?, edad = ? WHERE id = ?";
		int rows = jdbcTemplate.update(query, c.getNombre(), c.getEdad(), c.getId());
		return rows;
	}

	@Override
	public Cliente getById(int id) {
		String query = "SELECT id, nombre, edad FROM clientes WHERE id = ?";
		Cliente c;
		try {
			c = jdbcTemplate.queryForObject(query, clienteModelRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return c;
	}

	@Override
	public List<Cliente> getByName(String name) {
		String query = "SELECT id, nombre, edad FROM clientes WHERE nombre = ?";
		List<Cliente> listClientes;
		try {
			listClientes = jdbcTemplate.query(query, clienteModelRowMapper, name);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return listClientes;
	}

}
