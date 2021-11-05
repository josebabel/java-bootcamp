package es.curso.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.curso.model.entity.Videojuego;

public interface VideojuegoRepositoryMongo extends MongoRepository<Videojuego, Integer>{

}
