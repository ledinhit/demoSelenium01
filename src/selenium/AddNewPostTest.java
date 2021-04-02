package selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddNewPostTest extends BaseTest {
	
	String URL_addNewPost ="http://localhost/wordpress/wp-admin/post-new.php";
	String user_login = "user_login";
	String user_pass = "user_pass";
	String submitBtn = "wp-submit";
	String title = "editor-post-title__input";
	String content = "block-editor-rich-text__editable";
	String publishBtn ="components-button";

	public void login(String user, String pass) {
		driver.findElement(By.id(user_login)).sendKeys(user);
		driver.findElement(By.id(user_pass)).sendKeys(pass);
		driver.findElement(By.id(submitBtn)).click();
	}

	@Test
	public void TC_01_AddNewPostTest() {
		login("dinhlt", "121212");
		driver.get(URL_addNewPost);
		driver.findElement(By.className(title)).sendKeys("Title");
		driver.findElement(By.className(content)).sendKeys("Content");
		driver.findElement(By.className(publishBtn)).click();
	}
  
}
