package es.curso.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.model.entity.Videojuego;
import es.curso.model.repository.VideojuegoRepositoryJPAData;

@Service
public class VideojuegoService {
	
	@Autowired
	private VideojuegoRepositoryJPAData videojuegoRepositoryJPAData;

	@Transactional
	public Videojuego findOne(int id) {
		return videojuegoRepositoryJPAData.findById(id).orElse(null);
	}
	
	public List<Videojuego> findAll() {
		return videojuegoRepositoryJPAData.findAll();
	}
	
}
