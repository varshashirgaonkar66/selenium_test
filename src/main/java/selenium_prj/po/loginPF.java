package selenium_prj.po;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BasePageObject;
import utility.ScreenShot;

public class loginPF extends BasePageObject{
	//implementation 1
	//@FindBy(name="username")
	//WebElement username;
	
	//implementation 2
	@FindBy(how=How.NAME,using="username")
	WebElement username;
	
	//@FindBy(name="password")
	//WebElement password;
	
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	
//	@FindBy(xpath="//input[@type='submit']")
	//WebElement loginbutton; 
	
	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	WebElement loginbutton;
	
	WebDriver driver;
	
	
	

	public loginPF(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public void findElementsOnWebpage(String projectRootpath, LinkedHashMap<String, String> testCaseData,ExtentTest test) throws IOException
	{
		String fileSavePath=projectRootpath+"/Reports/Screenshot";
		//username.sendKeys(testCaseData.get("username"));
		typeOnElement(username,testCaseData.get("username"));
		
		test.log(Status.PASS, "Successfully inserted value in user name field :: "+ testCaseData.get("username"));
		//password.sendKeys(testCaseData.get("password"));
		typeOnElement(password,testCaseData.get("password"));
		
		test.log(Status.PASS, "Successfully inserted value in password name field :: "+ testCaseData.get("password"));
		ScreenShot.capture(driver, fileSavePath, "login");
		test.log(Status.INFO, "Snapshot taken ");
		
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		//loginbutton.click();
		clickOnElement(loginbutton,"Yes");
		test.log(Status.PASS, "Successfully clicked on login button");
	}

	public void checkPageTitle(ExtentTest test)
	{
		String s1 = "CRMPRO";
		String elm= driver.getTitle();
		test.log(Status.INFO, "Fetching Page Title");
		
		//String actualValue=elm.getText();

		if(s1.equals(elm)){
			System.out.println("pass");
			System.out.println(elm);
			test.log(Status.PASS, "Successfully matched Page Title with CRMPRO");
		}else{
			System.out.println("fail");
			test.log(Status.FAIL, "Unable to match Page Title with CRMPRO");
		}
	}

	
}


