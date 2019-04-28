package seleniumTestScenarios;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseTest;
import selenium_prj.po.ExcelReadWrite;
import selenium_prj.po.ExtentTestManager;
import selenium_prj.po.loginPF;
import utility.ScreenShot;

public class loginTestPF extends BaseTest{
	
	
	@Test
	public void validateLoginFunctionality() throws IOException
	{
		
		ExtentTest test=ExtentTestManager.createTest("Login Test","This test Case is reponsible for login functionality","Funtional Test");
		test.log(Status.INFO, "My test case started");
		
		LinkedHashMap<String, String> testCaseData= datareader.getTestCaseData("login", "1.0");
		test.log(Status.INFO, "test data used :: "+ testCaseData );
		
		//String fileSavePath=projectRootpath+"/Reports/Screenshot";
		//setDriver();
		//openUrl();
		//ScreenShot.capture(driver, fileSavePath, "login");
		ScreenShot.captureFullPage(driver, reportingDirectory, "login");
		
		//loginPO lp= new loginPO(driver);
		loginPF lp = PageFactory.initElements(driver, loginPF.class);
		lp.findElementsOnWebpage(projectRootpath,testCaseData,test);
		//ScreenShot.capture(driver, fileSavePath, "login");
		ScreenShot.captureFullPage(driver, reportingDirectory, "login");
		test.log(Status.INFO, "Snapshot taken");
		
		lp.checkPageTitle(test);
		
		
		//ScreenShot.capture(driver, fileSavePath, "login");
		ScreenShot.captureFullPage(driver, reportingDirectory, "login");
		test.log(Status.INFO, "Snapshot taken");
	}
	
	// TODO Auto-generated method stub
			
}
