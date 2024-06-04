package org.driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven {

	WebDriver driver;

	@Test(priority=1,enabled=true)
	private void launch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://dev.proshop.ae/");

		driver.manage().window().maximize();

	}

	@Test(priority=2,enabled=true)
	private void sign() {

		WebElement signBtn = driver.findElement(By.xpath("//a[@id='account-btn']"));
		signBtn.click();

	}

	@Test(priority=3,enabled=true)
	private void Login() throws IOException {
		
		
		File f = new File("C:\\Users\\Balaji.p\\eclipse-workspace\\Important\\DatasStorage\\Login credentials for proshop.xlsx");
		
		FileInputStream fin = new FileInputStream(f);
		
		Workbook b = new XSSFWorkbook(fin);
		
		Sheet s = b.getSheetAt(0);
		
		Row r = s.getRow(0);
		
		Cell c0 = r.getCell(0);
		Cell c1 = r.getCell(1);
		Cell c2 = r.getCell(2);
		Cell c3 = r.getCell(3);
		
		String s0 = c0.getStringCellValue();
		String s1 = c1.getStringCellValue();
		String s2 = c2.getStringCellValue();
		String s3 = c3.getStringCellValue();
		
    
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys(s2);
		
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys(s3);
		
		WebElement logBtn = driver.findElement(By.xpath("(//span[text()='Login'])[2]"));
		logBtn.click();
			
	}

}
