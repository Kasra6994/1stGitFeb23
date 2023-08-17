package variousConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass  {

	WebDriver driver;
	String browser;
	String username;
	String password;
	String url;

	// @BeforeTest
	public void readProp() {

		try {

			InputStream input = new FileInputStream("src/main/java/config/config.properties");
			Properties prop = new Properties();
			prop.load(input);
			url = prop.getProperty("url");
			browser = prop.getProperty("browser");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	// @BeforeMethod
	public void browserChoice() {

		if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		// driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		// driver.get("https://techfios.com/billing/?ng=admin/");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	By loginEmailField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");

	// @Test
	public void login() {

		driver.get(url);
		driver.findElement(loginEmailField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
	}

}
