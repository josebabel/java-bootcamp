package base.persistence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.persistence.entity.Cliente;
import base.persistence.model.ClienteModel;

@Service
public class ClienteController {

	@Autowired
	private ClienteModel clienteModel;
	
	public int crear(Cliente c) {
		if(c.getNombre().isEmpty() || c.getEdad() <= 0) {
			return -1;
		}
		return clienteModel.crear(c);
	}
	
	public int eliminar(int id) {
		if(id <= 0) {
			return -1;
		}
		return clienteModel.eliminar(id);
	}
	
	public int modificar(Cliente c) {
		if(c.getNombre().isEmpty() || c.getEdad() <= 0 || c.getId() <= 0) {
			return -1;
		}
		return clienteModel.modificar(c);
	}
	
	public Cliente getById(int id) {
		if(id <= 0) {
			return null;
		}
		return clienteModel.getById(id);
	}
	
	public List<Cliente> getByName(String name) {
		if(name.isEmpty()) {
			return null;
		}
		return clienteModel.getByName(name);
	}
}
