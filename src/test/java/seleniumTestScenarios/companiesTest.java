package seleniumTestScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Base.BaseTest;
import selenium_prj.po.companiesPO;

public class companiesTest extends BaseTest{

	
	@Test
	public void validateCompanyFunctionality()
	{
		companiesPO cp= new companiesPO(driver);
		cp.selectNewCompanies();
		cp.selectCategory();
	}
	
	// TODO Auto-generated method stub
			
	
}
