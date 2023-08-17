package variousConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsefulMethods extends TestClass {

	WebDriver driver;
	String browser;
	String username;
	String password;
	String url;
	
	public void dropDownSelection(WebElement element, String visibleText) {

		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);

	}

	public int randomNumGenerator(int bound) {

		Random rnd = new Random();
		int numGenerator = rnd.nextInt(bound);
		return numGenerator;

	}

	public void waitForElement(WebDriver driver, int seconds, By elementToBeLocated) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLocated));
	}

	public void readProp(String file) {

		try {

			InputStream input = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(input);
			browser = prop.getProperty("browser");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			url = prop.getProperty("url");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void browserChoice() {

		if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

	}
}
