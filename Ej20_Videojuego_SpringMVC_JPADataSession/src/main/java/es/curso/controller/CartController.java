package es.curso.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.model.entity.Carrito;
import es.curso.model.entity.Usuario;
import es.curso.model.entity.Videojuego;
import es.curso.model.service.VideojuegoService;

@Controller
public class CartController {
	
	@Autowired
	private Usuario u;
	
	@Autowired
	private VideojuegoService videojuegoService;
	
	@Autowired
	@Qualifier("carrito")
	private Carrito carrito;

	@GetMapping("cart")
	public String displayCart(Model model) {
		if (u.getNombre() != null) {
			model.addAttribute("carrito", carrito.getItems());
			model.addAttribute("total", carrito.getTotalPrice());
			return "cart";
		}
		return "redirect:login";
	}
	
	@RequestMapping(path = "cart/add", method = RequestMethod.GET)
	public String addItemToCart(@RequestParam("id") String id) {
		if (u.getNombre() != null) {
			Videojuego v = videojuegoService.listarUno(Integer.parseInt(id));
			carrito.getItems().add(v);
			return "redirect:/mvc/cart";
		}
		return "redirect:login";
	}
	
	@GetMapping("cart/checkout")
	public String checkout(Model model) {
		if (u.getNombre() != null) {
			carrito.getItems().clear();
			return "redirect:/mvc/cart";
		}
		return "redirect:login";
	}
	
}
