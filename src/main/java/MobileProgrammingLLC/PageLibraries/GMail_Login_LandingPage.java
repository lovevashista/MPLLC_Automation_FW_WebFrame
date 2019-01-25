package MobileProgrammingLLC.PageLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GMail_Login_LandingPage {
	public GMail_Login_LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a.gmail-nav__nav-link.gmail-nav__nav-link__sign-in") WebElement signInLink;
	public WebElement getSignInLink() {
		return signInLink;
	}
}
