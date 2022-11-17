package GenericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExcecutionUtility extends BaseClass {
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public static void clickonElement (WebElement Element) {	
		js.executeScript("arguments[0].click();", Element);
	}
	
	public static void enterthedata( WebElement Element, String data) {
		js.executeScript("arguments[0].value='"+data+"';", Element);
	}
}
