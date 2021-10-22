package base.persistence.model.interfaces;

import java.util.List;

import base.persistence.entity.Cliente;

public interface ClienteDAO {

	int crear(Cliente c);
	int eliminar(int id);
	int modificar(Cliente c);
	Cliente getById(int id);
	List<Cliente> getByName(String name);
}
