package es.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.curso.entity.Videojuego;
import es.curso.service.VideojuegoService;

@RestController
public class VideojuegoController {

	@Autowired
	private VideojuegoService videojuegoService;

	@GetMapping(path = "videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> getOneVideojuego(@PathVariable("id") int id) {
		Videojuego game = videojuegoService.getOne(id);
		if(game != null) {
			return new ResponseEntity<Videojuego>(game, HttpStatus.OK);
		} else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = "videojuegos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> getAllVideojuego() {
		List<Videojuego> listadoVideojuegos = videojuegoService.getAll();
		return new ResponseEntity<List<Videojuego>>(listadoVideojuegos, HttpStatus.OK);
	}
	
	@GetMapping(path = "videojuegos/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> getVideojuegoByNombre(@PathVariable("nombre") String nombre) {
		List<Videojuego> listadoVideojuegos = videojuegoService.getByNombre(nombre);
		if(listadoVideojuegos != null) {
			return new ResponseEntity<List<Videojuego>>(listadoVideojuegos, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Videojuego>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = "videojuegos/compania/{compania}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> getVideojuegoByCompania(@PathVariable("compania") String compania) {
		List<Videojuego> listadoVideojuegos = videojuegoService.getByCompania(compania);
		if(listadoVideojuegos != null) {
			return new ResponseEntity<List<Videojuego>>(listadoVideojuegos, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Videojuego>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = "videojuegos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> createVideojuego(@RequestBody Videojuego v) {
		videojuegoService.create(v);
		return new ResponseEntity<Videojuego>(v, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "videojuegos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> editVideojuego(@PathVariable("id") int id, @RequestBody Videojuego v) {
		Videojuego game = videojuegoService.update(id, v);
		if(game != null) {
			return new ResponseEntity<Videojuego>(game, HttpStatus.OK);
		} else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path = "videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteVideojuego(@PathVariable("id") int id) {
		boolean res = videojuegoService.delete(id);
		if(res) {
			return new ResponseEntity<String>("Videojuego con ID " + id + " eliminado", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No existe ese ID", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = "videojuegos/precios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> precios() {
		String precios = videojuegoService.precios();
		return new ResponseEntity<String>(precios, HttpStatus.OK);
	}
}
