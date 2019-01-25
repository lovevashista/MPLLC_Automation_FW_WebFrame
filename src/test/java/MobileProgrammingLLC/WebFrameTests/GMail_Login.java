package MobileProgrammingLLC.WebFrameTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MobileProgrammingLLC.PageLibraries.GMail_Login_EmailFillingPage;
import MobileProgrammingLLC.PageLibraries.GMail_Login_LandingPage;
import MobileProgrammingLLC.WebFrameResources.Base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GMail_Login{
	WebDriver driver;
	Properties config = new Properties();
	Properties locators = new Properties();
	Properties data = new Properties();
	Logger log = LogManager.getLogger(GMail_Login.class.getName());
	GMail_Login_LandingPage lp;
	GMail_Login_EmailFillingPage efp;
	Base b = new Base();
	
	@BeforeClass
	public  void initConfigs() {
		log.info("Initializing Configurations...");
		locators = b.loadLocators();
		config = b.loadConfig();
		data = b.loadData();
		driver = b.invokeBrowser(config.getProperty("browser"));
		b.navigateToSite(driver, config.getProperty("url"));
		lp = new GMail_Login_LandingPage(driver);
		efp = new GMail_Login_EmailFillingPage(driver);
		log.info("Configurations Successfully Initialized.");
	}

	@Test
	public void enterUserName() {
		b.flash(lp.getSignInLink());
		b.clickOn(lp.getSignInLink());
		b.waitFor(By.xpath(locators.getProperty("emailTF")));
		b.flash(efp.getEmailTF());
		b.enterContentInto(efp.getEmailTF(), data.getProperty("username"));
		b.flash(efp.getNextBtn());
		b.clickOn(efp.getNextBtn());
	}
	
	@Test(dependsOnMethods= {"enterUserName"})
	public void enterPassword() {
		b.waitForSometime();
		b.flash(efp.getPwdTF());
		b.enterContentInto(efp.getPwdTF(), data.getProperty("password"));
		b.flash(efp.getNextBtn());
		b.clickOn(efp.getNextBtn());
	}
	
	@Test(dependsOnMethods= {"enterPassword"})
	public  void verifyErrorMesssage() {
		b.waitFor(By.xpath(locators.getProperty("errorMsgLocator")));
		b.flash(efp.getErrorMsg());
		b.compareContent(efp.getErrorMsg(), data.getProperty("errorMsg"));
	}
	
	@AfterClass
	public  void tearDown() {
		log.debug("Tearing Down Configurations...");
		b.quitDriver(driver);
		log.info("Configurations Successfully Teared Down.\n");
	}
}