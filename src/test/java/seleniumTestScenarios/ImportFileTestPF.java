package seleniumTestScenarios;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;
import selenium_prj.po.ExtentTestManager;
import selenium_prj.po.importFilePF;
import utility.ScreenShot;

public class ImportFileTestPF extends BaseTest{
	
	
	@Test
	public void validateImportFunctionality() throws IOException, InterruptedException
	{
		ExtentTest test = ExtentTestManager.createTest("Import File", "This test case will check for file import", "Functional");
		test.log(Status.INFO, "Starting Import File test case");
		
		
		//String fileSavePath=projectRootpath+"/Reports/Screenshot";
		importFilePF fpf = PageFactory.initElements(driver, importFilePF.class);
		fpf.clickImportLink(projectRootpath, test);
		
		Thread.sleep(3000);
		
		fpf.browseandselect(projectRootpath, test);
		
		String filePath="C:\\Users\\USER\\Documents\\Selenium documents\\usageOf Action Class.docx";
		fpf.selectFileToImport(filePath, projectRootpath, test);
		ScreenShot.captureFullPage(driver, reportingDirectory, "importfile");
		test.log(Status.INFO, "Snapshot captured");
		//tearDown();
		
	}
	
	// TODO Auto-generated method stub
			
}
