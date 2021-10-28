package es.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.model.entity.Usuario;
import es.curso.model.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private Usuario usuario;

	@GetMapping("login")
	public String displayLogin() {
		return "login";
	}

	@RequestMapping(path="checkCredentials",method=RequestMethod.POST)
	public String doLogin(@RequestParam("usuario") String nombre, @RequestParam("password") String pass, Model model) {

		usuario.setNombre(nombre);
		usuario.setPass(pass);
		
		boolean res = loginService.checkCreadentials(usuario);

		if (res) {
			LoginService.setAccess(true);
			return "redirect:listar_videojuegos";
		} else {
			//model.addAttribute("error", "El usuario no esta registrado");
			return "redirect:login";
		}
	}

}
