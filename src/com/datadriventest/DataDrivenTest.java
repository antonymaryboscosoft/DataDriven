package com.datadriventest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.utility.Xls_Reader1;

public class DataDrivenTest {
	public static void main(String[] args) throws InterruptedException {

		Xls_Reader1 reader = new Xls_Reader1("C:/Users/unit2a/Desktop/Newfolder/workspace/Datadriven/src/com/excel/utility/Datadriven1.xlsx");
		
		String firstName=reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstName);
		
		String lastName=reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastName);
		
		String address1=reader.getCellData("RegTestData", "address1", 2);
		System.out.println(address1);
		
		String address2=reader.getCellData("RegTestData", "address2", 2);
		System.out.println(address2);
		
		String city=reader.getCellData("RegTestData", "city", 2);
		System.out.println(city);
		
		String state=reader.getCellData("RegTestData", "state", 2);
		System.out.println(state);
		
		String zipcode=reader.getCellData("RegTestData", "zipcode", 2);
		System.out.println(zipcode);
		
		String emailaddress=reader.getCellData("RegTestData", "emailaddress", 2);
		System.out.println(emailaddress);
		
		
		System.setProperty("webdriver.chrome.driver","E:\\anto\\seleniumchrom\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterinfo");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);
		driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);
		driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);
		Select select = new Select(driver.findElement(By.xpath("//*[@id='state']")));
		select.selectByVisibleText(state);
		driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipcode);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailaddress);
		driver.findElement(By.xpath("//*[@id='retype_email']")).sendKeys(emailaddress);
	}
}
