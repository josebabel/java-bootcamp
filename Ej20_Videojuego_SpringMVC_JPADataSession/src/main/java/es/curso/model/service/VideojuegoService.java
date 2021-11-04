package es.curso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.model.entity.Videojuego;
import es.curso.model.repository.VideojuegoRepositoryJPAData;

@Service
public class VideojuegoService {

	@Autowired
	private VideojuegoRepositoryJPAData videojuegoRepositoryJPAData;

	public boolean crear(Videojuego v) {
		if (!v.getNombre().isEmpty() && !v.getCompania().isEmpty() && !v.getCreador().isEmpty()
				&& !v.getFoto().isEmpty() && !v.getEnlace().isEmpty() && v.getNota() >= 0 && v.getPrecio() >= 0) {
			Videojuego game = videojuegoRepositoryJPAData.save(v);
			return true;
		}
		return false;
	}
	
	public void eliminar(int id) {
		Videojuego v = videojuegoRepositoryJPAData.findById(id).orElse(null);
		videojuegoRepositoryJPAData.delete(v);
	}

	public Videojuego listarUno(int id) {
		Videojuego v = videojuegoRepositoryJPAData.findById(id).orElse(null);
		return (v != null) ? v : null;
	}

	public List<Videojuego> listarTodos() {
		return videojuegoRepositoryJPAData.findAll();
	}

}
