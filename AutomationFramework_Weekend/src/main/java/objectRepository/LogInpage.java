package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInpage {
	@FindBy (id = "Email")
	private WebElement EmailID;
	
	@FindBy (id = "Password")
	private WebElement PasswordTextfield;
	
	@FindBy (xpath = "//input[@value='Log in']")
	private WebElement LoginButton;
	
	 public WebElement getLoginBtn() {
		 return LoginButton;
		 
	 }
	public LogInpage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getEmailID() {
		return EmailID;
	}
	public WebElement getPasswordTextfield() {
		return PasswordTextfield;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	

}
