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
import es.curso.model.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private Usuario u;
	
	@Autowired
	@Qualifier("carrito")
	private Carrito carrito;
	
	@Autowired
	private LoginService loginService;

	@GetMapping("login")
	public String displayLogin() {
		return "login";
	}
	
	@RequestMapping(path="checkCredentials",method=RequestMethod.POST)
	public String checkCredentials(@RequestParam("usuario") String nombre, @RequestParam("password") String pass, Model model) {

		boolean res = loginService.checkCredentials(nombre, pass);
		
		if (res) {
			u.setNombre(nombre);
			u.setPass(pass);
			carrito.setItems(new ArrayList<Videojuego>());
			return "redirect:listar_videojuegos";
		} else {
			return "redirect:login";
		}
	}
	
	@GetMapping("signup")
	public String displaySignUp() {
		return "signup";
	}
	
	@RequestMapping(path="registerUser",method=RequestMethod.POST)
	public String registerUser(@RequestParam("usuario") String nombre, @RequestParam("password") String pass, Model model) {

		Usuario newUser = new Usuario();
		newUser.setNombre(nombre);
		newUser.setPass(pass);
		boolean res = loginService.registerUser(newUser);
		
		if (res) {
			u.setNombre(nombre);
			u.setPass(pass);
			return "redirect:listar_videojuegos";
		} else {
			return "redirect:signup";
		}
	}
	
}
