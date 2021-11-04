package es.curso.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.model.entity.Usuario;

@Repository
public interface LoginRepositoryJPAData extends JpaRepository<Usuario, Integer>{

	public Usuario findByNombre(String nombre);
	
}
