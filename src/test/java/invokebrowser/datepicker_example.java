package invokebrowser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class datepicker_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectRootpath = System.getProperty("user.dir");//exact project path from ur system
		String chromedriverpath = projectRootpath + "/google_driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverpath); //webdriver path of exe from your project not installed driver (system) path 

		WebDriver driver = new ChromeDriver(); //object of webdriver interface why not chromedriver driver --> you can use it but it will work only for chrome driver, if we want to test browser compatibility we will have write more line for each browser

		driver.get("https://www.freecrm.com/index.html");//get will wait for ur page to load
		//driver.navigate();//does not wait for page to load 

		driver.manage().window().maximize(); //method cascading
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.name("username")).sendKeys("varsha_shirgaonkar");
		driver.findElement(By.name("password")).sendKeys("varsha123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.switchTo().frame("mainpanel");
		WebElement welm = driver.findElement(By.xpath("//a[@title='Contacts']"));

		Actions a = new Actions(driver);
		a.moveToElement(welm).build().perform();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@title='Contacts']/following::li/a[@title='New Contact']")).click();
		driver.findElement(By.xpath("//img[@id='f_trigger_c_birthday']")).click();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement tableobj=driver.findElement(By.xpath("//div[@class='calendar']/table"));
		WebElement theadObj= tableobj.findElement(By.tagName("thead"));
		WebElement theadRowObj=theadObj.findElement(By.tagName("tr"));
		List<WebElement> tdObjs=theadRowObj.findElements(By.tagName("td"));

		for(int i=0 ;i<tdObjs.size();i++) {
			WebElement columnObj=tdObjs.get(i);
			System.out.println(columnObj.getText());
		}

		WebElement tfootObj= tableobj.findElement(By.tagName("tfoot"));
		WebElement tfootRowObj=tfootObj.findElement(By.tagName("tr"));
		WebElement tfootth=tfootRowObj.findElement(By.tagName("td"));
		System.out.println(tfootth.getText());



		WebElement tbodyObj= tableobj.findElement(By.tagName("tbody"));
		List<WebElement> tbodyRowObj=tbodyObj.findElements(By.tagName("tr"));

		for(int j=0;j<tbodyRowObj.size();j++) {
			WebElement rowObj= tbodyRowObj.get(j);
			List<WebElement> tbodycolumnObj= rowObj.findElements(By.tagName("td"));

			boolean datefound=false;
			for(int k=0;k<tbodycolumnObj.size();k++) {
				WebElement colObj= tbodycolumnObj.get(k);
				//System.out.println(colObj.getText());

				if(!(colObj.getAttribute("class").equals("day wn")  || colObj.getAttribute("class").contains("day weekend"))) //not selecting current week and weekends values
				{
					System.out.println(colObj.getText());
				}

				if(k==3) //this is to select only tuesday date
				{
					if(colObj.getText().equals("12")){
						System.out.println(colObj.getText());
						colObj.click();
						datefound=true;
						break; //terminates inside loop
					}

				}
			}
			if(datefound==true)
			{
				break;
			}

		}
		
	}

}
