package lazada.vn.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import lazada.vn.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		
		try{
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\workspace\\DemoGITRepo\\src\\main\\java\\lazada\\vn\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		//wait logo lazada is display
		driver.findElement(By.xpath("//img[@alt='Online Shopping Lazada.vn Logo']")).isDisplayed();
		
		
	}
	

}
