package modelo.interfaces;

import java.util.List;
import entidad.Coche;

public interface DAOCoche {
	
	boolean create(Coche c);
	boolean delete(String matricula);
	boolean update(Coche c);
	Coche getOne(String matricula);
	List<Coche> getAll();

}
