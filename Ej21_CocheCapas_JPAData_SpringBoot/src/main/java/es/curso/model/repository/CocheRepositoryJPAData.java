package es.curso.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.model.entity.Coche;

@Repository
public interface CocheRepositoryJPAData extends JpaRepository<Coche, Integer>{

}
