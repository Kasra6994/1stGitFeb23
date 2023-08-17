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

public class Practice1 {

	WebDriver driver;
	String browser;
	String username;
	String password;
	String url;

	@BeforeTest
	public void readProp() {

		try {

			InputStream input = new FileInputStream("src/main/java/config/config.properties");
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
	By loginEmailField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
	@BeforeMethod
	public void init() {

		if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}



	
}





