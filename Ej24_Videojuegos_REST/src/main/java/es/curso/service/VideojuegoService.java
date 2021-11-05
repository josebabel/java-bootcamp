package es.curso.service;

import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.entity.Videojuego;
import es.curso.repository.VideojuegoRepositoryJPAData;

@Service
public class VideojuegoService {
	
	@Autowired
	private VideojuegoRepositoryJPAData videojuegoRepositoryJPAData;
	
	/**
	 * 
	 * @param id El id que usaremos para encontrar el videojuego
	 * @return <b>Videojuego</b> encontrado, si no encuentra ninguno devolvera null
	 */
	public Videojuego getOne(int id) {
		return videojuegoRepositoryJPAData.findById(id).orElse(null);
	}
	
	/**
	 *  
	 * @return <b>List Videojuego</b> Listado con todos los videjuegos
	 */
	public List<Videojuego> getAll() {
		return videojuegoRepositoryJPAData.findAll();
	}
	
	/**
	 * 
	 * @param nombre del videojuego a encontrar
	 * @return <b>List Videojuego</b> si encuentra resultados, si no delvuelve null
	 */
	public List<Videojuego> getByNombre(String nombre) {
		List<Videojuego> listado = videojuegoRepositoryJPAData.findByNombre(nombre);
		if(listado.size() > 0) {
			return listado;
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param compania del videojuego a encontrar
	 * @return <b>List Videojuego</b> si encuentra resultados, si no delvuelve null
	 */
	public List<Videojuego> getByCompania(String compania) {
		List<Videojuego> listado = videojuegoRepositoryJPAData.findByCompania(compania);
		if(listado.size() > 0) {
			return listado;
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param v El videojuego que vayamos a crear
	 * @return <b>Videojuego</b> creado
	 */
	@Transactional
	public Videojuego create(Videojuego v) {
		return videojuegoRepositoryJPAData.save(v);
	}
	
	/**
	 * 
	 * @param id El id del videojuego a actualizar
	 * @param v El body del videojuego a actualizar
	 * @return <b>Videojuego</b> actualizado, si no el id no coincide se devuelve null
	 */
	@Transactional
	public Videojuego update(int id, Videojuego v) {
		Videojuego game = videojuegoRepositoryJPAData.findById(id).orElse(null);
		if(game != null) {
			v.setId(id);
			return videojuegoRepositoryJPAData.save(v);
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param id El id del videojuego que se vaya a eliminar
	 * @return <b>boolean</b> True si existe el videojuego, false si no existe el videojuego
	 */
	@Transactional
	public boolean delete(int id) {
		Videojuego game = videojuegoRepositoryJPAData.findById(id).orElse(null);
		if(game != null) {
			videojuegoRepositoryJPAData.delete(game);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return <b>String</b> con los precios de los videojuegos en una estructura JSON 
	 */
	public String getPrecios() {
		JSONObject json = new JSONObject();
		List<Videojuego> listado = videojuegoRepositoryJPAData.findAll();
		JSONArray arrGames = new JSONArray();	
		double total = 0;
		
		for (Videojuego v : listado) {
			JSONObject sub = new JSONObject();
			sub.put("nombre", v.getNombre());
			sub.put("precio", v.getPrecio());
			arrGames.put(sub);
			
			total += v.getPrecio();
		}
		json.put("videojuegos", arrGames);
		json.put("total", total);
		
		return json.toString();
	}

}
