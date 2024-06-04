package org.driven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

	WebDriver driver;

	@BeforeClass
	private void start() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://dev.proshop.ae/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement signBtn = driver.findElement(By.xpath("//a[@id='account-btn']"));
		signBtn.click();
		
		WebElement userName = driver.findElement(By.xpath("//input[@name='login[username]']"));
		userName.sendKeys("Balaji.p@sysfore.com ");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='login[password]']"));
		password.sendKeys("Balaji@123");
		
		WebElement logBtn = driver.findElement(By.xpath("(//span[text()='Login'])[2]"));
		logBtn.click();
		

	}

	@Test(enabled = true,priority=1)
	private void shopTyresBySize() throws InterruptedException {

		WebElement bySize = driver.findElement(By.xpath("//a[text()='Shop Tyres by Size']"));
		bySize.click();

		Thread.sleep(5000);

		WebElement popupopen = driver.findElement(By.xpath("(//div[@class='content'])[1]"));

		if (popupopen.isDisplayed()) {
			System.out.println("user clicked the shop tyres by size link so the popup is opened properly");
			 WebElement cancel = driver.findElement(By.xpath("(//a[@class='close-modal'])[1]"));
	    	 cancel.click();
		} else {
			System.out.println("tyre by size popup is not opened");
		}

	}

	@Test(enabled = true,priority=2)
	private void shopTyresByCar() throws InterruptedException {

		WebElement byCar = driver.findElement(By.xpath("//a[text()='Shop Tyres by Car']"));
		byCar.click();

		Thread.sleep(3000);

		WebElement popupopen = driver.findElement(By.xpath("//div[@class='tyre-search-tabs clearfix']"));

		if (popupopen.isDisplayed()) {

			System.out.println("user clicked the shop tyres by car link so the popup is opened properly");
			WebElement cancel = driver.findElement(By.xpath("(//a[@class='close-modal'])[1]"));
	    	cancel.click();
			
		} else {
			System.out.println("tyre by car popup is not opened");
		}

	}

	@Test(enabled = true,priority=3)
	private void shopTyresByBrand() throws InterruptedException {

		WebElement byBrand = driver.findElement(By.xpath("//a[text()='Shop Tyres by Brand']"));
		byBrand.click();

		Thread.sleep(3000);

		WebElement popupopen = driver.findElement(By.xpath("//div[@class='tyre-search-tabs clearfix']"));

		if (popupopen.isDisplayed()) {

			System.out.println("user clicked the shop tyres by car link so the popup is opened properly");
			WebElement cancel = driver.findElement(By.xpath("(//a[@class='close-modal'])[1]"));
	    	cancel.click();

		} else {

			System.out.println("tyre by brand popup is not opened");

		}

	}

	@Test(enabled=true,priority=4)
	private void engineoilAndLubricants() throws InterruptedException {

		WebElement lubricants = driver.findElement(By.xpath("//a[text()='Engine oils & Lubricants']"));
		lubricants.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Lubricants")) {

			System.out.println("user entered in lubricants page");

		} else {
			System.out.println("user not entered in lubricants page");
		}

	}

	@Test(enabled=true,priority=5)

	private void batteries() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Car Batteries']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Batteries")) {

			System.out.println("user entered in Batteries page");

		} else {
			System.out.println("user not entered in Batteries page");
		}

	}
	
	
	
	@Test(enabled=true,priority=6)

	private void Accessories() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Car Accessories']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Accessories")) {

			System.out.println("user entered in Accessories page");

		} else {
			System.out.println("user not entered in Accessories page");
		}

	}
	
	
	
	@Test(enabled=true,priority=7)

	private void mobileVanServieces() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Mobile Van Services']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Mobile Van Services|Car Services")) {

			System.out.println("user entered in Mobile Van Services page");

		} else {
			System.out.println("user not entered in Mobile Van Services page");
		}

	}
	
	
	
	@Test(enabled=true,priority=8)

	private void brakeServieces() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Brake Services']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Brake Services|Car Services")) {

			System.out.println("user entered in Brake Services page");

		} else {
			System.out.println("user not entered in Brake Services page");
		}

	}
	
	
	@Test(enabled=true,priority=9)

	private void tyreRotation() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Tyre Rotation']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Tyre Rotation|Car Services")) {

			System.out.println("user entered in Tyre Rotation page");

		} else {
			System.out.println("user not entered in Tyre Rotation page");
		}

	}
	
	

	@Test(enabled=true,priority=10)

	private void wheelAlignment() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Wheel Alignment']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Wheel Alignment|Car Services")) {

			System.out.println("user entered in Wheel Alignment page");

		} else {
			System.out.println("user not entered in Wheel Alignment page");
		}

	}
	
	@Test(enabled=true,priority=11)

	private void wheelBalancing() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Wheel Balancing']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Wheel Balancing|Car Services")) {

			System.out.println("user entered in Wheel Balancing page");

		} else {
			System.out.println("user not entered in Wheel Balancing page");
		}

	}
	
	
	
	@Test(enabled=true,priority=12)

	private void punctureRepair() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Puncture Repair']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Puncture Repair|Car Services")) {

			System.out.println("user entered in Puncture Repair page");

		} else {
			System.out.println("user not entered in Puncture Repair page");
		}

	}
	

	@Test(enabled=true,priority=13)

	private void allServices() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='All Services']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Car Services")) {

			System.out.println("user entered in All Services page");

		} else {
			System.out.println("user not entered in All Services page");
		}

	}
	
	
	

	@Test(enabled=true,priority=14)

	private void ourLocations() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Our Locations']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("locations")) {

			System.out.println("user entered in Our Locations page");

		} else {
			System.out.println("user not entered in Our Locations page");
		}

	}

	
	@Test(enabled=true,priority=15)

	private void acceptedDiscountCards() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Accepted Discount Cards (In-shop)']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Discount Cards")) {

			System.out.println("user entered in Discount Cards page");

		} else {
			System.out.println("user not entered in Discount Cards page");
		}

	}
	

	@Test(enabled=true,priority=16)

	private void easyPaymentPlans() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Easy Payment Plans']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Easy Payment Plans")) {

			System.out.println("user entered in Easy Payment Plans page");

		} else {
			System.out.println("user not entered in Easy Payment Plans page");
		}

	}
	
	@Test(enabled=true,priority=17)

	private void proBlogs() throws InterruptedException {

		WebElement battery = driver.findElement(By.xpath("//a[text()='Pro Blogs']"));
		battery.click();

		Thread.sleep(4000);

		String title = driver.getTitle();

		if (title.contains("Pro Blogs")) {

			System.out.println("user entered in Pro Blogs page");

		} else {
			System.out.println("user not entered in Pro Blogs page");
		}

	}
	
	@Test(enabled=true,priority=18)

	private void siteMap() throws InterruptedException {

		WebElement sitemap = driver.findElement(By.xpath("//a[text()='Site Map']"));
		sitemap.click();

		Thread.sleep(4000);

		String url = driver.getCurrentUrl();
		
		

		if (url.contains("http://dev.proshop.ae/sitemap.html/")) {

			System.out.println("user entered in Site Map page");

		} else {
			System.out.println("user not entered in Site Map page");
		}

	}
	
	
	
	@Test(enabled=true,priority=19)

	private void dunlop() throws InterruptedException {

		WebElement dunlop = driver.findElement(By.xpath("//a[text()='Dunlop']"));
		dunlop.click();

		Thread.sleep(4000);

		String title = driver.getTitle();
		
		System.out.println(title);

		if (title.contains("Dunlop - Brand")) {

			System.out.println("user entered in Dunlop page");

		} else {
			System.out.println("user not entered in Dunlop page");
		}

	}
	
	
	@Test(enabled=true,priority=20)

	private void falken() throws InterruptedException {

		WebElement falken = driver.findElement(By.xpath("//a[text()='Falken']"));
		falken.click();

		Thread.sleep(4000);

		String title = driver.getTitle();
		
		

		if (title.contains("Falken | Brand")) {

			System.out.println("user entered in Falken page");

		} else {
			System.out.println("user not entered in Falken page");
		}

	}
	
	
	@Test(enabled=true,priority=21)

	private void Petronas() throws InterruptedException {

		WebElement petronas = driver.findElement(By.xpath("//a[text()='Petronas']"));
		petronas.click();

		Thread.sleep(4000);

		String title = driver.getTitle();
		
		

		if (title.contains("Petronas | Brand")) {

			System.out.println("user entered in Petronas page");

		} else {
			System.out.println("user not entered in Petronas page");
		}

	}
	
	
	@Test(enabled=true,priority=22)

	private void iQPower() throws InterruptedException {

		WebElement iqpower = driver.findElement(By.xpath("//a[text()='iQPower']"));
		iqpower.click();

		Thread.sleep(4000);

		String title = driver.getTitle();
		
		

		if (title.contains("iQ Power | Brand")) {

			System.out.println("user entered in iQPower page");

		} else {
			System.out.println("user not entered in iQPower page");
		}

	}
	
	
	@Test(enabled=true,priority=23)

	private void allBrands() throws InterruptedException {

		WebElement allBrands = driver.findElement(By.xpath("//a[text()='All Brands']"));
		allBrands.click();

		Thread.sleep(4000);

		String title = driver.getTitle();
		
		

		if (title.contains("Our Brands")) {

			System.out.println("user entered in our Brands page");

		} else {
			System.out.println("user not entered in Our Brands page");
		}

	}
	
	
	@Test(enabled=true,priority=24)

	private void contactUs() throws InterruptedException {

		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact Us']"));
		contactUs.click();

		Thread.sleep(4000);

		String title = driver.getTitle();
		
		

		if (title.contains("Contact Us")) {

			System.out.println("user entered in our Contact Us page");

		} else {
			System.out.println("user not entered in Contact Us page");
		}

	}
	
	
	
	@Test(enabled=false,priority=25)

	private void tyres800() throws InterruptedException {

		WebElement tyres800 = driver.findElement(By.xpath("//a[text()='800-TYRES']"));
		tyres800.click();

		Thread.sleep(4000);

		String title = driver.getCurrentUrl();
		
		System.out.println(title);

	/*	if (title.contains("Contact Us")) {

			System.out.println("800 call popup is showing");

		} else {
			System.out.println("800 call popup is not showing");
		}*/

	}
	
	
	@Test(enabled=true,priority=26)

	private void getAQuote() throws InterruptedException {

		WebElement getAQuote = driver.findElement(By.xpath("//a[text()='Get A Quote']"));
		getAQuote.click();

		Thread.sleep(4000);

		WebElement quoteLabel = driver.findElement(By.xpath("//div[@class='request-for-service-form']"));
		
		if (quoteLabel.isDisplayed()) {
			System.out.println("user can see the get a quote label");			
			driver.findElement(By.xpath("(//a[text()='X'])[4]")).click();
			
		} else {
			System.out.println("user cannot see the get a quote label");
		}
	}


	@Test(enabled=false,priority=27)

	private void emailUs() throws InterruptedException {

		WebElement emailUs = driver.findElement(By.xpath("//a[text()='Email us']"));
		emailUs.click();

		Thread.sleep(4000);

		String title = driver.getCurrentUrl();
		
		System.out.println("user can see the email us popup");

	/*	if (title.contains("Contact Us")) {

			System.out.println("800 call popup is showing");

		} else {
			System.out.println("800 call popup is not showing");
		}*/

	}
	
	
	@Test(enabled=true,priority=28)

	private void whatsAppSupport() throws InterruptedException {

		WebElement whatsapp = driver.findElement(By.xpath("//a[text()='WhatsApp Support']"));
		whatsapp.click();

		Thread.sleep(4000);
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String>  li = new ArrayList<String>(windows);

		driver.switchTo().window(li.get(1));
		
		String title = driver.getTitle();
		
		if (title.contains("Share on WhatsApp")) {
			
			System.out.println("user clicked the whatsapp support link the link is redirecting to the whatsapp page");
			
		} else {
			System.out.println("user clicked the whatsapp support link the link is not redirecting to the whatsapp page");

		}
		
		driver.switchTo().window(li.get(0));
		
	}
	
	
	@Test(enabled=true,priority=29)

	private void whoWeAre() throws InterruptedException {

		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Who We Are']"));
		contactUs.click();

		Thread.sleep(4000);

		String title = driver.getTitle();
		
		

		if (title.contains("About Proshop")) {

			System.out.println("user entered in About proshop  page");

		} else {
			System.out.println("user not entered in About Proshop page");
		}

	}
	
	
	
	@Test(enabled=true,priority=30)

	private void locations() throws InterruptedException {

		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Locations']"));
		contactUs.click();

		Thread.sleep(4000);

		String title = driver.getTitle();
		
		

		if (title.contains("locations")) {

			System.out.println("user entered in Locations  page");

		} else {
			System.out.println("user not entered in Locations page");
		}

	}
	
	
	
	@Test(enabled=true,priority=31)

	private void esagTba() throws InterruptedException {

		WebElement esagTba = driver.findElement(By.xpath("//a[text()='ESAG TBA']"));
		esagTba.click();

		Thread.sleep(4000);

        Set<String> windows = driver.getWindowHandles();
		
		List<String>  li = new ArrayList<String>(windows);

		driver.switchTo().window(li.get(1));
		
		String title = driver.getTitle();
		
		
		if (title.contains("Al Gurg Tyres, Batteries & Accessories Division (DUNLOP)")) {
			
			System.out.println("user clicked the ESAG TBA link the link is redirecting to the ESAG TBA page");
			
		} else {
			System.out.println("user clicked the ESAG TBA link the link is not redirecting to the ESAG TBA page");

		}
		
		Thread.sleep(4000);
		
		driver.switchTo().window(li.get(0));
	
	}
	
	
	
	@Test(enabled=true,priority=32)

	private void aboutEsag() throws InterruptedException {

		WebElement aboutEsag = driver.findElement(By.xpath("//a[text()='About ESAG']"));
		aboutEsag.click();

		Thread.sleep(4000);

        Set<String> windows = driver.getWindowHandles();
		
		List<String>  li = new ArrayList<String>(windows);

		driver.switchTo().window(li.get(1));
		
		String title = driver.getTitle();
				
		if (title.contains("About Easa Saleh Al Gurg Group LLC (ESAG), Dubai, UAE")) {
			
			System.out.println("user clicked the About ESAG link the link is redirecting to the About ESAG page");
			
		} else {
			System.out.println("user clicked the About ESAG link the link is not redirecting to the About ESAG page");

		}
		
		Thread.sleep(4000);
		
		driver.switchTo().window(li.get(0));
		
	
	}
	
	
	@Test(enabled=true,priority=33)

	private void careers() throws InterruptedException {

		WebElement careers = driver.findElement(By.xpath("//a[text()='Careers']"));
		careers.click();

		Thread.sleep(4000);

        Set<String> windows = driver.getWindowHandles();
		
		List<String>  li = new ArrayList<String>(windows);

		driver.switchTo().window(li.get(1));
		
		String title = driver.getTitle();
		
				
		if (title.contains("Human Capital - Easa Saleh Al Gurg Group")) {
			
			System.out.println("user clicked the careers link the link is redirecting to the careers page");
			
		} else {
			System.out.println("user clicked the careers link the link is not redirecting to the careers page");

		}
		
		Thread.sleep(4000);
		
		driver.switchTo().window(li.get(0));
	
	}
	
	
	
	@Test(enabled=true,priority=34)

	private void companyNews() throws InterruptedException {

		WebElement companyNews = driver.findElement(By.xpath("//a[text()='Company News']"));
		companyNews.click();

		Thread.sleep(4000);
    
		String title = driver.getTitle();
					
		if (title.equals("Company News")) {
			
			System.out.println("user clicked the Company News link the link is redirecting to the Company News page");
			
		} else {
			System.out.println("user clicked the Company News link the link is not redirecting to the company News page");

		}
		
	
	}
	
	

	@Test(enabled=true,priority=35)

	private void testimonials() throws InterruptedException {

		WebElement testimonials = driver.findElement(By.xpath("//a[text()='Testimonials']"));
		testimonials.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.equals("Testimonials")) {
			
			System.out.println("user clicked the Testimonials link the link is redirecting to the Testimonials page");
			
		} else {
			System.out.println("user clicked the Testimonials link the link is not redirecting to the Testimonials page");

		}
		
	
	}
	
	

	@Test(enabled=true,priority=36)

	private void login() throws InterruptedException {

		WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
		login.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.equals("Customer Login")) {
			
			System.out.println("user clicked the Login link the link is redirecting to the Login page");
			
		} else {
			System.out.println("user clicked the Login link the link is not redirecting to the Login page");

		}
		
	
	}
	

	

	@Test(enabled=true,priority=37)

	private void register() throws InterruptedException {

		WebElement register = driver.findElement(By.xpath("//a[text()='Testimonials']"));
		register.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.equals("Create New Customer Account")) {
			
			System.out.println("user clicked the Register link the link is redirecting to the Register page");
			
		} else {
			System.out.println("user clicked the Register link the link is not redirecting to the Register page");

		}
		
	
	}
	
	

	@Test(enabled=true,priority=38)

	private void myOrders() throws InterruptedException {

		WebElement myOrders = driver.findElement(By.xpath("//a[text()='My Orders']"));
		myOrders.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.equals("My Orders")) {
			
			System.out.println("user clicked the My Orders link the link is redirecting to the My Orders page");
			
		} else {
			System.out.println("user clicked the My Orders link the link is not redirecting to the My Orders page because user not logged in");

		}
		
	
	}
	
	

	@Test(enabled=true,priority=39)

	private void myAddress() throws InterruptedException {

		WebElement myAddress = driver.findElement(By.xpath("//a[text()='My Addresses']"));
		myAddress.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.equals("Address Book")) {
			
			System.out.println("user clicked the Address Book link the link is redirecting to the Address Book page");
			
		} else {
			System.out.println("user clicked the Address Book link the link is not redirecting to the Address Book page because user not log in");

		}
		
	
	}
	
	
	
	@Test(enabled=true,priority=40)

	private void accountSettting() throws InterruptedException {

		WebElement accSetting = driver.findElement(By.xpath("//a[text()='Account Settings']"));
		accSetting.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.equals("Account Information")) {
			
			System.out.println("user clicked the Account Information link the link is redirecting to the Account Information page");
			
		} else {
			System.out.println("user clicked the Account Information link the link is not redirecting to the Account Information page because not log in");

		}
		
	
	}
	
	@Test(enabled=true,priority=41)

	private void fAQs() throws InterruptedException {

		WebElement faqs = driver.findElement(By.xpath("//a[text()='FAQs']"));
		faqs.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.equals("FAQs")) {
			
			System.out.println("user clicked the FAQs link the link is redirecting to the FAQs page");
			
		} else {
			System.out.println("user clicked the FAQs link the link is not redirecting to the FAQs page.");

		}
		
	
	}
	
	@Test(enabled=true,priority=42)

	private void tyreCare() throws InterruptedException {

		WebElement tyreCare = driver.findElement(By.xpath("//a[text()='Tyre Care']"));
		tyreCare.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.contains("Tyre Care")) {
			
			System.out.println("user clicked the Tyre Care link the link is redirecting to the Tyre Care page");
			
		} else {
			System.out.println("user clicked the Tyre Care link the link is not redirecting to the Tyre Care page");

		}
		
	
	}
	
	@Test(enabled=true,priority=43)

	private void deliveryPolicy() throws InterruptedException {

		WebElement delvryPolicy = driver.findElement(By.xpath("//a[text()='Delivery Policy']"));
		delvryPolicy.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.contains("Terms and Conditions")) {
			
			System.out.println("user clicked the Delivery Policy link the link is redirecting to the Delivery Policy page");
			
		} else {
			System.out.println("user clicked the Delivery Policy link the link is not redirecting to the Delivery Policy page");

		}
		
	
	}
	
	@Test(enabled=true,priority=44)

	private void termsAndConditions() throws InterruptedException {

		WebElement terms = driver.findElement(By.xpath("//a[text()='Account Settings']"));
		terms.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.contains("Terms and Conditions")) {
			
			System.out.println("user clicked the Terms & Conditions link the link is redirecting to the Terms & Conditions page");
			
		} else {
			System.out.println("user clicked the Terms & Conditions link the link is not redirecting to the Terms & Conditions page");

		}
		
	
	}
	
	@Test(enabled=true,priority=45)

	private void privacyPolicy() throws InterruptedException {

		WebElement priPol = driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
		priPol.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.contains("Privacy Policy")) {
			
			System.out.println("user clicked the Privacy Policy link the link is redirecting to the Privacy Policy page");
			
		} else {
			System.out.println("user clicked the Privacy Policy link the link is not redirecting to the Privacy Policy page");

		}
		
	
	}
	
	
	@Test(enabled=true,priority=46)

	private void uaeConsumerRights() throws InterruptedException {

		WebElement uae = driver.findElement(By.xpath("//a[text()='UAE Consumer Rights']"));
		uae.click();

		Thread.sleep(4000);

       
		String title = driver.getTitle();
		
				
		if (title.contains("UAE Consumer Rights")) {
			
			System.out.println("user clicked the UAE Consumer Rights link the link is redirecting to the UAE Consumer Rights page");
			
		} else {
			System.out.println("user clicked the UAE Consumer Rights link the link is not redirecting to the UAE Consumer Rights page");

		}
		
	
	}
	
	
	@Test(enabled=true,priority=47)
	private void newsLetter() {
     
		
		WebElement newsEmailTxtboc = driver.findElement(By.xpath("//input[@id='newsletter-email']"));
		String inputValue="balaji.p@sysfore.com";
		
		if (inputValue.contains("@")|inputValue.contains(".com")) {
			
			newsEmailTxtboc.sendKeys(inputValue);
			
		} else {

			WebElement errMsg = driver.findElement(By.xpath("(//div[@id='newsletter-email-error'])[1]"));
			System.out.println(errMsg);
		}
		
		
		
	}
	
	@Test(enabled=true,priority=48)
	private void facebook() {
     
		WebElement fblink = driver.findElement(By.xpath("//i[@class='fab fa-facebook-f']"));
		fblink.click();
		
		Set<String> fbRedirect = driver.getWindowHandles();
		
		List<String> li = new ArrayList<String>(fbRedirect);
		
		driver.switchTo().window(li.get(1));
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(li.get(0));
		
	}
	
	
	@Test(enabled=true,priority=49)
	private void instagram() {
    
		WebElement instaLink = driver.findElement(By.xpath("//i[@class='fab fa-instagram']"));
		instaLink.click();
		
        Set<String> instaRedirect = driver.getWindowHandles();
		
		List<String> li = new ArrayList<String>(instaRedirect);
		
		driver.switchTo().window(li.get(1));
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(li.get(0));
		
		
	}
	
	
	@Test(enabled=true,priority=50)
	private void socialMedia() throws InterruptedException {
    
		WebElement socialMediaLink = driver.findElement(By.xpath("//i[@class='fab fa-linkedin-in']"));
		socialMediaLink.click();
		
        Thread.sleep(4000);
        
        String curTitle = driver.getTitle();
       
		if (curTitle.contains("Privacy Policy")) {
			
			System.out.println("user clicked the social media link its redirecting to privacy policy page");
			
		} else {

			System.out.println("user clicked the social media link its not redirecting. ");
		}
		
		
		
	}
	
	
	
	@Test(enabled=true,priority=51)
	private void algurgLink() throws InterruptedException {
    

		WebElement algurgLink = driver.findElement(By.xpath("//u[text()='Easa Saleh Al Gurg Tyres, Batteries and Accessories']"));
		algurgLink.click();
		
        Thread.sleep(4000);
        
       String curTitle = driver.getTitle();
		
       
       if (curTitle.contains("Al Gurg Tyres, Batteries & Accessories Division (DUNLOP)")) {
		
    	   System.out.println("user clicked the algurg link its redirecting to algurg page");
    	   
	} else {

		  System.out.println("user clicked the algurg link its not redirecting");
		
	}
       
	}
	
	
	
	
	@AfterClass
	private void end() {
    
		
		//driver.quit();
		
	}
	
}
