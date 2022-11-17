package HomeModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.JavaScriptExcecutionUtility;

public class TestCase extends BaseClass{
	
	@Test
	public void testcaseDescription() {
		WebElement email = driver.findElement(By.id("Email"));
		WebElement password = driver.findElement(By.name("Password"));
		WebElement login = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		
		JavaScriptExcecutionUtility.enterthedata(email, "teja");
		JavaScriptExcecutionUtility.enterthedata(password, "ravi");
		JavaScriptExcecutionUtility.clickonElement(login);
		
	}
	
}
