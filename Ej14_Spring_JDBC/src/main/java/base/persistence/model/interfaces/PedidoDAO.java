package base.persistence.model.interfaces;

import java.util.List;

import base.persistence.entity.Pedido;

public interface PedidoDAO {

	int addPedidoByClientId(Pedido p);
	List<Pedido> getPedidosByClientId(int id);
	
}
