package invokebrowser;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class rediffmail_invokepage {
	
	public static void main(String[] args) {
		
		String projectRootpath = System.getProperty("user.dir");//exact project path from ur system
		String chromedriverpath = projectRootpath + "/google_driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverpath); //webdriver path of exe from your project not installed driver (system) path 

		WebDriver driver = new ChromeDriver(); //object of webdriver interface why not chromedriver driver --> you can use it but it will work only for chrome driver, if we want to test browser compatibility we will have write more line for each browser

		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");//get will wait for ur page to load

		driver.manage().window().maximize(); //method cascading
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.linkText("terms and conditions")).click();
		driver.findElement(By.linkText("privacy policy")).click();
		
		
		Set<String> windowsIds = driver.getWindowHandles();
		Iterator<String> itr= windowsIds.iterator();
		
		while (itr.hasNext())
		{
			String wid = itr.next(); // stores id's
			System.out.println(wid);//prints id's
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			System.out.println(title);
			
			if(title.equalsIgnoreCase("Rediffmail: Terms and Conditions"))
			{
				driver.findElement(By.xpath("//div[@class='floatR']/child::input[@type='button']")).click();
						}
			
			if(title.equalsIgnoreCase("Welcome to rediff.com"))
			{
				driver.findElement(By.linkText("http://support.rediff.com/")).click();
				driver.close();
			}
		}
		
///need to go back and get the windows id of the main page has iterator has already gone ahead, also iterator does not have the new customer care page that was opened
//so we have to get the id to get the the id of the page then close it		
		Set<String> windowsIds1 = driver.getWindowHandles();
		Iterator<String> itr1= windowsIds1.iterator();
		
		while(itr1.hasNext())
		{
			String wid1 = itr1.next();
			System.out.println(wid1);//prints id's
			driver.switchTo().window(wid1);
			String new_title = driver.getTitle();
			System.out.println(new_title);
			
			if(new_title.equalsIgnoreCase("Rediffmail Free Unlimited Storage"))
			{
				driver.close();
			}
			
			if(new_title.equalsIgnoreCase("Welcome to Rediff Customer Care"))
			{
				driver.close();
			}
			}
		
			
	}
}
