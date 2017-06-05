package fileOperator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.nio.cs.ext.DoubleByte.Encoder_EBCDIC;

public class ExcelOperator {
	private Workbook wb = null;
	private Integer numberOfSheets = 0;
	public ExcelOperator(String fileName) {
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
			Workbook wb = WorkbookFactory.create(inputStream);
			inputStream.close();
			numberOfSheets = wb.getNumberOfSheets();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

		}
		// TODO Auto-generated constructor stub
	}
	public ArrayList<String> getParam(String sheetName) {
		ArrayList<String> paramList = new ArrayList<String>();
		XSSFSheet sheet = (XSSFSheet) wb.getSheet(sheetName);
		XSSFRow row = sheet.getRow(0);
		paramList.add(row.getCell(0).getStringCellValue());
		
		
		return paramList;
	}
	public Integer getNumberOfSheets() {
		return numberOfSheets;
	}
	public void setNumberOfSheets(Integer numberOfSheets) {
		this.numberOfSheets = numberOfSheets;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelOperator excelOperator = new ExcelOperator(".\\dat\\test case.xlsx");
		System.out.println(excelOperator.getNumberOfSheets());
		System.out.println(excelOperator.getParam("parameters").toString());
	}

}
