import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExel {
	public static void main(String[] args) {
		
		try {
			FileInputStream file =new  FileInputStream (new File("howtodoinjava_demo.xlsx")  );
		
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
					switch(cell.getCellType())
					{
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "t");
						break;
						
					case Cell.CELL_TYPE_STRING:
						System.out.println(cell.getStringCellValue() + "t");
						break;
					}
				}
				System.out.print("");
			}
			
			file.close();

		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
