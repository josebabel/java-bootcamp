package es.curso.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.model.entity.Videojuego;

@Repository
public interface VideojuegoRepositoryJPAData extends JpaRepository<Videojuego, Integer>{

	
}
