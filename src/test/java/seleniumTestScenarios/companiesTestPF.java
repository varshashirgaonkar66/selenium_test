package seleniumTestScenarios;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseTest;
import selenium_prj.po.ExtentTestManager;
import selenium_prj.po.companiesPF;
import selenium_prj.po.companiesPO;
import utility.ScreenShot;

public class companiesTestPF extends BaseTest{

	
	@Test
	public void validateCompanyFunctionality() throws IOException
	{
		ExtentTest test=ExtentTestManager.createTest("New Company Test","This test Case is reponsible for creating a new company","Funtional Test");
		test.log(Status.INFO, "New Company case started");
		
		LinkedHashMap<String, String> testCaseData= datareader.getTestCaseData("company", "1.0");
		test.log(Status.INFO, "test data used :: "+ testCaseData );
		
		//String fileSavePath=projectRootpath+"/Reports/Screenshot";
		companiesPF cp= PageFactory.initElements(driver, companiesPF.class);
		cp.selectNewCompanies();
		//ScreenShot.capture(driver, fileSavePath, "companies");
		//ScreenShot.captureFullPage(driver, reportingDirectory, "companies");
		
		cp.fillForm(projectRootpath, testCaseData, test);
	//	ScreenShot.capture(driver, fileSavePath, "companies");
		ScreenShot.captureFullPage(driver, reportingDirectory, "companies");
		test.log(Status.INFO,"snapshot taken");
	}
	
	// TODO Auto-generated method stub
			
	
}
