package selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Login_Test {
	WebDriver driver;
	String URL_login = "http://localhost/wordpress/wp-login.php";
	String URL_dashBoard = "http://localhost/wordpress/wp-admin/";
	String user_login = "user_login";
	String user_pass = "user_pass";
	String submitBtn = "wp-submit";
	
	public void login(String user,String pass) {
		driver.findElement(By.id(user_login)).sendKeys(user);
		driver.findElement(By.id(user_pass)).sendKeys(pass);
		driver.findElement(By.id(submitBtn)).click();
	}

	@BeforeMethod
	public void beforeMethod() {
//	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\demoSelenium01\\toolchromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\demoSelenium01\\tool\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(URL_login);
	}

	@Test
	public void TC_01_loginByAdmin() {
		login("dinhlt","121212");
		System.out.println("Current Url DashBoard: " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), URL_dashBoard);

	}

	@Test
	public void TC_02_loginWithBlankFiel() {
		login("","");
		System.out.println("Current Url Login: " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), URL_login);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
