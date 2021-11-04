package es.curso.model.entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Carrito {

	private ArrayList<Videojuego> items;

	public ArrayList<Videojuego> getItems() {
		return items;
	}

	public void setItems(ArrayList<Videojuego> items) {
		this.items = items;
	}
	
	public double getTotalPrice() {
		double total = 0;
		for (Videojuego v : items) {
			total += v.getPrecio();
		}
		return total;
	}
	
}
