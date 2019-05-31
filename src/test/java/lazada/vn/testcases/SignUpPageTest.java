package lazada.vn.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lazada.vn.base.TestBase;
import lazada.vn.pages.SignUpPage;
import lazada.vn.util.TestUtil;

public class SignUpPageTest extends TestBase {
	
	SignUpPage signupPage;
	
	public SignUpPageTest() throws IOException{
		
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		
		initialization();
		signupPage = new SignUpPage();
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
	
	@Test
	public void signUpWithGoogleAccountTest() throws IOException{
		
		signupPage.navigateSignUpPage();
		signupPage.signUpWithGoogleAccount();
		TestUtil.takeScreenshotAtEndOfTest();
		
		
	}
	
	

}
