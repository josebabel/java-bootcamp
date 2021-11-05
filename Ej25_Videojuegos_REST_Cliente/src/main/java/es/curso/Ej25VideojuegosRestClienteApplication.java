package es.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import es.curso.client.entity.Videojuego;
import es.curso.client.service.ServiceProxyVideojuego;

@SpringBootApplication
public class Ej25VideojuegosRestClienteApplication implements CommandLineRunner{

	
	@Autowired
	private ServiceProxyVideojuego proxyVideojuego;
	
	@Autowired
	private ApplicationContext context;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Ej25VideojuegosRestClienteApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		//LISTAR TODOS
		List<Videojuego> list = proxyVideojuego.getAll();
		list.forEach((x) -> System.out.println(x));

		//LISTAR UNO POR ID
		Videojuego v = proxyVideojuego.getOne(3);
		System.out.println("\n" + v);
		
		//LISTAR POR NOMBRE
		List<Videojuego> listNom = proxyVideojuego.getByNombre("Battlefield 2042");
		if(listNom != null) {
			System.out.println();
			listNom.forEach((x) -> System.out.println(x));
		}
		
		//LISTAR POR COMPANIA
		List<Videojuego> listCom = proxyVideojuego.getByCompania("EA");
		if(listCom != null) {
			System.out.println();
			listCom.forEach((x) -> System.out.println(x));
		}
		
		//CREAR VIDEOJUEGO
		Videojuego game = new Videojuego();
		game.setNombre("Super Smash Bros");
		game.setCompania("Nintendo");
		game.setCreador("Bandai Namco");
		game.setNota(9);
		game.setPrecio(50);
		Videojuego gameX = proxyVideojuego.create(game);
		System.out.println("\n" + gameX);
		
		//MODIFICAR VIDEOJUEGO
		Videojuego gameM = new Videojuego();
		gameM.setId(10);
		gameM.setNombre("Super Smash Bros");
		gameM.setCompania("Nintendo");
		gameM.setCreador("Bandai Namco Studios");
		gameM.setNota(9);
		gameM.setPrecio(50);
		boolean update = proxyVideojuego.update(gameM);
		System.out.println(update);
		
		//BORRAR VIDEOJUEGO
		boolean delete = proxyVideojuego.delete(10);
		System.out.println(delete);
		
		//LISTAR PRECIOS
		String precios = proxyVideojuego.getPrecios();
		System.out.println(precios);
		
		pararAplicacion();
	}
	
	public void pararAplicacion() {
		SpringApplication.exit(context, () -> 0);
	}



}
