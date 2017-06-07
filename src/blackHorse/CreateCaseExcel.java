package blackHorse;

import java.util.ArrayList;

import fileOperator.ExcelOperator;
import math.Combination;

public class CreateCaseExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelOperator excelOperator = new ExcelOperator(".\\dat\\test case.xlsx");
		try {
			System.out.println(excelOperator.getParam("parameters","prefer"));
			ArrayList<String> list = excelOperator.getParam("parameters","prefer");
			String chs[] = new String[list.size()];
			Combination.combination(excelOperator.getParam("parameters","prefer").toArray(chs));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
