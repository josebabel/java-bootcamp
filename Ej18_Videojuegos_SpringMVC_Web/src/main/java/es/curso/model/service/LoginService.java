package es.curso.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.model.entity.Usuario;
import es.curso.model.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	private static boolean access = false;
	
	public boolean checkCreadentials(Usuario u) {
		if(u.getNombre().isEmpty() || u.getPass().isEmpty()) {
			return false;
		}
		return loginRepository.checkCredentials(u);
	}

	public static boolean isAccess() {
		return access;
	}

	public static void setAccess(boolean access) {
		LoginService.access = access;
	}
	
}
