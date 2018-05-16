package com.datadriventest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.utility.Xls_Reader1;

public class ParamiterizeTest {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		System.setProperty("webdriver.chrome.driver","E:\\anto\\seleniumchrom\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterinfo");
		Thread.sleep(2000);
//		get the data from excel:
		Xls_Reader1 reader = new Xls_Reader1("C:/Users/unit2a/Desktop/Newfolder/workspace/Datadriven/src/com/excel/utility/Datadriven1.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		
		reader.addColumn("RegTestData", "Status");

		for(int rowNum = 2; rowNum<= rowCount; rowNum++){
			System.out.println("=========");
			String firstName=reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstName);
			
			String lastName=reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastName);
			
			String address1=reader.getCellData("RegTestData", "address1", rowNum);
			System.out.println(address1);
			
			String address2=reader.getCellData("RegTestData", "address2", rowNum);
			System.out.println(address2);
			
			String city=reader.getCellData("RegTestData", "city",rowNum);
			System.out.println(city);
			
			String state=reader.getCellData("RegTestData", "state",rowNum);
			System.out.println(state);
			
			String zipcode=reader.getCellData("RegTestData", "zipcode", rowNum);
			System.out.println(zipcode);
			
			String emailaddress=reader.getCellData("RegTestData", "emailaddress", rowNum);
			System.out.println(emailaddress);
			
			driver.findElement(By.xpath("//*[@id='firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstName);
			
			driver.findElement(By.xpath("//*[@id='firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastName);
			
			driver.findElement(By.xpath("//*[@id='firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);
			
			driver.findElement(By.xpath("//*[@id='firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);
			
			driver.findElement(By.xpath("//*[@id='firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);
			
			Select select = new Select(driver.findElement(By.xpath("//*[@id='state']")));
			select.selectByVisibleText(state);
			driver.findElement(By.xpath("//*[@id='firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipcode);
			
			driver.findElement(By.xpath("//*[@id='firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailaddress);
			
			driver.findElement(By.xpath("//*[@id='firstname']")).clear();
			driver.findElement(By.xpath("//*[@id='retype_email']")).sendKeys(emailaddress);
			
			reader.setCellData("RegTestData", "Status", rowNum, "Pass");
		}
		driver.quit();
	}
}
