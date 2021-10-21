package base.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.model.OrdenadorModel;
import base.model.entity.Ordenador;

@Service
public class OrdenadorController {

	@Autowired
	private OrdenadorModel ordenadorModel;
	
	public boolean createFile(Ordenador o) {
		
		return ordenadorModel.createFile(o);
	}
	
}
