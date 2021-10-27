package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import es.curso.modelo.entidad.Usuario;

public class LoginModel {
	
	private List<Usuario> listUsuarios = new ArrayList<Usuario>();

	public LoginModel() {
		listUsuarios.add(new Usuario("Jose","1234"));
		listUsuarios.add(new Usuario("admin","1234"));
	}
	
	public boolean checkCredentials(Usuario u) {	
		for (Usuario usuario : listUsuarios) {
			if( (usuario.getNombre().equals(u.getNombre())) && (usuario.getPass().equals(u.getPass()))) {
				return true;
			}
		}
		return false;
	}

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}
	
	
	
}
