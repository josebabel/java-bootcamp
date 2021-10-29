package es.curso.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.model.entity.Usuario;
import es.curso.model.repository.LoginRepositoryJPAData;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepositoryJPAData loginRepositoryJPAData;
	private static boolean access = false;
	
	@Transactional
	public boolean checkCredentials(String nombre, String pass) {	
		Usuario u = loginRepositoryJPAData.findByNombre(nombre);
		
		if(u != null && u.getPass().equals(pass)) {
			return true;
		} else {
			return false;
		}	
	}
	
	public static boolean isAccess() {
		return access;
	}

	public static void setAccess(boolean access) {
		LoginService.access = access;
	}
}
