package MobileProgrammingLLC.WebFrameTests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MobileProgrammingLLC.PageLibraries.Rediff_Login_MainPage;
import MobileProgrammingLLC.WebFrameResources.Base;

public class Rediff_Login{
	WebDriver driver = null;
	Properties config = new Properties();
	Properties locators = new Properties();
	Properties data = new Properties();
	Logger log = LogManager.getLogger(Rediff_Login.class.getName());

	Rediff_Login_MainPage rlp;
	Base b = new Base();
	
	@BeforeClass
	public  void initConfigs() {
		locators = b.loadLocators();
		config = b.loadConfig();
		data = b.loadData();
		driver = b.invokeBrowser(config.getProperty("browser"));
		b.navigateToSite(driver, config.getProperty("rediff_url"));
		rlp = new Rediff_Login_MainPage(driver);
	}
	
	@Test(dataProvider="getData")
	public  void rediff_enterUser(String uname, String pass) {
		b.flash(rlp.getRUserNameTF());
		b.enterContentInto(rlp.getRUserNameTF(), uname);
		b.flash(rlp.getRPasswordTF());
		b.enterContentInto(rlp.getRPasswordTF(), pass);
		b.flash(rlp.getRRememberChkBox());
		b.clickOn(rlp.getRRememberChkBox());
		b.flash(rlp.getRSubmitBtn());
		b.clickOn(rlp.getRSubmitBtn());
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "aaa@aaa.com";
		obj[0][1] = "pass111";
		obj[1][0] = "bbb@bbb.com";
		obj[1][1] = "pass222";
		obj[2][0] = "ccc@ccc.com";
		obj[2][1] = "pass333";
		
		return obj;
	}
	
//	@Test(dependsOnMethods= {"rediff_enterUser"})
//	public  void rediff_enterPassword() {
//		rlp.getRPasswordTF().sendKeys(data.getProperty("password"));
//	}
//	
//	@Test(dependsOnMethods= {"rediff_enterPassword"})
//	public  void rediff_UncheckRememberBox() {
//		rlp.getRRememberChkBox().click();
//	}
//	
//	@Test(dependsOnMethods= {"rediff_UncheckRememberBox"})
//	public  void rediff_ClickSubmitButton() {
//		rlp.getRSubmitBtn().click();
//	}
	
	@AfterClass
	public  void tearDown() {
		b.quitDriver(driver);
	}
}
