package com.datadriventest;

import com.utility.Xls_Reader1;

public class ExcelOperations {
	public static void main(String[] args) {
		Xls_Reader1 reader = new Xls_Reader1("C:/Users/unit2a/Desktop/New folder/workspace/Datadriven/src/com/excel/utility/Datadriven1.xlsx");
//		To check the xl sheet added or not
		if(!reader.isSheetExist("HomePage")){
			reader.addSheet("HomePage");
	}
//		to get the colume count
int colCount=reader.getColumnCount("RegTestData");
System.out.println("Total colum present in regTestDate sheet:======"+colCount);
//to get the row count
System.out.println(reader.getCellRowNum("RegTestData", "firstname", "siva"));
}
}
