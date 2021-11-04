package es.curso.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.model.entity.Usuario;
import es.curso.model.repository.LoginRepositoryJPAData;

@Service
public class LoginService {

	@Autowired
	private LoginRepositoryJPAData loginRepositoryJPAData;
	
	public boolean checkCredentials(String nombre, String pass) {	
		Usuario u = loginRepositoryJPAData.findByNombre(nombre);
		return (u != null && u.getPass().equals(pass)) ? true : false;
	}
	
	@Transactional
	public boolean registerUser(Usuario regUser) {
		Usuario u = loginRepositoryJPAData.save(regUser);
		return (u != null) ? true : false;
	}
	
}
