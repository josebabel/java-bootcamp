package es.curso.modelo.negocio;

import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.persistencia.LoginModel;

public class LoginGestor {

	private LoginModel loginModel;
	private static boolean access = false;
	
	public boolean checkCreadentials(String nombre, String pass) {
		if(nombre.isEmpty() || pass.isEmpty()) {
			return false;
		}
		
		loginModel = new LoginModel();
		Usuario u = new Usuario(nombre, pass);
		return loginModel.checkCredentials(u);
		
	}

	public static boolean isAccess() {
		return access;
	}

	public static void setAccess(boolean access) {
		LoginGestor.access = access;
	}
	
}
