package seleniumTestScenarios;

import org.testng.annotations.Test;

import Base.BaseTest;
import selenium_prj.po.loginPO;

public class loginTest extends BaseTest{
	
	
	@Test
	public void validateLoginFunctionality()
	{
		/*setDriver();
		openUrl();*/
		loginPO lp= new loginPO(driver);
		lp.findElementsOnWebpage();
		lp.checkPageTitle();
		
	}
	
	// TODO Auto-generated method stub
			
}
