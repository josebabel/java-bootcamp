package es.curso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.model.entity.Videojuego;
import es.curso.model.repository.VideojuegoRepository;

@Service
public class VideojuegoService {

	@Autowired
	private VideojuegoRepository videojuegoRepository;
	
	public List<Videojuego> listVideogames() {
		return videojuegoRepository.getListVideojuegos();
	}
	
	public Videojuego getVideojuegoById(String id) {
		int idS = Integer.parseInt(id);
		return videojuegoRepository.getVideojuegoById(idS);
	}
	
}
