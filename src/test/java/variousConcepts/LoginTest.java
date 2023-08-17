package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	String username = "demo@techfios.com";
	String password = "abc123";
	By loginEmailField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
	By loginField = By.xpath("//button[@name='login']");
	By dashboardHeaderField = By.xpath("//h2[normalize-space()='Dashboard']");
	String dashboardHeaderText = "Dashboard";

	
	
	
	
	
	
	@BeforeMethod
	public void init() {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void login() {

		driver.findElement(loginEmailField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginField).click();
		Assert.assertEquals(driver.findElement(dashboardHeaderField).getText(), dashboardHeaderText, "Not Found!");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
