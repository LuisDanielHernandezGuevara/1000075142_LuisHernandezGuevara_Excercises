import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.record.cf.PatternFormatting;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormulaExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Calculate Simple Interst");
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Principal");
		header.createCell(1).setCellValue("RoI");
		header.createCell(2).setCellValue("T");
		header.createCell(3).setCellValue("Interest (P r t)");
		
		Row dataRow = sheet.createRow(1);
		dataRow.createCell(0).setCellValue(14500d);
		dataRow.createCell(1).setCellValue(9.25);
		dataRow.createCell(2).setCellValue(3d);
		dataRow.createCell(3).setCellValue("A2*B2*C2");
		readSheetWithFormula();
		try{
			FileOutputStream out = new FileOutputStream(new File("formulaDemo.xlsx"));
			workbook.write(out);
			out.close();
			System.out.print("Excel with formula cells written successfully");
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	
	}
	
	public static void readSheetWithFormula() {
		try {
			FileInputStream file = new FileInputStream(new File("formulaDemo.xlsx"));
			//Create workbook instance olding refrence to .xlsx file
			XSSFWorkbook  workbook2= new XSSFWorkbook(file);
			
			FormulaEvaluator evaluator = workbook2.getCreationHelper().createFormulaEvaluator();
			
			//Create workbook instne holding refrence to .xlsx file

			XSSFSheet sheet = workbook2.getSheetAt(0);
			
			Iterator <Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch(evaluator.evaluateInCell(cell).getCellType())
					{
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "tt");
						break;
					
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getRichStringCellValue() + "tt");
					
					case Cell.CELL_TYPE_FORMULA:
						break;
					}
				}
				
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void basedOnValue(Sheet sheet) {
		sheet.createRow(0).createCell(0).setCellValue(84);
		sheet.createRow(1).createCell(1).setCellValue(74);
		sheet.createRow(2).createCell(2).setCellValue(50);
		sheet.createRow(3).createCell(3).setCellValue(51);
		sheet.createRow(4).createCell(4).setCellValue(49);
		sheet.createRow(5).createCell(5).setCellValue(41);
		
		
		SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
	
	
		//Condtion 1 : Cell value is greater 
		ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule();
		PatternFormatting fill1 = rule1.createPatternFormatting();
		fill1.setFillBackgroundColor(IndexedColors.BLUE.index);
		fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
		
		
		//Condition 2 : Cell value is less than 50
		ConditionalFormattingRule rule2 = sheetCF.createConditionalFormattingRule(arg0);
		PatternFormatting fill2 = rule2.createPatternFormatting();
		fill2.setFillBackgroundColor(IndexedColors.GREEN.index);
		fill2.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
		
		CellRangeAddress[] regions = {
				CellRangeAddress.valueOf("A1:A6");
		}
	
	};
	
	
}
