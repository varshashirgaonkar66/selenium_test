package learningTestng;

import org.testng.annotations.Test;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestExample1 {


	//@Test(enabled=false)
	@Test(alwaysRun=true)
	public static void sum()
	{
		int sum = 5 + 10;
		System.out.println("sum of data is "+sum);
	}

	@Test(priority = 1 , dependsOnMethods="testdata")
	public static void tultiple()
	{
		int mult = 4*5;
		System.out.println("Multiplication of 4*5 is "+ mult);
	}


		
	@Test(priority = 3,groups={"Sanity","Regression"})
	public static void subtract()
	{
		int sub = 10 - 5;
		System.out.println("subtraction of 10 and 5 is "+sub);
	}

	
	@Test(priority = 1 , dependsOnMethods="sum")
	public static void mestMultiplyAdd()
	{
		int add = 10 + 2 + 4;
		System.out.println(" addition of 10,2 and 4 is "+add);
	}

	@BeforeGroups(groups={"Sanity"})
	public static void beforegroup()
	{
		System.out.println("before group");
	}
	
	@AfterGroups(groups={"Sanity"})
	public static void aftergroup()
	{
		System.out.println("after group");
	}
	
	@Test(priority = 5,groups={"Sanity"})
	public static void test1()
	{
		System.out.println("Test1 again");
	}

	@Parameters("SIT")
	@Test(priority = 5,groups={"Sanity"})
	public static void atest2(String receivingParam)
	{
		System.out.println(receivingParam);
		System.out.println("Test2 again");
	}

	@BeforeMethod
	public static void beforediv()
	{
		System.out.println("executes before div");
	}
	
	
	@Test
	public static void div()
	{
		int div = 10/2;
		System.out.println("division of 10 and 2 is "+div);
	}


	@AfterMethod
	public static void afterdiv()
	{
		System.out.println("after div");
	}
	
	//@Test(enabled=false)
	@Test
	public static void testdata()
	{
		System.out.println("Learning testng");
	}
	
}
