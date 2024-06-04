package org.driven;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation {

	
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
	
	
	@Test(priority=3,enabled=false)
	private void withoutRule() {
    
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("Balaji.psysfore.com ");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys("Balaji@123");
		
		String emailId = userName.getAttribute("value");
		
		WebElement logBtn = driver.findElement(By.xpath("(//span[text()='Login'])[2]"));
		logBtn.click();
		
		
		
		if (!emailId.contains("@")|!emailId.contains(".com")) {
			
			WebElement errmsg = driver.findElement(By.xpath("//div[@id='email-error']"));
		
			if (errmsg.isDisplayed()) {
				
				System.out.println("error msg showing properly");
				System.out.println(errmsg.getText());
				
			} else {

				System.out.println("error msg is not showing");
			}
			
		} else {

			System.out.println("user entered the emaild is with @ and .com");
			
		}
		
	}
	
	
	
	
	@Test(priority=3,enabled=true)
	private void credentialsValidations() {
     
		
		
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com ");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys("Bala@123");
		
		String emailId = userName.getAttribute("value");
		
		WebElement logBtn = driver.findElement(By.xpath("(//span[text()='Login'])[2]"));
		logBtn.click();
	
		
		
		try {
			

			WebElement errmsg = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. ')]"));
			
			if (errmsg.isDisplayed()) {
				
	         System.out.println("error msg showing properly");		
	         
	         String expect ="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. ";
	         
	         String actual = errmsg.getText();
	         
	         
	         
	         if (actual.equals(expect)) {
				
	        	 System.out.println("expected and actual msg both are same"+actual+":"+expect);
	        	 Reporter.log("expected and actual msg both are same"+actual+":"+expect);
	        	 
			} else {

				System.out.println("expected and actual msg both are different"+actual+":"+expect);
				Reporter.log("expected and actual msg both are different"+actual+":"+expect);
			}
	         
	         
	         
	         
			} else {

				System.out.println("error msg not getting properly");
				Reporter.log("error msg not getting properly");
			}
			
			
		
			
			
		} catch (NoSuchElementException e) {
			
			System.out.println("NoSuchElementException");
			
		}
		
		
		
	}
		

	@Test
	private void withoutEmpty() {
    
		

		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com ");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys("Bala@123");
		
		String emailId = userName.getAttribute("value");
		
		WebElement logBtn = driver.findElement(By.xpath("(//span[text()='Login'])[2]"));
		logBtn.click();
		
		if (emailId.isEmpty()) {
			
			System.out.println("username field is empty");
			
			WebElement emailErrMsg = driver.findElement(By.xpath("(//div[text()='This is a required field.'])[1]"));
			
			WebElement passErrMsg = driver.findElement(By.xpath("(//div[text()='This is a required field.'])[2]"));
			
			
			if (emailErrMsg.isDisplayed()) {
				
				System.out.println("please enter your user name");
				System.out.println(emailErrMsg);
				
			} else if (passErrMsg.isDisplayed()) {
				
			} else {

			}			
			
		} else {

			
			
		}
		
		
		
		
		
	}
	
	
	
	@Test(priority=4,enabled=true)
	private void end() {
    
		
		
		driver.quit();
		
	}
	
	
	
	
	
	
	
}
