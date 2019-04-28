package selenium_prj.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class companiesPO {

	
	By companiestab = By.xpath("//a[@title='Companies']");
	By newcompany = By.xpath("//a[@title='Companies']/following::li/a[@title='New Company']");
	By category = 	By.xpath("//select[@name='category']/child::option");
	
	
	WebDriver driver;

	public companiesPO(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectNewCompanies()
	{
		driver.switchTo().frame("mainpanel");//mainpanel
		//WebElement elm1 = driver.findElement(By.xpath("//td[@class='logo_text']"));
		//String actualValue=elm1.getText();
		//System.out.println(actualValue);

		WebElement welm = driver.findElement(companiestab);
		Actions a = new Actions(driver);
		a.moveToElement(welm).build().perform();//moves, build created object (build interacts with object), then performs the action to move
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(newcompany).click();
	}
	
	public void selectCategory()
	{
		List <WebElement> lilist =driver.findElements(category);//contains the webelements, html page elements; afterwards directly perform any operation like click
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
