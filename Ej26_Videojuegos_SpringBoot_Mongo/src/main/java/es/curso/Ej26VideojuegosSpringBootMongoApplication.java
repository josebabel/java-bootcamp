package es.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.curso.model.entity.Videojuego;
import es.curso.model.repository.VideojuegoRepositoryMongo;

@SpringBootApplication
public class Ej26VideojuegosSpringBootMongoApplication implements CommandLineRunner{

	@Autowired
	private VideojuegoRepositoryMongo mongo;
	
	public static void main(String[] args) {
		SpringApplication.run(Ej26VideojuegosSpringBootMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Videojuego> list = mongo.findAll();
		list.forEach((x) -> System.out.println(x));
		
	}

}
