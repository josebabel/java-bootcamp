package persistence.controller;

import java.util.List;

import persistence.entity.Coche;
import persistence.model.CocheModel;

public class CocheController {
	
	private CocheModel cocheModel = new CocheModel();
	
	public boolean create(String matricula, String marca, String modelo, int km) {
		
		if(matricula.length() != 7) {
			return false;
		}
				
		Coche c = new Coche();
		c.setMatricula(matricula.toUpperCase());
		c.setMarca(marca);
		c.setModelo(modelo);
		c.setKilometros(km);
		
		return cocheModel.create(c);	
	}
	
	public boolean delete(String matricula) {
		
		if(matricula.length() != 7) {
			return false;
		}
		return cocheModel.delete(matricula.toUpperCase());
	}
	
	public boolean update(String matricula, String marca, String modelo, int km) {
		
		if(matricula.length() != 7) {
			return false;
		}
				
		Coche c = new Coche();
		c.setMatricula(matricula.toUpperCase());
		c.setMarca(marca);
		c.setModelo(modelo);
		c.setKilometros(km);
		
		return cocheModel.update(c);
	}

	public Coche getOne(String matricula) {
		
		if(matricula.length() != 7) {
			return null;
		}
		return cocheModel.getOne(matricula);
	}
	
	public List<Coche> getAll() {
		return cocheModel.getAll();
	}
	
	public boolean exportToExcel() {
		return cocheModel.exportToExcel();
	}
}
