package com.test.utility;

import java.util.ArrayList;

import com.utility.Xls_Reader1;

public class TestUtil {
//	step 2
	static Xls_Reader1 reader;
	public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		 try {
			reader = new Xls_Reader1("C:/Users/unit2a/Desktop/Newfolder/workspace/Datadriven/src/com/excel/utility/Datadriven1.xlsx");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 for(int rowNum=2; rowNum<= reader.getRowCount("RegTestData"); rowNum++ ){
			 String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
			 String lastName=  reader.getCellData("RegTestData", "lastname", rowNum);
			 String address1= reader.getCellData("RegTestData", "address1", rowNum);
			 String address2= reader.getCellData("RegTestData", "address2", rowNum);
			 String city= reader.getCellData("RegTestData", "city", rowNum);
			 String state= reader.getCellData("RegTestData", "state", rowNum);
			 String zipcode= reader.getCellData("RegTestData", "zipcode", rowNum);
			 String emailaddress= reader.getCellData("RegTestData", "emailaddress", rowNum);
//			 create obj array
			 Object obj[]= {firstName, lastName, address1, address2, city, state, zipcode, emailaddress};
			 myData.add(obj);

			 
		 }
		return myData;
	}
}
