package es.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import es.curso.modelo.entidad.Videojuego;

public class VideojuegoModel {

	private List<Videojuego> listVideojuego = new ArrayList<Videojuego>();

	public VideojuegoModel() {
		listVideojuego.add(new Videojuego(0, "Battlefield 2042", "EA", 8.9, "DICE",
				"https://www.ea.com/es-es/games/battlefield/battlefield-2042",
				"https://cdn.cloudflare.steamstatic.com/steam/apps/1517290/capsule_616x353.jpg?t=1634670876"));
		listVideojuego.add(new Videojuego(1, "Call Of Duty Vanguard", "Activision", 7.4, "Sledgehammer Games",
				"https://www.callofduty.com/content/atvi/callofduty/vanguard/web/es/home.html",
				"https://generacionxbox.com/wp-content/uploads/2021/08/call-of-duty-vanguard-1.jpg"));
		listVideojuego.add(new Videojuego(2, "Cyberpunk 2077", "CD Projekt", 5.6, "CD Projekt",
				"https://www.cyberpunk.net/us/es/",
				"https://compass-ssl.xbox.com/assets/f4/33/f4334b89-2ea2-4f28-a07d-1be0dc219123.jpg?n=Cyberpunk-2077_GLP-Page-Hero-0_1083x609_08.jpg"));
	}
	
	public List<Videojuego> getListVideojuego() {
		return listVideojuego;
	}

	public Videojuego getVideojuegoById(int id) {
		try {
			Videojuego v = listVideojuego.get(id);
			return v;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
