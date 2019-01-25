package MobileProgrammingLLC.WebFrameTests;


import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import MobileProgrammingLLC.WebFrameResources.Base;

public class Listeners implements ITestListener{
	
	Logger log = LogManager.getLogger(Listeners.class.getName());
	Base b = new Base();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("\n--------------------"+result.getName()+"--------------------\n");
		
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Script '"+result.getName()+"' passed.");
	}

	public void onTestFailure(ITestResult result) {
		// on Failed Test Case, take the screenshot
		log.error("Script '"+result.getName()+"' failed. Dumping screenshot...");
		WebDriver driver = null;
		try {
			Class<?> clazz = result.getTestClass().getRealClass();
			Field field = clazz.getDeclaredField("driver");
			driver = (WebDriver) field.get(result.getInstance());
			Thread.sleep(1000);
		}catch(Exception e) {
			log.error("Screenshot capture interrupted.");
		}
		b.captureScreen(result.getName(), driver);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("\n--------------------"+context.getName()+"--------------------\n");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("\n--------------------"+context.getName()+"--------------------\n");
	}

}
