package learningTestng;

import org.testng.annotations.*;


public class OrderOfExecution {
	
	@BeforeMethod
	public static void beforetest()
	{
		System.out.println("BeforeMethod annotation is used to execute a method before every method");
	}

	@AfterMethod
	public static void aftertest()
	{
		System.out.println("AfterMethod annotation is used to execute a method after every method");
	}
	@Test
	public static void multiply() {
		int num1 = 2, num2 = 3;
		int multiply = num1 * num2;
		System.out.println("multiplication:" + num1 + "*" + num2 + "=" + multiply);
		System.out.println("Tests are executed in alphabetical order. "
				+ "Methods starting with small letters are executed after the methods starting with capital letters");
		System.out.println(" ");
	}

	@Test
	public static void B() {
		System.out.println("B");
	}

	@Test
	public static void add() {
		System.out.println("addition");
	}

	@Test
	public static void Subtract() {
		System.out.println("Subtraction");
		System.out
				.println("Test are executed in alphabetical order if the order of execution is not mentioned. Methods starting with capital letters are first invoked in alphabetical order");
		System.out.println("");
	}

	@Test
	public static void C() {
		System.out.println("C");
	}

	@Test
	public static void fact() {
		int i, fact = 1;
		int n = 5;
		for (i = 1; i <= n; i++) {
			fact = fact * i;
		}
		System.out.println("factorial of a number is " + fact);
	}
}
