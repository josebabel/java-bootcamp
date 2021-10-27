package es.curso.modelo.negocio;

import java.util.List;

import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.persistencia.VideojuegoModel;

public class VideojuegoGestor {

	private VideojuegoModel videojuegoModel;
	private static boolean error = false;
	
	public List<Videojuego> listVideogames() {
		videojuegoModel = new VideojuegoModel();
		return videojuegoModel.getListVideojuego();
	}
	
	public Videojuego getVideojuegoById(String id) {
		videojuegoModel = new VideojuegoModel();
		int idS = Integer.parseInt(id);
		return videojuegoModel.getVideojuegoById(idS);
	}

	public static boolean isError() {
		return error;
	}

	public static void setError(boolean error) {
		VideojuegoGestor.error = error;
	}
	
	
	
}
