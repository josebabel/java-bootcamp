package es.curso.model.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.curso.model.entity.Videojuego;

@Repository
public class VideojuegoRepository {
	
	@Autowired
	@Qualifier("listVideojuegos")
	private List<Videojuego> listVideojuegos;
	
	public List<Videojuego> getListVideojuegos() {
		return listVideojuegos;
	}

	public Videojuego getVideojuegoById(int id) {
		try {
			Videojuego v = listVideojuegos.get(id);
			return v;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
