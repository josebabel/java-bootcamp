package es.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.model.entity.Usuario;
import es.curso.model.entity.Videojuego;
import es.curso.model.service.VideojuegoService;

@Controller
public class VideojuegoController {

	@Autowired
	private Usuario u;

	@Autowired
	private VideojuegoService videojuegoService;

	@GetMapping("listar_videojuegos")
	public String displayVideojuegos(Model model) {
		if (u.getNombre() != null) {
			List<Videojuego> listado = videojuegoService.listarTodos();

			model.addAttribute("listado", listado);
			model.addAttribute("user", u);
			return "listar_videojuegos";
		}
		return "redirect:login";
	}

	@RequestMapping(path = "videojuego_detalle", method = RequestMethod.GET)
	public String videojuegoDetalle(@RequestParam("id") String id, Model model) {
		if (u.getNombre() != null) {

			Videojuego v = videojuegoService.listarUno(Integer.parseInt(id));

			if (v != null) {
				model.addAttribute("juego", v);
				return "videojuego_detalle";
			} else {
				return "redirect:listar_videojuegos";
			}
		}
		return "redirect:login";
	}

	@GetMapping("add_videojuego")
	public String addVideojuego(Model model) {
		if (u.getNombre() != null) {

			return "add_videojuego";
		}
		return "redirect:login";
	}

	@RequestMapping(path = "add_videojuego_gestor", method = RequestMethod.POST)
	public String videojuegoDetalle(@RequestParam(required = false) String id, @RequestParam("nombre") String nombre,
			@RequestParam("compania") String compania, @RequestParam("creador") String creador,
			@RequestParam("nota") double nota, @RequestParam("precio") double precio, @RequestParam("foto") String foto,
			@RequestParam("enlace") String enlace, Model model) {
		if (u.getNombre() != null) {

			Videojuego v = new Videojuego();
			
			if(id != null) {
				v.setId(Integer.parseInt(id));
			}
			v.setNombre(nombre);
			v.setCompania(compania);
			v.setCreador(creador);
			v.setNota(nota);
			v.setPrecio(precio);
			v.setFoto(foto);
			v.setEnlace(enlace);

			boolean res = videojuegoService.crear(v);
			return (res) ? "redirect:listar_videojuegos" : "redirect:add_videojuego";
		}
		return "redirect:login";
	}

	@RequestMapping(path = "edit_videojuego", method = RequestMethod.GET)
	public String editVideojuego(@RequestParam("id") String id, Model model) {
		if (u.getNombre() != null) {

			Videojuego v = videojuegoService.listarUno(Integer.parseInt(id));

			if (v != null) {
				model.addAttribute("juego", v);
				return "edit_videojuego";
			} else {
				return "redirect:listar_videojuegos";
			}
		}
		return "redirect:login";
	}
	
	@RequestMapping(path = "delete_videojuego", method = RequestMethod.GET)
	public String deleteVideojuego(@RequestParam("id") String id, Model model) {
		if (u.getNombre() != null) {
			videojuegoService.eliminar(Integer.parseInt(id));
			return "redirect:listar_videojuegos";
		}
		return "redirect:login";
	}

}
