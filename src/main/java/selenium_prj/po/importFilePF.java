package selenium_prj.po;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BasePageObject;
import utility.ScreenShot;

public class importFilePF extends BasePageObject  {

	@FindBy(how=How.LINK_TEXT,using="Import")
	WebElement importLink;
	@FindBy(how=How.NAME,using="import_file")
	WebElement chooseFile;
	
	WebDriver driver;
	
	public importFilePF(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}

	public void clickImportLink(String projectRootpath, ExtentTest test)
	{
		//driver.switchTo().frame("mainpanel");
		//importLink.click();
		clickOnElement(importLink,"Yes");
		test.log(Status.PASS, "clicked on import link");
	}
	
	public void browseandselect(String projectRootpath,ExtentTest test)
	{
		//chooseFile.click();
		clickOnElement(chooseFile,"Yes");
		test.log(Status.PASS, "clicked on the link to choose file");
	}

	public void selectFileToImport(String filePath, String projectRootpath,ExtentTest test) throws IOException {
		uploadFileWithRobot(filePath,projectRootpath);
		System.out.println("file imported successfully");
		test.log(Status.PASS, "successfully selected the file to be imported");
		
	}
	
	public void setContentToClipboard(String strContent){
		StringSelection stringSelection = new StringSelection(strContent);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        System.out.println("stringSelection::"+stringSelection);
	}
	
	 //File upload by Robot Class
    public void uploadFileWithRobot (String strContent, String projectRootpath) throws IOException {
    	setContentToClipboard(strContent);
 
        Robot robot = null;
 
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        String fileSavePath=projectRootpath+"/Reports/Screenshot";
        robot.delay(250);
        //ScreenShot.capture(driver, fileSavePath, "importfile");
        
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

	   
}







