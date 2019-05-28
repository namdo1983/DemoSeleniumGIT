package lazada.vn.util;

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
	
}
