package Base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import selenium_prj.po.ExcelReadWrite;
import selenium_prj.po.ExtentManager;

public class BaseTest {

	protected static WebDriver driver;
	protected static String projectRootpath;
	protected static String currentDateTime;
	protected static String reportingDirectory;
	protected static ExcelReadWrite datareader;
	protected static String htmlReportfilepath;
	
	static
	{
		//execution start from here
		projectRootpath = System.getProperty("user.dir");
		Calendar calendar = Calendar.getInstance();//capture current date time
		SimpleDateFormat formatar= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss_SSS");
		currentDateTime= formatar.format(calendar.getTime());
		
		ConfigfileReader configfileReader = new ConfigfileReader(projectRootpath);
		
		datareader= new ExcelReadWrite();
		datareader.getExcelFileData(projectRootpath);
		
		String appName=configfileReader.getApplicationName();
		
		reportingDirectory=CreateDirectoryStructure.getReportingDirectory(appName, projectRootpath, currentDateTime);
		
		htmlReportfilepath=reportingDirectory+appName+"_"+currentDateTime+".html";
		
		//initialise extent report
		ExtentManager.createInstance(htmlReportfilepath, appName, configfileReader.getEnvironment());
	}
	
	public static void setDriver() {
		// derive project location on machine
		
		//navigate to the folder with google chrome driver
		String chromedriverpath = projectRootpath + "/google_driver/chromedriver.exe";
		//set properties
		System.setProperty("webdriver.chrome.driver", chromedriverpath); 
		
	}
	
	public static void openUrl() {
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");//get will wait for ur page to load

		driver.manage().window().maximize(); //method cascading
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClassMethod(){
		ExtentManager.getInstance().flush();
	}
	
	@AfterTest(alwaysRun=true)
	public void tearDown(){
		System.out.println("tear down script start");
		driver.close();
	}
}
