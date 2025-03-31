package Books;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;
import objectRepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_010_Test extends BaseClass {
	
	@Test
	public void ClickOnBooks() throws IOException {
		ExtentTest test = extReport.createTest("ClickOnBooks");
		test.log(Status.INFO," Execution Started");
		HomePage hp = new HomePage(driver);
		hp.getBooksLink().click();
		
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Sho","Book page is displayed");
		test.log(Status.PASS,"Book page is displayed");
		wutil.getPhoto(driver);
	}
	

	
}
