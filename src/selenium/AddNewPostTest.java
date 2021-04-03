package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddNewPostTest extends BaseTest {
	
	String URL_addNewPost ="http://localhost/wordpress/wp-admin/post-new.php";
	String user_login = "user_login";
	String user_pass = "user_pass";
	String submitBtn = "wp-submit";
	String title = "//textarea[@id='post-title-0']";
	String content = "//div[@class = 'block-editor-writing-flow']/div/p";
	String publishBtn ="//button[contains(text(),'Publish')]";

	public void login(String user, String pass) {
		driver.findElement(By.id(user_login)).sendKeys(user);
		driver.findElement(By.id(user_pass)).sendKeys(pass);
		driver.findElement(By.id(submitBtn)).click();
	}

	@Test
	public void TC_01_AddNewPostTest() {
		login("dinhlt", "121212");
		driver.get(URL_addNewPost);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(title)).sendKeys("This is the Title");
//		driver.switchTo().frame("block-editor-block-list__layout is-root-container");
		WebElement body = driver.findElement(By.xpath(content));
//		driver.switchTo().defaultContent();
		WebElement publishBtn1 = driver.findElement(By.xpath(publishBtn));
		Actions action =new Actions(driver);
		action.moveToElement(body).click().sendKeys(body,"This is the body").build();
//		action.moveToElement(publishBtn1).click().build().perform();
		
	}
  
}
