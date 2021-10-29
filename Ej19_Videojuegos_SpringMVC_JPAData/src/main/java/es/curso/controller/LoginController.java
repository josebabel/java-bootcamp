package es.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.model.service.LoginService;

@Controller
public class LoginController {
	
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
			LoginService.setAccess(true);
			return "redirect:listar_videojuegos";
		} else {
			//model.addAttribute("error", "El usuario no esta registrado");
			return "redirect:login";
		}
	}
}
