package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass1 extends UsefulMethods {

	WebDriver driver;

	String username = "demo@techfios.com";
	String password = "abc123";
	By loginEmailField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
	By dashboardField = By.xpath("//span[text()='Dashboard']");
	By customerField = By.xpath("//span[text()='Customers']");
	By addCustomerField = By.xpath("//a[text()='Add Customer']");
	By loginField = By.xpath("//button[@name='login']");
	By fullNameField = By.xpath("//input[@id='account']");
	By companyDropDown = By.xpath("//select[@id='cid']");
	By emailField = By.xpath("//input[@id='email']");
	By phoneField = By.xpath("//input[@id='phone']");
	By addressField = By.xpath("//input[@id='address']");
	By cityField = By.xpath("//input[@id='city']");
	By stateField = By.xpath("//input[@id='state']");
	By countryDropDown = By.xpath("//select[@id='country']");
	By zipField = By.xpath("//input[@id='zip']");
	By submitField = By.xpath("//button[@id='submit']");
	By summaryField = By.xpath("//a[@id='summary']");
	By addCustomerHeaderField = By.xpath("//h5[text()='Add Contact']");
	
	String dashboard = "Dashboard";
	String addCustomerHeaderText = "Add Contact";
	
	
	
	@BeforeMethod
	public void init() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	//@Test
	public void login() {

		driver.findElement(loginEmailField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginField).click(); 
		Assert.assertEquals(driver.findElement(dashboardField).getText(), dashboard, "page not found!");

	}

	
	@Test
	public void addCustomer() throws InterruptedException {
		
		login();
		Thread.sleep(3000);
		driver.findElement(customerField).click();
		driver.findElement(addCustomerField).click();
		Assert.assertEquals(driver.findElement(addCustomerHeaderField).getText(), addCustomerHeaderText, "Add Customer Page not found!");
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {

		driver.close();
		driver.quit();
	}
}
