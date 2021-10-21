package base.utils;

import org.springframework.stereotype.Component;

import base.model.entity.Marcas;

@Component
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
