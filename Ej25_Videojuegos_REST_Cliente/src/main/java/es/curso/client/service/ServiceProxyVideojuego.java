package es.curso.client.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import es.curso.client.entity.Videojuego;

@Service
public class ServiceProxyVideojuego {

	public static final String URL = "http://localhost:8080";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Videojuego> getAll() {
		try {
			ResponseEntity<Videojuego[]> response = restTemplate.getForEntity(URL + "/videojuegos", Videojuego[].class);
			Videojuego [] arrVideojuegos = response.getBody();
			return Arrays.asList(arrVideojuegos);
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Videojuego getOne(int id) {
		try {
			ResponseEntity<Videojuego> response = restTemplate.getForEntity(URL + "/videojuegos/" + id, Videojuego.class);
			return response.getBody();
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Videojuego> getByNombre(String nombre) {
		try {
			ResponseEntity<Videojuego[]> response = restTemplate.getForEntity(URL + "/videojuegos/nombre/" + nombre, Videojuego[].class);
			Videojuego [] arrVideojuegos = response.getBody();
			return Arrays.asList(arrVideojuegos);
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Videojuego> getByCompania(String compania) {
		try {
			ResponseEntity<Videojuego[]> response = restTemplate.getForEntity(URL + "/videojuegos/compania/" + compania, Videojuego[].class);
			Videojuego [] arrVideojuegos = response.getBody();
			return Arrays.asList(arrVideojuegos);
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Videojuego create(Videojuego v) {
		try {
			ResponseEntity<Videojuego> response = restTemplate.postForEntity(URL + "/videojuegos", v, Videojuego.class);
			return response.getBody();
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean update(Videojuego v) {
		try {
			restTemplate.put(URL + "/videojuegos/" + v.getId(), v, Videojuego.class);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean delete(int id) {
		try {
			restTemplate.delete(URL + "/videojuegos/" + id, Videojuego.class);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public String getPrecios() {
		try {
			return restTemplate.getForObject(URL + "/videojuegos/precios", String.class);
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
