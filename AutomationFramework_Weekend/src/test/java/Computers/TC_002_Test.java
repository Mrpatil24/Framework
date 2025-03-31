package Computers;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;

import objectRepository.HomePage;

public class TC_002_Test  extends BaseClass{
	@Test
	
	public void ClickOnComputers() throws IOException {

		ExtentTest test = extReport.createTest("ClickOnComputers");
		HomePage hp = new HomePage(driver);
		hp.getComputersLink().click();
		
		Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Computers","Demo Web Shop. Computers is not diaplayed");
		test.log(Status.PASS,"Computers are Displayed");
		wutil.getPhoto(driver);
	}

}
