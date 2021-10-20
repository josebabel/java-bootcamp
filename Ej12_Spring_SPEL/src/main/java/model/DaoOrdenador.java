package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entities.Ordenador;

public class DaoOrdenador {
	
	public static final String FILE = "src/main/resources/Ordenador.txt";
	
	public static boolean createFile(Ordenador o)  {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))){
			bw.write(o.toString());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
