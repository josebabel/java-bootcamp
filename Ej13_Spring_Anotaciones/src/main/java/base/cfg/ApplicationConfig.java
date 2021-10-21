package base.cfg;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import base.model.entity.Grafica;
import base.model.entity.Periferico;
import base.model.entity.Ram;
import base.model.entity.TipoPeriferico;

@Configuration
public class ApplicationConfig {

	// RAM
	@Bean
	public Ram r1() {
		Ram r1 = new Ram();
		r1.setHz(3200);
		r1.setGeneracion("DDR4");
		return r1;
	}

	@Bean
	public Ram r2() {
		Ram r2 = new Ram();
		r2.setHz(3200);
		r2.setGeneracion("DDR4");
		return r2;
	}

	@Bean
	public ArrayList<Ram> listaRam(@Qualifier("r1") Ram r1, @Qualifier("r2") Ram r2) {
		ArrayList<Ram> listaRam = new ArrayList<Ram>();
		listaRam.add(r1);
		listaRam.add(r2);
		return listaRam;
	}

	// GRAFICA
	@Bean
	public Ram ramGrafica() {
		Ram ramGrafica = new Ram();
		ramGrafica.setHz(1770);
		ramGrafica.setGeneracion("GDDR6");
		return ramGrafica;
	}

	@Bean
	public Grafica grafica(@Qualifier("ramGrafica") Ram ramGrafica) {
		Grafica grafica = new Grafica();
		grafica.setHz(1770);
		grafica.setModelo("RTX");
		grafica.setRamGrafica(ramGrafica);
		return grafica;
	}

	@Bean
	public ArrayList<Grafica> listGraficas(@Qualifier("grafica") Grafica grafica) {
		ArrayList<Grafica> listGraficas = new ArrayList<Grafica>();
		listGraficas.add(grafica);
		return listGraficas;
	}

	// PERIFERICOS
	@Bean
	public Periferico p1() {
		Periferico p1 = new Periferico();
		p1.setTipo(TipoPeriferico.MONITOR);
		return p1;
	}

	@Bean
	public Periferico p2() {
		Periferico p2 = new Periferico();
		p2.setTipo(TipoPeriferico.TECLADO);
		return p2;
	}

	@Bean
	public Periferico p3() {
		Periferico p3 = new Periferico();
		p3.setTipo(TipoPeriferico.RATON);
		return p3;
	}

	@Bean
	public Periferico p4() {
		Periferico p4 = new Periferico();
		p4.setTipo(TipoPeriferico.CASCOS);
		return p4;
	}

	@Bean
	public ArrayList<Periferico> listPerifericos(@Qualifier("p1") Periferico p1, @Qualifier("p2") Periferico p2,
			@Qualifier("p3") Periferico p3, @Qualifier("p4") Periferico p4) {
		ArrayList<Periferico> listPerifericos = new ArrayList<Periferico>();
		listPerifericos.add(p1);
		listPerifericos.add(p2);
		listPerifericos.add(p3);
		listPerifericos.add(p4);
		return listPerifericos;
	}

}
