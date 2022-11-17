package GenericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentSparkReporter reporter;
	public static ExtentReports report;
	public static ExtentTest logger;
	

	@BeforeSuite (alwaysRun = true)
	public void lunchingBrowser() {
		reporter=new ExtentSparkReporter("./Reports/Stark.html");
		report=new ExtentReports();
		report.attachReporter(reporter);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@BeforeTest(alwaysRun = true)
	public void beforetest() {
		logger=report.createTest("testcases1");
	}
	@BeforeClass(alwaysRun = true)
	public void navigatingtoapp() {
		driver.get("https://demowebshop.tricentis.com/login");
		logger.log(Status.INFO , "Successfully navigated to applicaton");
	}
	@AfterMethod(alwaysRun = true)
	public void checkingFailure(ITestResult result) throws IOException {
		if (result.getStatus()==result.FAILURE) {
			String path = takngscreen.takingScreenshot(result.getName());
			System.out.println(result.getName());
			logger.log(Status.FAIL, "the test script "+result.getName()+" is failed");
			logger.addScreenCaptureFromPath(path);
			
			/*
			 * ScreenShotUtility.takngscreen(result.getName());
			 * System.out.println(result.getName());
			 */
		}
	}
	@AfterClass
	public void logginout() {
		System.out.println("logged out");
	}
	@AfterSuite
	public void colsethebrowser() {
		driver.quit();
	}
}
