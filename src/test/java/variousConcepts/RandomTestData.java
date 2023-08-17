package variousConcepts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RandomTestData extends TestClass {

	// WebDriver driver;
	// String username;
	// String password;
	// String url;
	// String browser;

	By loginEmailField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
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

	String addCustomerHeaderText = "Add Contact";
	String full_name = "Selenium2023";
	String company = "Techfios";
	String email = "demo@techfios.com";
	String phone_Number = "123-456-1";

	@BeforeMethod
	public void init() {
		readProp();
		browserChoice();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(loginEmailField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginField).click();

	}

	@Test
	public void addContactTest() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(customerField).click();
		driver.findElement(addCustomerField).click();
		Assert.assertEquals(driver.findElement(addCustomerHeaderField).getText(), addCustomerHeaderText,
				"Add Customer Page not found!");

		driver.findElement(fullNameField).sendKeys(full_name + randomNumGenerator(999));
		waitForElement(driver, 5, addCustomerField);
		selectFromDropdown(driver.findElement(companyDropDown), company);
		driver.findElement(emailField).sendKeys(randomNumGenerator(999) + email);
		driver.findElement(phoneField).sendKeys(phone_Number + randomNumGenerator(999));
		driver.findElement(submitField).click();

		Assert.assertEquals(driver.findElement(summaryField), driver.findElement(By.xpath("//a[@id='summary']")));

	}

	public int randomNumGenerator(int bound) {

		Random rnd = new Random();
		int generatedNum = rnd.nextInt(bound);
		return generatedNum;
	}

	public void selectFromDropdown(WebElement element, String visibleText) {

		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);

	}

	@AfterMethod
	public void tearDown() {
 
		//driver.close();
		driver.quit();

	}
}
