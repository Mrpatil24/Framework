package genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
				
	}
	public void rightclick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	

	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source,target).perform();
	}
	
	public void selectByIndex(WebElement element,int index) {
	Select sct = new Select(element);
	sct.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element,String value) {
		Select sct = new Select(element);
		sct.selectByValue(value);
		}
	
	public void selectByVisible(WebElement element,String value) {
		Select sct = new Select(element);
		sct.deselectByVisibleText(value);
		}
	public void switchtoFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchtoFrame(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
	}
	public void switchtoFrame(WebDriver driver,WebElement element)  {
		driver.switchTo().frame(element);
	}
	
	public void switchtoAlertAndAccept(WebDriver driver)  {
		driver.switchTo().alert().accept();
	}
	public void switchtoAlertAndCancel(WebDriver driver)  {
		driver.switchTo().alert().dismiss();
	}
	
	public void getPhoto(WebDriver driver) throws IOException {
		JavaUtility jutl = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+jutl.getSystemtime() + ".png");
		FileHandler.copy(temp, dest);
	}	
}
