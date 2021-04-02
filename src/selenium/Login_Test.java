package selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_Test extends BaseTest {

	String URL_dashBoard = "http://localhost/wordpress/wp-admin/";
	String user_login = "user_login";
	String user_pass = "user_pass";
	String submitBtn = "wp-submit";

	public void login(String user, String pass) {
		driver.findElement(By.id(user_login)).sendKeys(user);
		driver.findElement(By.id(user_pass)).sendKeys(pass);
		driver.findElement(By.id(submitBtn)).click();
	}

	@Test
	public void TC_01_loginByAdmin() {
		login("dinhlt", "121212");
		System.out.println("Current Url DashBoard: " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), URL_dashBoard);

	}

	@Test
	public void TC_02_loginWithBlankFiel() {
		login("", "");
		System.out.println("Current Url Login: " + driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), URL_login);
	}

}
