package base.persistence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.persistence.entity.Pedido;
import base.persistence.model.PedidoModel;

@Service
public class PedidoController {

	@Autowired
	private PedidoModel pedidoModel;
	
	public int addPedidoByClientId(Pedido p) {
		if(p.getImporte() < 0 || p.getId_cliente() <= 0) {
			return -1;
		}
		return pedidoModel.addPedidoByClientId(p);
	}
	
	public List<Pedido> getPedidosByClientId(int id) {
		if(id <= 0) {
			return null;
		}
		return pedidoModel.getPedidosByClientId(id);
	}
	
}
