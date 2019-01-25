package MobileProgrammingLLC.PageLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rediff_Login_MainPage {
	public Rediff_Login_MainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='login1']") WebElement RUserNameTF;
	public WebElement getRUserNameTF() {
		return RUserNameTF;
	}
	
	@FindBy(css="input#password") WebElement RPasswordTF;
	public WebElement getRPasswordTF() {
		return RPasswordTF;
	}
	
	@FindBy(id="remember") WebElement RRememberChkBox;
	public WebElement getRRememberChkBox() {
		return RRememberChkBox;
	}
	
	@FindBy(css="input[type='submit']") WebElement RSubmitBtn;
	public WebElement getRSubmitBtn() {
		return RSubmitBtn;
	}
}
