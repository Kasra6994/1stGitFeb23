package variousConcepts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomeWork extends TestClass1 {
	
	WebDriver driver;

	@Test
	public void setUp() {
		readProp("src/main/java/config/config.properties");
		browserChoice();
		login();

	}

	
}
