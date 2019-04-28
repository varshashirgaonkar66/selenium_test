package learningTestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestExample2 {

	//executes tests in alphabetical order --> add,binary,hello,printstar
	
	@BeforeClass(groups={"Regression"})
	public static void beforeclasstest()
	{
		System.out.println("Before class");
	}
	

	@Test(groups={"Regression"})
	public static void printstar()
	{
		int n = 10 ;
		for (int i = 0; i< n ; i++ )
		{
			for (int j = 0; j<i; j++)
			{
				System.out.print("*");
				
			}
			System.out.println(" ");
		}
	}

	@AfterClass(groups={"Regression"})
	public static void afterclasstest()
	{
		System.out.println("AFter class");
	}
	
	@Test	
	public static void add()
	{
		int a  = 10,b=50 ;
		int add = a+b;
		System.out.println("Add: "+a+"and"+b+"="+add);
	}
	
	@Test
	public static void hello()
	{
		System.out.println("Hello test ng");
	}
	
	@Parameters("SIT")
	@Test(groups={"Sanity"})
	public static void binary(String receiveParam)
	{
		System.out.println("Parameter value passed by testng.xml is "+receiveParam);
		System.out.println("binary: 010101110");
	}
	
	//upper case alphabetical order executes first --> U is after a but it was executed first as it in upper case where add is in lowercase
	//S is before U soStringlength function executes before Uppercase
	@Test
	public static void Uppercase()
	{
		System.out.println("Method names in upper case are executed first");
	}
	
	@Test(groups={"Regression"})
	public static void Stringlength()
	{
		String a = "hi";
		String b = "varsha";
		System.out.println("length of a is "+ a.length());
		System.out.println("length of b is "+ b.length());
	}
	
	
	
}
