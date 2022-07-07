import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;

public class DuplicatedExcelValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	static void formatDuplicates (Sheet sheet) {
		sheet.createRow(0).createCell(0).setCellValue("Code");
		sheet.createRow(1).createCell(0).setCellValue(4);
		sheet.createRow(2).createCell(0).setCellValue(3);
		sheet.createRow(3).createCell(0).setCellValue(6);
		sheet.createRow(4).createCell(0).setCellValue(3);
		sheet.createRow(5).createCell(0).setCellValue(5);
		sheet.createRow(6).createCell(0).setCellValue(8);
		sheet.createRow(7).createCell(0).setCellValue(0);
		sheet.createRow(8).createCell(0).setCellValue(2);
		sheet.createRow(9).createCell(0).setCellValue(8);
	
		SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
		
		ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule("COUNTIF($A$2:$A$A11,A2)>1");
		FontFormatting font = rule1.createFontFormatting();
		font.setFontStyle(false, true);
		font.setFontColorIndex(IndexedColors.BLUE.index);
		
		CellRangeAddress[] regions = {
				(CellRangeAddress) CellRangeAddress.valueOf("A2:A11")
				
		};
		
		sheetCF.addConditionalFormatting(regions,rule1);
		
		sheet.getRow(2).createCell(1).setCellValue("<== Duplicates numbers in the column are highlighted.   "
		+ "Condition: Formulais =COUNTIF($A$2:$A$11,A2)>1  BLUE FONT");
		
		
	}
	
	static void shateAlt(Sheet sheet) {
		
		SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
		
		//Condition 1: Formula Is =A2=A1 (White font)
		ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule("MOD(ROW(),2");
		PatternFormatting fill1 = rule1.createPatternFormatting();
	fill1.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.index);
	fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
	
	CellRangeAddress[] regions = {
			(CellRangeAddress) CellRangeAddress.valueOf("A1:Z100")
	};
	sheetCF.addConditionalFormatting(regions,rule1);
	
	sheet.createRow(0).createCell(1).setCellValue("Shade Alternating Rows IS =MOD(ROW(),2)  (Light Green Fill)");
	sheet.createRow(1).createCell(1).setCellValue("Condition:Formula");
	}

	static void expiryInNext30Days(Sheet sheet)
	{
		CellStyle style = sheet.getWorkbook().createCellStyle();
		style.setDataFormat((short)BuiltinFormats.getBuiltinFormat("d-mmm"));
		
		sheet.createRow(0).createCell(0).setCellValue("Date");
		sheet.createRow(1).createCell(0).setCellFormula("TODAY()+29");
		sheet.createRow(2).createCell(0).setCellValue("A2+1");
		sheet.createRow(3).createCell(0).setCellValue("A3+1");
		
		
		
		for(int rownum = 1 ; rownum<=3; rownum++) sheet.getRow(rownum).getCell(0).setCellStyle(style);
		ConditionalFormatting sheetCF = (ConditionalFormatting) sheet.getSheetConditionalFormatting();
		
		//Condition 1: Formula Is =A2=A1 (White Font)
		ConditionalFormattingRule rule1 = ((SheetConditionalFormatting) sheetCF).createConditionalFormattingRule("AND(A2-TODAY()>=0,A2-TODAY()<=30)");
		FontFormatting font = rule1.createFontFormatting();
		font.setFontStyle(false, true);
		font.setFontColorIndex(IndexedColors.BLUE.index);
		
		
		CellRangeAddress[] regions = {
				(CellRangeAddress) CellRangeAddress.valueOf("A2:A4")
		};
		
		((SheetConditionalFormatting) sheetCF).addConditionalFormatting(regions,rule1);
		
		sheet.getRow(0).createCell(1).setCellValue("Dates within the next 30 days are highligh");
		
		
	
	}
}
