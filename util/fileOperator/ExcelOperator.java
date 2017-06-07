package fileOperator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.nio.cs.ext.DoubleByte.Encoder_EBCDIC;

public class ExcelOperator {
	private POIFSFileSystem fs;
    private XSSFWorkbook wb;
	private Integer numberOfSheets = 0;
	
	public ExcelOperator(String fileName) {
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
//			fs = new POIFSFileSystem(inputStream);
	        wb = new XSSFWorkbook(inputStream);
//			inputStream.close();
			numberOfSheets = wb.getNumberOfSheets();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param sheetName 参数所在sheet表名
	 * @param strKey 想要获取的参数名
	 * @return
	 * @throws Exception 如果获取不到指定参数，则抛出异常
	 */
	public ArrayList<String> getParam(String sheetName,String strKey) throws Exception {
		ArrayList<String> paramList = new ArrayList<String>();
	    XSSFSheet sheet = wb.getSheet(sheetName);
	    XSSFRow row = null;
	    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row.getCell(0).getStringCellValue().equals(strKey)) {
				for (int j = 1; j < row.getPhysicalNumberOfCells(); j++) {
					paramList.add(row.getCell(j).getStringCellValue());
				}
				return paramList;
			}
		}
		
	    
//		System.out.println(sheet.getPhysicalNumberOfRows());
//		paramList.add(row.getCell(0).getStringCellValue());
//		System.out.println(paramList.toString());
	    Exception exception = new Exception("没有找到指定的key");
		throw exception;
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
		try {
			System.out.println(excelOperator.getParam("parameters","prefer"));
			System.out.println(excelOperator.getParam("parameters","poolname"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
