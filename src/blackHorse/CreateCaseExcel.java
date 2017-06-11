package blackHorse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fileOperator.ExcelOperator;
import math.Combination;

public class CreateCaseExcel {
	
	
	private ArrayList<String> paramList = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelOperator excelOperator = new ExcelOperator(".\\dat\\test case.xlsx");
		try {
			System.out.println(excelOperator.getParam("parameters","prefer"));
			ArrayList<String> list = excelOperator.getParam("parameters","prefer");
			String chs[] = new String[list.size()];
			List<String> result = new ArrayList<>(); 
			result = Combination.combination(excelOperator.getParam("parameters","prefer").toArray(chs));
			for (String string : result) {
				string = (String) string.subSequence(1, string.length()-1);
				System.out.println(string);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
