package base.persistence.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import base.persistence.entity.Pedido;
import base.persistence.model.interfaces.PedidoDAO;

@Repository
public class PedidoModel implements PedidoDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PedidoModelRowMapper pedidoModelRowMapper;

	@Override
	public int addPedidoByClientId(Pedido p) {
		String query = "INSERT INTO pedidos (importe, id_cliente) VALUES (?,?)";
		int rows;
		try {
			rows = jdbcTemplate.update(query, p.getImporte(), p.getId_cliente());
		} catch (DataIntegrityViolationException e) {
			return -1;
		}
		return rows;
	}

	@Override
	public List<Pedido> getPedidosByClientId(int id) {
		String query = "SELECT id, importe, fecha FROM pedidos WHERE id_cliente = ?";
		List<Pedido> listPedidos;
		try {
			listPedidos = jdbcTemplate.query(query, pedidoModelRowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return listPedidos;
	}
	
	

}
