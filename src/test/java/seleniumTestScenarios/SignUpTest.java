package seleniumTestScenarios;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseTest;
import selenium_prj.po.ExtentTestManager;
import selenium_prj.po.SignUpPO;
import utility.ScreenShot;


public class SignUpTest extends BaseTest{
	
	@Test
	public void validateSignupFunctionality() throws IOException
	{
		//String fileSavePath=projectRootpath+"/Reports/Screenshot";
		ExtentTest test=ExtentTestManager.createTest("SignUp Test","This test Case is reponsible for SignUp functionality","Funtional Test");
		test.log(Status.INFO, "My test case started");
		
		setDriver();
		test.log(Status.PASS,"Driver set");
		
		openUrl();
		test.log(Status.PASS, "Url Opened");
		
		//LinkedHashMap<String, String> testcasedata= datareader.getTestCaseData("signup", "1.0");
		
		LinkedHashMap<String, LinkedHashMap<String, String>> sheetDataMap=datareader.getSheetData("signup");
		Iterator<String> itr=sheetDataMap.keySet().iterator();
		
		while(itr.hasNext()){
			String key=itr.next();
			LinkedHashMap<String, String> testcasedata=sheetDataMap.get(key);
			
			test.log(Status.INFO, "test data used :: "+ testcasedata );
			
			SignUpPO sp = PageFactory.initElements(driver, SignUpPO.class);
			sp.cliconsignup(test);
			
			//ScreenShot.capture(driver, fileSavePath, "signup");
			//ScreenShot.captureFullPage(driver, reportingDirectory, "signup");
			//test.log(Status.INFO, "Screenshot taken");
			
			sp.createSign(testcasedata, test);
			
			//ScreenShot.capture(driver, fileSavePath, "signup");
			ScreenShot.captureFullPage(driver, reportingDirectory, "signup");
			test.log(Status.INFO, "Screenshot taken");
			
			//sp.backtohome(test);
			
			//ScreenShot.capture(driver, fileSavePath, "signup");
			//ScreenShot.captureFullPage(driver, reportingDirectory, "signup");
			//test.log(Status.INFO, "Screenshot taken");
		}
	}

}
