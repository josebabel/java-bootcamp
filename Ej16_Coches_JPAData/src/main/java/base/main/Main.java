package base.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import base.cfg.ConfigJPA;
import base.model.entity.Coche;
import base.model.persistence.CocheJPAData;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigJPA.class); 
		
		CocheJPAData cocheJPAData = context.getBean("cocheJPAData", CocheJPAData.class);
		
		List<Coche> list =  cocheJPAData.findAll();
		System.out.println(list);
		
		Coche c = cocheJPAData.findById(1);
		System.out.println(c);
	}

}
