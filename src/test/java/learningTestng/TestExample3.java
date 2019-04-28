package learningTestng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class TestExample3 {

	@BeforeSuite(groups={"Regression"})
	public static void funct()
	{
			System.out.println("Before Suite");
		
	}
	
	
	
	@AfterSuite(groups={"Regression"})
	public static void testaftersuite()
	{
		
		System.out.println("After Suite");
		
	}
	
	
	
}
