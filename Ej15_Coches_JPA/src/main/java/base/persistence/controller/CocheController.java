package base.persistence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.persistence.entity.Coche;
import base.persistence.model.CocheModel;

@Service
public class CocheController {

	@Autowired
	private CocheModel cocheModel;
	
	@Transactional
	public int create(Coche c) {
		if(c.getMarca().isEmpty() || c.getModelo().isEmpty() || c.getMatricula().length() != 7) {
			return -1;
		}
		return cocheModel.create(c);
	}

	@Transactional
	public Coche update(Coche c) {
		if(c.getMarca().isEmpty() || c.getModelo().isEmpty() || c.getMatricula().length() != 7) {
			return null;
		}
		return cocheModel.update(c);
	}

	@Transactional
	public int delete(int id) {
		return cocheModel.delete(id);
	}

	public Coche getOne(int id) {
		return cocheModel.getOne(id);
	}

	public List<Coche> getAll() {
		return cocheModel.getAll();
	}
	
}
