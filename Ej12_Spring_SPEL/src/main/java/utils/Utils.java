package utils;

import entities.Marcas;
import entities.TipoPeriferico;

public class Utils {

	public static double generateRandomNumber(int min, int max) {
		return (Math.floor(Math.random() * ((max - min) + 1)) + min);
	}
	
	public static String randomBrand() {
		int random = (int)generateRandomNumber(0, Marcas.values().length - 1);
		Marcas marca = Marcas.values()[random];
		return marca.toString();	
	}
}
