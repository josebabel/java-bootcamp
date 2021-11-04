package es.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.entity.Videojuego;

@Repository
public interface VideojuegoRepositoryJPAData extends JpaRepository<Videojuego, Integer>{
	
	public List<Videojuego> findByNombre(String nombre);
	public List<Videojuego> findByCompania(String compania);
	
}
