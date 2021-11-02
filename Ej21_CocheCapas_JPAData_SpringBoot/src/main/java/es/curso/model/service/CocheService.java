package es.curso.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.model.entity.Coche;
import es.curso.model.repository.CocheRepositoryJPAData;

@Service
public class CocheService {

	@Autowired
	private CocheRepositoryJPAData cocheRepositoryJPAData;

	@Transactional
	public boolean alta(Coche c) {
		if (c.getMatricula().length() != 7 || c.getMarca().isEmpty() || c.getMatricula().isEmpty()
				|| c.getModelo().isEmpty()) {
			return false;
		}
		cocheRepositoryJPAData.save(c);
		return true;
	}
	
	@Transactional
	public boolean modificar(Coche c) {
		if (c.getId() <= 0 || c.getMatricula().length() != 7 || c.getMarca().isEmpty() || c.getMatricula().isEmpty()
				|| c.getModelo().isEmpty()) {
			return false;
		}
		cocheRepositoryJPAData.save(c);
		return true;
	}
	
	@Transactional
	public boolean baja(int id) {
		Coche c = cocheRepositoryJPAData.findById(id).orElse(null);
		if (c != null) {		
			cocheRepositoryJPAData.delete(c);
			return true;
		} else {
			return false;
		}
	}
	
	public Coche getOne(int id) {
		return cocheRepositoryJPAData.findById(id).orElse(null);
	}

	public List<Coche> getAll() {
		return cocheRepositoryJPAData.findAll();
	}
	
}
