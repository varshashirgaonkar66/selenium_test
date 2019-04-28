package invokebrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class invokebrowser_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String projectRootpath = System.getProperty("user.dir");//exact project path from ur system
		String chromedriverpath = projectRootpath + "/google_driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverpath); //webdriver path of exe from your project not installed driver (system) path 

		WebDriver driver = new ChromeDriver(); //object of webdriver interface why not chromedriver driver --> you can use it but it will work only for chrome driver, if we want to test browser compatibility we will have write more line for each browser

		driver.get("https://classic.crmpro.com/register/");//get will wait for ur page to load
		//driver.navigate();//does not wait for page to load 

		driver.manage().window().maximize(); //method cascading
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//WebElement elm = driver.findElement(By.id("payment_plan_id"));
		WebElement elm1 = driver.findElement(By.xpath("//select[@name='payment_plan_id']"));
				
		Select s = new Select(elm1);
		s.selectByValue("1");
		//s.selectByIndex(1);
		//s.selectByVisibleText("Free Edition");
		//driver.findElement(By.name("first_name")).sendKeys("varsha");
		driver.findElement(By.xpath("//input[@name ='first_name']")).sendKeys("varsha");
		driver.findElement(By.name("surname")).sendKeys("shirgaonkar");
		driver.findElement(By.name("email")).sendKeys("varsha6.6.1992@gmail.com");
		driver.findElement(By.name("email_confirm")).sendKeys("varsha6.6.1992@gmail.com");
		driver.findElement(By.name("username")).sendKeys("varsha_shirgaonkar");
		driver.findElement(By.name("password")).sendKeys("varsha123");
		driver.findElement(By.name("passwordconfirm")).sendKeys("varsha123");
		driver.findElement(By.name("agreeTerms")).click();
		driver.findElement(By.linkText("terms and conditions")).click();
		//driver.findElement(By.id("submitButton")).click();
		/*driver.findElement(By.id("submitButton"));
		
		String s1 = "Your company information and profile detail";
		WebElement elm2= driver.findElement(By.xpath("//div[contains(text(),'Your company')]"));
		String actualValue=elm2.getText();
		
		if(s1.equals(actualValue)){
			System.out.println("pass");
			System.out.println(actualValue);
		}else{
			System.out.println("fail");
		}*/ 
		
		driver.close();
	}

}
