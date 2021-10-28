package es.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.model.entity.Videojuego;
import es.curso.model.service.LoginService;
import es.curso.model.service.VideojuegoService;

@Controller
public class VideojuegoController {
	
	@Autowired
	private VideojuegoService videojuegoService;

	@GetMapping("listar_videojuegos")
	public String displayVideojuegos(Model model) {
		
		if(!LoginService.isAccess()) {
			return "redirect:login";
			
		} else {
			
			List<Videojuego> listVideojuegos = videojuegoService.listVideogames();
			model.addAttribute("listado", listVideojuegos);
			
			return "listar_videojuegos";
		}
	}
	
	@RequestMapping(path="videojuego_detalle",method=RequestMethod.GET)
	public String videojuegoDetalle(@RequestParam("id") String id, Model model) {
		
		if(!LoginService.isAccess()) {
			return "redirect:login";
			
		} else {
			
			Videojuego v = videojuegoService.getVideojuegoById(id);
			
			if(v != null) {
				model.addAttribute("game", v);
				return "videojuego_detalle";
				
			} else {
				model.addAttribute("error", "No existe ese ID");
				return "redirect:listar_videojuegos";
			}
		}
	}
	
}
