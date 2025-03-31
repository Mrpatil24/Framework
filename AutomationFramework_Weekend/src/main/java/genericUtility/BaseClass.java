package genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.HomePage;
import objectRepository.LogInpage;
import objectRepository.WelcomePage;

public class BaseClass {                                        //declaring as global variable
	public static ExtentReports extReport;                        
	public static WebDriver driver;
	public static ExtentTest test;
	
									                        	//Create a object instance of class from other utilities
	public JavaUtility jutil = new JavaUtility();
	public WebdriverUtility wutil= new WebdriverUtility();
	public FileUtility futil = new FileUtility();
	
	@BeforeSuite
	public void reportconfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_reports/extentreport_" +jutil.getSystemtime()+".html");
		extReport = new ExtentReports();
		extReport.attachReporter(spark);
		
	}
	@BeforeClass
	public void openBrowser() throws IOException {
		driver = new ChromeDriver();
		wutil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(futil.getDataFromProperty("url"));		
	
	}
	@BeforeMethod 
	public void login() throws IOException {
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink();
		
		LogInpage lp = new LogInpage(driver);
		lp.getEmailID().sendKeys(futil.getDataFromProperty("email"));
		lp.getPasswordTextfield().sendKeys(futil.getDataFromProperty("password"));
		lp.getLoginBtn().click();
		
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.getLogoutLink().click();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	
	@AfterSuite
	public void reportBackUp() {
		extReport.flush();
	}
}
