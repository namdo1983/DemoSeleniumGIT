package lazada.vn.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import lazada.vn.base.TestBase;
import lazada.vn.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	
	public LoginPageTest() throws IOException{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException{
		
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	
	
	@Test(priority = 2)
	public void loginPageTitleTest(){
		
		loginPage.navigateLoginPage();
		String loginTitle = loginPage.checkTitleLoginPage();
		Assert.assertEquals(loginTitle, "Lazada.vn: Online Shopping Vietnam - Mobiles, Tablets, Home Appliances, TV, Audio &amp; More");
	}
	
	
	@Test(priority = 1)
	public void loginPageWithEmailRegistered(){
		
		loginPage.navigateLoginPage();
		loginPage.loginwithEmailRegistered(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	
	
}
