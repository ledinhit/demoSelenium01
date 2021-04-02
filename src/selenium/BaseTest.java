package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;
	public static final String URL_login = "http://localhost/wordpress/wp-login.php";

	@BeforeMethod
	public void beforeMethod() {
//	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\demoSelenium01\\toolchromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\demoSelenium01\\tool\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(URL_login);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
