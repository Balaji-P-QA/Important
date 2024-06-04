package org.driven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccount {

	WebDriver driver;
	WebElement qtyMsg;
	JavascriptExecutor js;
	String oldPassword;


	@Test(priority=1,enabled=true)
	private void launch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://dev.proshop.ae/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Test(priority=2,enabled=true)
	private void sign() {

		WebElement signBtn = driver.findElement(By.xpath("//a[@id='account-btn']"));
		signBtn.click();

	}
	
	@Test(priority=3,enabled=true)
	private void withoutRule() {
		
	     oldPassword="Balaji@1234";
    
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com ");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys(oldPassword);
				
		WebElement logBtn = driver.findElement(By.xpath("(//span[text()='Login'])[2]"));
		logBtn.click();
		
		WebElement signBtn = driver.findElement(By.xpath("//a[@id='account-btn']"));
		signBtn.click();

	}
	
	
	
	@Test(priority=4,enabled=true,dependsOnMethods = {"storeCredit"})
	private void myOrders() throws InterruptedException {
    
		
		WebElement ordersSection = driver.findElement(By.xpath("(//a[text()='My Orders'])[1]"));
		ordersSection.click();
		
		WebElement viewOrder = driver.findElement(By.xpath("(//a[@class='action view'])[1]"));
		viewOrder.click();
		
		//String productName = driver.findElement(By.xpath("//strong[text()='205/55R16 91V ZE914 _ Falken']")).getText();
		
		WebElement reOrder = driver.findElement(By.xpath("//span[text()='Reorder']"));
		reOrder.click();
		
		
		
		String currentTitle = driver.getTitle();
		
		
		if (currentTitle.equals("Shopping Cart")) {
			
		       System.out.println("redirected to cart page");
		       
		       WebElement scrdown = driver.findElement(By.xpath("//div[@class='bottom-note']"));
		       js = (JavascriptExecutor)driver;
		       js.executeScript("arguments[0].scrollIntoView(true)",scrdown);
		   	
		       Thread.sleep(3000);
		       
			   String productName="195/65R15 91H EC300+ | Dunlop";
			   
			   String cartProductCheck = driver.findElement(By.xpath("//a[text()='195/65R15 91H EC300+ | Dunlop']")).getText();
			   
			   
			   
			   if (cartProductCheck.equals(productName)) {
				
				   System.out.println("expect product is reorder successfully");
				   
				   //205/55R16 91V ZE914 _ Falken    205/55R16 91V ZE914 _ Falken
				   
			} else {
                   
				System.out.println("expect product not reorder successfully");
				
			}
			   
		
			   
			   
		} else {
			
			System.out.println("if we click the reorder, the page is not redirecting to cart page");

		}
		
	}
	
	
	
	
	
	@Test(priority= 5,enabled=true)
	private void addressBook() throws InterruptedException {
    
		
		WebElement addressBook = driver.findElement(By.xpath("//a[text()='Address Book']"));
		addressBook.click();
		
		WebElement addNewAddress = driver.findElement(By.xpath("//span[text()='Add New Address']"));
		addNewAddress.click();
		
		Thread.sleep(13000);
		
		WebElement NamePrefix = driver.findElement(By.xpath("//select[@name='name_prefix']"));
		
		Select s = new Select(NamePrefix);
		s.selectByIndex(1);
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		firstName.clear();
		firstName.sendKeys("BalaG");
		
		WebElement phone = driver.findElement(By.xpath("//input[@id='telephone']"));
		phone.sendKeys("987654321");
		
		WebElement streetAddress1 = driver.findElement(By.xpath("//input[@id='street_1']"));
		streetAddress1.sendKeys("ABC Nagar");
		
		WebElement streetAddress2 = driver.findElement(By.xpath("//input[@id='street_2']"));
		streetAddress2.sendKeys("ABC street");
		
		WebElement streetAddress3 = driver.findElement(By.xpath("//input[@id='street_3']"));
		streetAddress2.sendKeys("ABC Flats");
		
		WebElement country = driver.findElement(By.xpath("//select[@name='country_id']"));
		Select s1 = new Select(country);
		s1.selectByIndex(0);
		
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Banglore");
		
		WebElement zip = driver.findElement(By.xpath("//input[@name='postcode']"));
		zip.sendKeys("123456");
		
		WebElement billingAddress = driver.findElement(By.xpath("(//input[@value='1'])[1]"));
		
		WebElement shippingAddress = driver.findElement(By.xpath("(//input[@value='1'])[2]"));
		shippingAddress.click();
		
		WebElement saveAddress = driver.findElement(By.xpath("//span[text()='Save Address']"));
		saveAddress.click();
	}
	
	
	@Test(priority=6,enabled=true)
	private void accountInformation() throws InterruptedException {
		
		Thread.sleep(10000);
    
		WebElement accountInfo = driver.findElement(By.xpath("//a[text()='Account Information']"));
		accountInfo.click();
		
		//info change
		
		WebElement prefix = driver.findElement(By.xpath("//label[text()='Ms']"));
		prefix.click();
		
		WebElement name = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		name.clear();
		name.sendKeys("BalaG");
		
		WebElement dob = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
		dob.clear();
		dob.sendKeys("08/12/2000");
		
		WebElement phno = driver.findElement(By.xpath("(//input[@type='text'])[7]"));
		phno.clear();
		phno.sendKeys("987654321");
		
		WebElement saveBtn = driver.findElement(By.xpath("(//span[text()='Save'])[1]"));
		saveBtn.click();
	}
	
	
	@Test(priority=7,enabled=true)
	private void accountInfoEmailAndPasswordUpdate() throws InterruptedException {
     
		
		Thread.sleep(10000);
		
		WebElement accountInfo = driver.findElement(By.xpath("//a[text()='Account Information']"));
		accountInfo.click();		
		
		String newPasword="Balaji@123";
		
		WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		email.clear();
		email.sendKeys("balaji.p@sysfore.com");
		
		WebElement oldPasword = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		oldPasword.sendKeys(oldPassword);
		
		WebElement newPassword = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		newPassword.sendKeys(newPasword);
		
		WebElement confirmPassword = driver.findElement(By.xpath("(//input[@type='password'])[3]"));
		confirmPassword.sendKeys(newPasword);
		
		WebElement saveBtn = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		saveBtn.click();
		
		Thread.sleep(8000);
		
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("balaji.p@sysfore.com ");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys(newPasword);
				
		WebElement logBtn = driver.findElement(By.xpath("(//span[text()='Login'])[2]"));
		logBtn.click();
		
		Thread.sleep(4000);
		
		String title = driver.getTitle();
		
		if (title.equals("My Account")) {
			
			System.out.println("password sucessfully Updated");
			
		} else {
			
			System.out.println("password Update unSuccessful");

		}
		
		
	}
	
	
	@Test(priority=8,enabled=true)
	private void myproductReviews() {
    
		
		    WebElement myProductReviewBtn = driver.findElement(By.xpath("//a[text()='My Product Reviews']"));
		    myProductReviewBtn.click();
		
			
			WebElement seeReviews = driver.findElement(By.xpath("//span[text()='See Details']"));
			seeReviews.click();
			
			WebElement viewReviews = driver.findElement(By.xpath("//div[@class='customer-review view']"));
			
			
			
			if (viewReviews.isDisplayed()) {
				
				
				System.out.println("user entered in to the view details section");
				
			} else {
                
				System.out.println("unfortunately user Reviews are not showing perfectly");
			}
			
			
			WebElement backToMyReview = driver.findElement(By.xpath("//span[text()='Back to My Reviews']"));
			backToMyReview.click();			
			
		} 
		
		
		
		
				
		
	
	
	
	
	@Test(priority=9,enabled=true)
	private void newsLetterSubscription() throws InterruptedException {
      
		
		WebElement newsLettersubcriptionBtn = driver.findElement(By.xpath("//a[text()='Newsletter Subscriptions']"));
		newsLettersubcriptionBtn.click();
		
		WebElement subscriptedBtn = driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
		
		
		if (subscriptedBtn.isEnabled()) {
			
			System.out.println("user already subscribed the newsletter");
			
			
			WebElement goback = driver.findElement(By.xpath("//span[text()='Back']"));
			goback.click();
			
			
		} else {
            
			System.out.println("user already not subscribed the newsletter");
			
            String weWant="subscribe";
			
			if (weWant.contains("subscribe")) {
				
				subscriptedBtn.click();
				
				WebElement saveNewssubs = driver.findElement(By.xpath("//span[text()='Save']"));
				saveNewssubs.click();
				
			}
			
		}
		
		Thread.sleep(6000);
		
	}
	
	
	
	
	
  @Test(priority=10,enabled=true)
  private void serviceAppointment() throws InterruptedException {
   
	  
	  
	   WebElement serviceAppointment = driver.findElement(By.xpath("//a[text()='Service Appointment']"));
	   serviceAppointment.click();
	   
	   Thread.sleep(5000);
	   
	   List<WebElement> appointmetnLists = driver.findElements(By.xpath("//div[@class='appointment-block container']"));
	  
	 
	  
	  if (!appointmetnLists.isEmpty()) {
		
		  int appointmentsCount = appointmetnLists.size();
		  System.out.println("user booked for "+appointmentsCount+"appointments");
		  
		  
		  String weWant ="cancel ";
		  
		  
		  if (weWant.contains("cancel")) {
			
			  WebElement bookingcancel = driver.findElement(By.xpath("(//div[@class='cancel'])[1]"));
			  bookingcancel.click();
			  
			  driver.navigate().refresh();
			  
			  Thread.sleep(5000);
			  
			  WebElement cancelConfirm = driver.findElement(By.xpath("(//span[text()=' Cancelled '])[1]"));
			 
			  if (cancelConfirm.isDisplayed()) {
				System.out.println("user appointment successfully cancelled");
			}
			  
		}
		  
		  
	} else {
           
		System.out.println("user not book appointment yet");
       		
		
	}
	  
	  
	  
	  
    }
	
  
  @Test(priority=11,enabled=true)
  private void storeCredit() throws InterruptedException {
   
	  
	  WebElement storecreditBtn = driver.findElement(By.xpath("//a[text()='Store Credit']"));
	  storecreditBtn.click();
	  
	  Thread.sleep(5000);
	  
	  WebElement aed = driver.findElement(By.xpath("//b[text()='AED 0']"));
	  String aedValu = aed.getText();
	  
	  if (!aedValu.equals("AED 0")) {
		  
		  WebElement creditToFriend = driver.findElement(By.xpath("//strong[text()='Send Credit to Friend']"));
		  js.executeScript("arguments[0].scrollIntoView(true)",creditToFriend);
		  
		  WebElement friendEmail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		  friendEmail.sendKeys("friend@mailinator.com");
		  
		  WebElement transferAmount = driver.findElement(By.xpath("(//input[@type='number'])[2]"));
		  transferAmount.sendKeys("45");
		  
		  WebElement message = driver.findElement(By.xpath("//textarea[@name='message']"));
		  message.sendKeys("gift");
		  
		  WebElement send = driver.findElement(By.xpath("(//button[@type='submit'])[4]"));
		  send.click();
		  
		  
		  
	} else {
		
		
		System.out.println("you don't have a proper balance");

	}
	  
	  
	  
}
	
	
	
	
	
	
	
}
