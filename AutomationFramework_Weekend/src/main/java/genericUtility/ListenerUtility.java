package genericUtility;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility  extends BaseClass implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
	test=extReport.createTest(result.getName());
	test.log(Status.INFO, "Execution Started");
	}

	
	
		@Override
	public void onTestFailure(ITestResult result) {
	test.log(Status.FAIL,"Book page is not displayed");
	TakesScreenshot ts = (TakesScreenshot) driver;
	 String Screenshot = ts.getScreenshotAs(OutputType.BASE64);
	 test.addScreenCaptureFromBase64String(Screenshot);
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			wutil.getPhoto(driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}



}
