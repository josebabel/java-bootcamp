package base.persistence.model.interfaces;

import java.util.List;

import base.persistence.entity.Coche;

public interface DAOCoche {

	int create(Coche c);
	Coche update(Coche c);
	int delete(int id);
	Coche getOne(int id);
	List<Coche> getAll();
	
}
