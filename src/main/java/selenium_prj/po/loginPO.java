package selenium_prj.po;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class loginPO {

	By userName=By.name("username");
	By password=By.name("password");
	By loginbutton=By.xpath("//input[@type='submit']");



	WebDriver driver;

	public loginPO(WebDriver driver) {
		this.driver=driver;
	}

	public void findElementsOnWebpage()
	{
		driver.findElement(userName).sendKeys("varsha_shirgaonkar");
		driver.findElement(password).sendKeys("varsha123");
		driver.findElement(loginbutton).click();
	}

	public void checkPageTitle()
	{
		String s1 = "CRMPRO";
		String elm= driver.getTitle();

		//String actualValue=elm.getText();

		if(s1.equals(elm)){
			System.out.println("pass");
			System.out.println(elm);
		}else{
			System.out.println("fail");
		}
	}

	
}


