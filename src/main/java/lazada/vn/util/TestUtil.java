package lazada.vn.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lazada.vn.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;
	
	
	public static void Sleep(int s){
        try {
           // thread to sleep for 1000 milliseconds
           Thread.sleep(s);
        } catch (InterruptedException e) {
           System.out.println(e);
        }
   }
	
	
	public static WebElement waitElementVisiable( WebElement webElement, int seconds){
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
		return element;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {

		// Take screenshot and store it as a file format:
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		// Now copy the screenshot to desired location using copyFile():
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".jpg"));
	}
	
}
