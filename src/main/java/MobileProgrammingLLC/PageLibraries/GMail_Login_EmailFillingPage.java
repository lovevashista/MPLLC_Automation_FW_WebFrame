package MobileProgrammingLLC.PageLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GMail_Login_EmailFillingPage {
	public GMail_Login_EmailFillingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@aria-label='Email or phone']") WebElement emailTF;
	public WebElement getEmailTF() {
		return emailTF;
	}
	
	@FindBy(xpath="//span[text()='Next']") WebElement userPwdNextBtn;
	public WebElement getNextBtn() {
		return userPwdNextBtn;
	}
	
	@FindBy(css="input[type='password']") WebElement pwdTF;
	public WebElement getPwdTF() {
		return pwdTF;
	}
	
	@FindBy(xpath="//div[text()='Wrong password. Try again or click Forgot password to reset it.']") WebElement errorMsg;
	public WebElement getErrorMsg() {
		return errorMsg;
	}
}
