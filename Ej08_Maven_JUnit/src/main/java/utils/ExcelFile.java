package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import persistence.entity.Coche;

public class ExcelFile {
	
	private static final String FILE_NAME = "src/main/resources/BBDD.xls";
	private static final String [] CAMPOS = new String[] {"id", "matricula", "marca", "modelo", "num_km"};

	public static boolean createFile(List<Coche> listado) {
		
		if(listado == null) {
			return false;
		}
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		boolean result = false;

		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < CAMPOS.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(CAMPOS[i]);
		}
		
		int rowIndex = 1;
		for (Coche c : listado) {
			Row dataRow = sheet.createRow(rowIndex++);
			
			Cell cell = dataRow.createCell(0);
			cell.setCellValue(c.getId());
			
			cell = dataRow.createCell(1);
			cell.setCellValue(c.getMatricula());
			
			cell = dataRow.createCell(2);
			cell.setCellValue(c.getMarca());
			
			cell = dataRow.createCell(3);
			cell.setCellValue(c.getModelo());
			
			cell = dataRow.createCell(4);
			cell.setCellValue(c.getKilometros());	
		}
		
		try {
			FileOutputStream outStream = new FileOutputStream(FILE_NAME);
			workbook.write(outStream);
			workbook.close();
			result = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
