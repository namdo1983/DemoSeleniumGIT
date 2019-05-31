package lazada.vn.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lazada.vn.base.TestBase;
import lazada.vn.util.TestUtil;

public class SignUpPage extends TestBase {
	
	
	// Page Factory - OR:
	@FindBy(xpath = "//a[contains(text(),'signup')]")
	WebElement clickSignUpLink;
	
	@FindBy(xpath = "//button[@class='mod-button mod-button mod-third-party-login-btn mod-third-party-login-google'] ")
	WebElement clickGoogleBtn;
	
	@FindBy(xpath="//*[@id='identifierId']")
	WebElement userEmail;
	
	@FindBy(name="password")
	WebElement inputPwd;
	
	@FindBy(xpath="//*[contains(text(),'Tiếp theo')]")
	WebElement nextBtn;
	
	@FindBy(xpath="//*[@id='passwordNext']")
	WebElement nextInputPwd;
	
	@FindBy(xpath="//span[@id='myAccountTrigger']")
	WebElement clickMyAccount;
	
	@FindBy(xpath="//span[contains(text(), 'Manage My Account')]")
	WebElement clickManageMyAccount;

	// Initializing The Page Objects:
	public SignUpPage() {
		
			PageFactory.initElements(driver, this);
		}
	
	public void navigateSignUpPage(){
		
		TestUtil.waitElementVisiable(clickSignUpLink, 10);
		clickSignUpLink.click();
	}
	
	public SignUpPage signUpWithGoogleAccount(){
		
		//Click Google button
		TestUtil.waitElementVisiable(clickGoogleBtn, 10);
		clickGoogleBtn.click();
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		System.out.println("Parent window is "+ parentHandle);
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}

		//code to do something on new window
		driver.manage().window().maximize();
		userEmail.sendKeys("testing.selenium2407@gmail.com");
		nextBtn.click();
		inputPwd.sendKeys("namgmct2407");
		nextInputPwd.sendKeys(Keys.ENTER);
		driver.switchTo().window(parentHandle); // switch back to the original window
		
		TestUtil.waitElementVisiable(clickMyAccount, 15);
		clickMyAccount.click();
		TestUtil.waitElementVisiable(clickManageMyAccount, 10);
		clickManageMyAccount.click();
		
		
		return new SignUpPage();
	}
	

}
