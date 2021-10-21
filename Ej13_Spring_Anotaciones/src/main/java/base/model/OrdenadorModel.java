package base.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Repository;

import base.model.entity.Ordenador;
import base.model.interfaces.OrdenadorDAO;

@Repository
public class OrdenadorModel implements OrdenadorDAO{

	private static final String FILE = "src/main/resources/Ordenador.txt";
	
	@Override
	public boolean createFile(Ordenador o) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))){
			bw.write(o.toString());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}		
	}
}
