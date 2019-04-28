package selenium_prj.po;

import java.io.IOException;
import java.util.LinkedHashMap;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BasePageObject;



public class SignUpPO extends BasePageObject{
	
	@FindBy(xpath="//a[@href='/index.html']")
	WebElement home ;
	
	@FindBy(linkText="Sign Up")
	WebElement SignUp ;
	
	
	@FindBy(xpath = "//select[@name='payment_plan_id']")
	WebElement elm1 ;
	
	@FindBy(xpath = "//input[@name ='first_name']")
	WebElement firstname ;
	@FindBy(name="surname")
	WebElement surname;
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="email_confirm")
	WebElement email_confirm;
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="passwordconfirm")
	WebElement passwordconfirm;
	@FindBy(name="agreeTerms")
	WebElement agreeTerms;
	@FindBy(linkText="terms and conditions")
	WebElement terms;
	@FindBy(xpath="//button[@name='submitButton']")
	WebElement submit;
	
	WebDriver driver;

	public SignUpPO(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void cliconsignup(ExtentTest test)
	{
		//SignUp.click();
		clickOnElement(SignUp,"Yes");
		test.log(Status.PASS, "Clicked on sign up link");
		
	}
	
	public void createSign(LinkedHashMap<String, String> testCaseData,ExtentTest test)  throws IOException{
		
		Select s = new Select(elm1);
		s.selectByValue("1");
		//s.selectByIndex(1);
		//s.selectByVisibleText("Free Edition");
		//driver.findElement(By.name("first_name")).sendKeys("varsha");
		
		
		//firstname.sendKeys(testCaseData.get("firstname"));
		typeOnElement(firstname,testCaseData.get("firstname"));
		test.log(Status.PASS, "Successfully inserted value in firstname field :: "+ testCaseData.get("firstname"));
		
		//surname.sendKeys(testCaseData.get("surname"));
		typeOnElement(surname,testCaseData.get("surname"));
		test.log(Status.PASS, "Successfully inserted value in surname field :: "+ testCaseData.get("surname"));
		
		//email.sendKeys(testCaseData.get("email"));
		typeOnElement(email,testCaseData.get("email"));
		test.log(Status.PASS, "Successfully inserted value in email field :: "+ testCaseData.get("email"));
		
		//email_confirm.sendKeys(testCaseData.get("email_confirm"));
		typeOnElement(email_confirm,testCaseData.get("email_confirm"));
		test.log(Status.PASS, "Successfully inserted value in email_confirm field :: "+ testCaseData.get("email_confirm"));
		
		//username.sendKeys(testCaseData.get("username"));
		typeOnElement(username,testCaseData.get("username"));
		test.log(Status.PASS, "Successfully inserted value in username field :: "+ testCaseData.get("username"));
		
		//password.sendKeys(testCaseData.get("password"));
		typeOnElement(password,testCaseData.get("password"));
		test.log(Status.PASS, "Successfully inserted value in password field :: "+ testCaseData.get("password"));
		
		//passwordconfirm.sendKeys(testCaseData.get("passwordconfirm"));
		typeOnElement(passwordconfirm,testCaseData.get("passwordconfirm"));
		test.log(Status.PASS, "Successfully inserted value in passwordconfirm field :: "+ testCaseData.get("passwordconfirm"));
		
		//agreeTerms.click();
		clickOnElement(agreeTerms,"Yes");
		
		test.log(Status.INFO, "Successfully clicked agreeTerms ");
		//submit.click();
		clickOnElement(submit,"Yes");
		
		driver.switchTo().alert().accept();
		//terms.click();
		//test.log(Status.INFO, "Successfully clicked terms");
		backtohome(test);
	}
	
	public void backtohome(ExtentTest test){
		driver.navigate().back();
		test.log(Status.PASS, "Successfully clicked back ");
		//home.click();
		clickOnElement(home,"Yes");
		test.log(Status.INFO, "Successfully clicked home ");
		//SignUp.click();
		clickOnElement(SignUp,"Yes");
		test.log(Status.INFO, "Successfully clicked Sign Up again ");
	}

}
