import java.util.concurrent.TimeUnit;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;



public class logintofreecrm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String projectRootpath = System.getProperty("user.dir");//exact project path from ur system
		String chromedriverpath = projectRootpath + "/google_driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverpath); //webdriver path of exe from your project not installed driver (system) path 

		WebDriver driver = new ChromeDriver(); //object of webdriver interface why not chromedriver driver --> you can use it but it will work only for chrome driver, if we want to test browser compatibility we will have write more line for each browser

		driver.get("https://classic.crmpro.com/index.html");//get will wait for ur page to load

		driver.manage().window().maximize(); //method cascading
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("varsha_shirgaonkar");
		driver.findElement(By.name("password")).sendKeys("varsha123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//driver.navigate().refresh();

		//driver.gettitle
		//WebElement elm= driver.findElement(By.xpath("//title[text()='CRMPRO']"));
		String s1 = "CRMPRO";
		String elm= driver.getTitle();

		//String actualValue=elm.getText();

		if(s1.equals(elm)){
			System.out.println("pass");
			System.out.println(elm);
		}else{
			System.out.println("fail");
		}

		//frame example
		driver.switchTo().frame("mainpanel");//mainpanel
		//WebElement elm1 = driver.findElement(By.xpath("//td[@class='logo_text']"));
		//String actualValue=elm1.getText();
		//System.out.println(actualValue);

		WebElement welm = driver.findElement(By.xpath("//a[@title='Companies']"));
		Actions a = new Actions(driver);
		a.moveToElement(welm).build().perform();//moves, build created object (build interacts with object), then performs the action to move
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@title='Companies']/following::li/a[@title='New Company']")).click();


		List <WebElement> lilist =driver.findElements(By.xpath("//select[@name='category']/child::option"));//contains the webelements, html page elements; afterwards directly perform any operation like click
		for (int i = 0; i < lilist.size();i++)
		{
			WebElement lelm = lilist.get(i);
			System.out.println(lelm.getText());

			String s2 = "Partner";

			if(lelm.getText().equalsIgnoreCase(s2) )
			{
				lelm.click();
			}


		}


	}

}
