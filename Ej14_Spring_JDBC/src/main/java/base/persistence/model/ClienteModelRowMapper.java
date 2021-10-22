package base.persistence.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import base.persistence.entity.Cliente;

@Component
public class ClienteModelRowMapper implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente c = new Cliente();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		c.setEdad(rs.getInt("edad"));
		return c;
	}

	
	
}
