package es.curso.model.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.curso.model.entity.Usuario;

@Repository
public class LoginRepository {

	@Autowired
	@Qualifier("listUsuarios")
	private List<Usuario> listUsuarios;
	
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
