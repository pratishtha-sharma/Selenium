package com.dataDriven;

import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.Xls_Reader;

import org.openqa.selenium.WebDriver;

public class dataDrivenExcel {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") +"//src//test//java//testDataExcels//naveenAutomationTest.xlsx");
		
		//get cell data
		
		
		
		
		
}
	
	
}
	

	