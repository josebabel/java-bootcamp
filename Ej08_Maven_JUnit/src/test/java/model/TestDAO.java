package model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persistence.entity.Coche;
import persistence.model.CocheModel;
import persistence.model.interfaces.DAOCoche;
import utils.ExcelFile;

public class TestDAO {
	
	DAOCoche cocheModel = new CocheModel();

	@Before
	public void modelCreateTest() {
		Coche c = new Coche();
		c.setMatricula("6785FRP");
		c.setMarca("Seat");
		c.setModelo("Leon");
		c.setKilometros(100000);
		
		//Si la matricula del coche que se va a dar de alta ya esta en la BBDD el metodo create dara error
		//pero en caso de que no exista en la BBDD devolvera true
		assertEquals(true, cocheModel.create(c));
	}
	
	@Test
	public void modelUpdateTest() {
		Coche c = new Coche();
		c.setMatricula("0000AAA");
		c.setMarca("Seat");
		c.setModelo("Leon TDI");
		c.setKilometros(197580);
		
		//Si la matricula del objeto que estamos pasando no existe no se actualizara y dara error
		assertFalse(cocheModel.update(c));
		
		//En cambio si la matricula existe actualizara todas las propiedades del registro en cuestion
		c.setMatricula("6785FRP");
		assertTrue(cocheModel.update(c));
	}
	
	@Test
	public void modelGetOneTest() {
		String matricula = "";
		
		//Si pasamos una matricula que no existe el metodo dara null
		assertNull(cocheModel.getOne(matricula));
		
		//Pero si pasamos una que existe ya no sera null
		matricula = "6785FRP";
		assertNotNull(cocheModel.getOne(matricula));
		
	}
	
	@Test
	public void modelGetAllTest() {
		
		//Si la conexion con la BBDD es correcta el metodo no dara null
		assertNotNull(cocheModel.getAll());
	}
	
	@Test
	public void modelExportToExcelTest() {
		
		//Si la conexion con la BBDD es correcta el metodo no dara null
		assertNotNull(cocheModel.exportToExcel());
	}
	
	@Test
	public void createExcelFileTest() {
		
		//Si pasamos un listado null al metodo para crear el fichero Excel este devolvera false
		assertFalse(ExcelFile.createFile(null));
		
		//En cambio si pasamos un listado con coches al metodo este creara el fichero de exportacion
		List<Coche> listado = cocheModel.getAll();
		assertTrue(ExcelFile.createFile(listado));
	}
	
	@After
	public void modelDeleteTest() {
		String matricula = "";
		
		//Si le pasamos una matricula vacia debe dar error
		assertFalse(cocheModel.delete(matricula));
		
		//Si le pasamos una matricula existente debe devolver true
		matricula = "6785FRP";
		assertTrue(cocheModel.delete(matricula));
	}

}
