package selenium_prj.po;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BasePageObject;

public class companiesPF extends BasePageObject{

	
	@FindBy(xpath = "//a[@title='Companies']")
	WebElement companiestab ;
		
	@FindBy(xpath = "//a[@title='Companies']/following::li/a[@title='New Company']")
	WebElement newcompany;
	@FindBy(xpath="//select[@name='category']/child::option")
	WebElement category1;
	
	@FindBy(xpath="//input[@name='company_name']")
	WebElement company;
	@FindBy(xpath="//input[@name='industry']")
	WebElement industry;
	@FindBy(xpath="//input[@id='annual_revenue']")
	WebElement anl_revenue;
	@FindBy(xpath="//input[@id='num_of_employees']")
	WebElement num_of_emps; 
	
	By status =By.xpath("//select[@name='status']/child::option");
	By category = 	By.xpath("//select[@name='category']/child::option");
	By priority = By.xpath("//select[@name='priority']/child::option");
	By source = By.xpath("//select[@name='source']/child::option");
	
	@FindBy(xpath="//input[@name='identifier']")
	WebElement ident;
	@FindBy(xpath="//input[@name='vat_number']")
	WebElement vat_num;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath="//input[@id='fax']")
	WebElement fax;
	@FindBy(xpath="//input[@id='website']")
	WebElement website;
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	@FindBy(xpath="//input[@id='symbol']")
	WebElement symbol;
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement parent_lookup;
	
	@FindBy(xpath="//input[@name='address_title']")
	WebElement addr_title;
	By addr_type = By.xpath("//select[@name='type']/child::option");
	@FindBy(xpath="//textarea[@name='address']")
	WebElement address;
			
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	@FindBy(xpath="//input[@name='postcode']")
	WebElement pincode;
	@FindBy(xpath="//input[@name='country']")
	WebElement country;
	@FindBy(xpath="//input[@id='tags']")
	WebElement tags;
	@FindBy(xpath="//textarea[@id='service']")
	WebElement desc;
	@FindBy(xpath="//input[@type='button' and @value = 'Max']")
	WebElement max_desc;
	@FindBy(xpath="//input[@type='button' and @value = 'Min']/ancestor::tr/following-sibling::tr/descendant::input")
	WebElement save;
	
	WebDriver driver;

	public companiesPF(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void selectNewCompanies()
	{
		driver.switchTo().frame("mainpanel");//mainpanel
		//WebElement elm1 = driver.findElement(By.xpath("//td[@class='logo_text']"));
		//String actualValue=elm1.getText();
		//System.out.println(actualValue);

		WebElement welm = companiestab;
		Actions a = new Actions(driver);
		a.moveToElement(welm).build().perform();//moves, build created object (build interacts with object), then performs the action to move
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newcompany.click();
	}
	
	public void fillForm(String projectRootpath, LinkedHashMap<String, String> testCaseData,ExtentTest test)
	{
		//String fileSavePath=projectRootpath+"/Reports/Screenshot";
		//company.sendKeys("Test Company");
		//company.sendKeys(testCaseData.get("company"));
		typeOnElement(company,testCaseData.get("company"));
		test.log(Status.PASS, "Successfully inserted value in company field :: "+ testCaseData.get("company"));
		
		//industry.sendKeys("Test Industry");
		//industry.sendKeys(testCaseData.get("industry"));
		typeOnElement(industry,testCaseData.get("industry"));
		test.log(Status.PASS, "Successfully inserted value in industry field ::"+testCaseData.get("industry"));
		
		//anl_revenue.sendKeys("10000000");
		//anl_revenue.sendKeys(testCaseData.get("anl_revenue"));
		typeOnElement(anl_revenue,testCaseData.get("anl_revenue"));
		test.log(Status.PASS, "Successfully inserted value in annual revenue field ::"+testCaseData.get("anl_revenue"));
		
		//num_of_emps.sendKeys("1000");
		//num_of_emps.sendKeys(testCaseData.get("num_of_emps"));
		typeOnElement(num_of_emps,testCaseData.get("num_of_emps"));
		test.log(Status.PASS, "Successfully inserted value in num_of_emps field ::"+testCaseData.get("num_of_emps"));
		
		
		//selectStatus("Active");
		selectStatus(testCaseData.get("status"));
		test.log(Status.PASS, "Successfully selected value from status dropdown ::"+testCaseData.get("status"));
		
		//selectCategory("Partner");
		selectCategory(testCaseData.get("Category"));
		test.log(Status.PASS, "Successfully selected value from Category dropdown ::"+testCaseData.get("Partner"));
		
		//selectPriority("Medium");
		selectPriority(testCaseData.get("Priority"));
		test.log(Status.PASS, "Successfully selected value from Priority dropdown ::"+testCaseData.get("Priority"));
		
		//selectSource("Email");
		selectSource(testCaseData.get("Source"));
		test.log(Status.PASS, "Successfully selected value from Source dropdown ::"+testCaseData.get("Source"));
		
		
		//ident.sendKeys("Test1245");
		//ident.sendKeys(testCaseData.get("identity"));
		typeOnElement(ident,testCaseData.get("identity"));
		test.log(Status.PASS, "Successfully inserted value in identity field ::"+testCaseData.get("identity"));
		
		//vat_num.sendKeys("12546");
		//vat_num.sendKeys(testCaseData.get("vat_num"));
		typeOnElement(vat_num,testCaseData.get("vat_num"));
		test.log(Status.PASS, "Successfully inserted value in vat number field ::"+testCaseData.get("vat_num"));
		
		//phone.sendKeys("8245765414");
		//phone.sendKeys(testCaseData.get("phone"));
		typeOnElement(phone,testCaseData.get("phone"));
		test.log(Status.PASS, "Successfully inserted value in phone field ::"+testCaseData.get("phone"));
		
		
		//fax.sendKeys("47895231");
		//fax.sendKeys(testCaseData.get("fax"));
		typeOnElement(fax,testCaseData.get("fax"));
		test.log(Status.PASS, "Successfully inserted value in fax field ::"+testCaseData.get("fax"));
		
		
		//website.sendKeys("test_website");
		//website.sendKeys(testCaseData.get("website"));
		typeOnElement(website,testCaseData.get("website"));
		test.log(Status.PASS, "Successfully inserted value in website field ::"+testCaseData.get("website"));
		
		//email.sendKeys("testmail@gmail.com");
		//fax.sendKeys(testCaseData.get("email"));
		typeOnElement(fax,testCaseData.get("fax"));
		test.log(Status.PASS, "Successfully inserted value in email field ::"+testCaseData.get("email"));
		
		//symbol.sendKeys("testsym");
		//symbol.sendKeys(testCaseData.get("symbol"));
		typeOnElement(symbol,testCaseData.get("symbol"));
		test.log(Status.PASS, "Successfully inserted value in symbol field ::"+testCaseData.get("symbol"));
		
		//parent_lookup.sendKeys("test");
		//parent_lookup.sendKeys(testCaseData.get("parent_lookup"));
		typeOnElement(parent_lookup,testCaseData.get("parent_lookup"));
		test.log(Status.PASS, "Successfully inserted value in parent_lookup field ::"+testCaseData.get("parent_lookup"));
		
		//addr_title.sendKeys("Work");
		//addr_title.sendKeys(testCaseData.get("addr_title"));
		typeOnElement(addr_title,testCaseData.get("addr_title"));
		test.log(Status.PASS, "Successfully inserted value in address_title field ::"+testCaseData.get("addr_title"));
		
		//selectAddrType("Billing Address");
		selectAddrType(testCaseData.get("addr_title"));
		test.log(Status.PASS, "Successfully selected value from selectAddrType field ::"+testCaseData.get("addr_title"));
		
		//address.sendKeys("Opposite tata motors,Jaipur");
		//address.sendKeys(testCaseData.get("address"));
		typeOnElement(address,testCaseData.get("address"));
		test.log(Status.PASS, "Successfully inserted value in address field ::"+testCaseData.get("address"));
		
		//city.sendKeys("Jaipur");
		//city.sendKeys(testCaseData.get("city"));
		typeOnElement(city,testCaseData.get("city"));
		test.log(Status.PASS, "Successfully inserted value in city field ::"+testCaseData.get("city"));
		
		//state.sendKeys("Rajasthan");
		//state.sendKeys(testCaseData.get("state"));
		typeOnElement(state,testCaseData.get("state"));
		test.log(Status.PASS, "Successfully inserted value in state field ::"+testCaseData.get("state"));
		
		//pincode.sendKeys("477789");
		//pincode.sendKeys(testCaseData.get("pincode"));
		typeOnElement(pincode,testCaseData.get("pincode"));
		test.log(Status.PASS, "Successfully inserted value in pincode field ::"+testCaseData.get("pincode"));
		
		//country.sendKeys("India");
		//country.sendKeys(testCaseData.get("country"));
		typeOnElement(country,testCaseData.get("country"));
		test.log(Status.PASS, "Successfully inserted value in country field ::"+testCaseData.get("country"));
		
		//tags.sendKeys("test tags");
		//tags.sendKeys(testCaseData.get("tags"));
		typeOnElement(tags,testCaseData.get("tags"));
		test.log(Status.PASS, "Successfully inserted value in tags field ::"+testCaseData.get("tags"));
		
		//desc.sendKeys("test data description added");
		//desc.sendKeys(testCaseData.get("desc"));
		typeOnElement(desc,testCaseData.get("desc"));
		test.log(Status.PASS, "Successfully inserted value in description field ::"+testCaseData.get("desc"));
		
		//max_desc.click();
		clickOnElement(max_desc,"Yes");
		test.log(Status.PASS, "Successfully clicked on max button ::"+testCaseData.get("desc"));
		
		//save.click();
		clickOnElement(save,"Yes");
		test.log(Status.PASS, "Successfully clicked on save button ::"+testCaseData.get("desc"));
	}
	
	
	public void selectStatus(String status_val)
	{
		
		List<WebElement> s_list  = driver.findElements(status);
		System.out.println("List of Status values ");
		
		for (int i = 0; i<s_list.size();i++)
		{
			//String status = "Active";
			WebElement elm = s_list.get(i);
			String e_value=elm.getText();
			System.out.println(e_value);
			if (e_value.equalsIgnoreCase(status_val))
			{
				System.out.println("Found the value to be clicked "+status_val);
				elm.click();
			}
		}
		
	}
	
	public void selectCategory(String cat_val)
	{
		List <WebElement> lilist =driver.findElements(category);//contains the webelements, html page elements; afterwards directly perform any operation like click
		System.out.println("List of category values ");
		for (int i = 0; i < lilist.size();i++)
		{
			WebElement lelm = lilist.get(i);
			String lelm_val = lelm.getText();
			System.out.println(lelm_val);

			//String s2 = "Partner";

			if(lelm_val.equalsIgnoreCase(cat_val) )
			{
				System.out.println("Found the value to be clicked "+cat_val);
				lelm.click();
			}


		}
	}

	public void selectPriority(String priority_val)
	{
		
		List<WebElement> welm = driver.findElements(priority);
		System.out.println("List of priority values ");
		for (int i=0;i<welm.size();i++)
		{
			WebElement web = welm.get(i);
			String value=web.getText();
			System.out.println(value);
			if (value.equalsIgnoreCase(priority_val))
			{
				System.out.println("Found the value to be selected "+priority_val);
				web.click();
			}
		}
		
	}
	
	private void selectSource(String source_val) {
	
		List<WebElement> webel = driver.findElements(source);
		System.out.println("The list of source values is ");
		
		for (int i = 0; i<webel.size();i++)
		{
			WebElement value = webel.get(i);
			String values=value.getText();
			System.out.println(values);
			if(values.equalsIgnoreCase(source_val))
			{
				System.out.println("source value to be clicked is "+source_val);
				value.click();
			}
		}
	
	}
	
	private void selectAddrType(String type) {
		
		List<WebElement> elist = driver.findElements(addr_type);
		System.out.println("List of values in Types field is ");
		
		for(int i = 0;i<elist.size();i++)
		{
			WebElement value =elist.get(i);
			String types=value.getText();
			System.out.println(types);
			if(types.equalsIgnoreCase(type))
			{
				System.out.println("Found the value to br selected "+type);
				value.click();
			}
		}
	}
}
