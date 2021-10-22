package base.persistence.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import base.persistence.entity.Pedido;

@Component
public class PedidoModelRowMapper implements RowMapper<Pedido>{

	@Override
	public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pedido p = new Pedido();
		p.setId(rs.getInt("id"));
		p.setImporte(rs.getInt("importe"));
		p.setFecha(rs.getDate("fecha"));
		return p;
	}

}
