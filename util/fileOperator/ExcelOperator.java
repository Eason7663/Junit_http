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
	
	public ExcelOperator(String fileName) {
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
//			fs = new POIFSFileSystem(inputStream);
	        wb = new XSSFWorkbook(inputStream);
			inputStream.close();		
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
	 * @param sheetName ��������sheet����
	 * @param strKey ��Ҫ��ȡ�Ĳ�����
	 * @return
	 * @throws Exception �����ȡ����ָ�����������׳��쳣
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
	    
	    Exception exception = new Exception("û���ҵ�ָ����key");
		throw exception;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelOperator excelOperator = new ExcelOperator(".\\dat\\test case.xlsx");
		try {
			System.out.println(excelOperator.getParam("parameters","prefer"));
			System.out.println(excelOperator.getParam("parameters","poolname"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
