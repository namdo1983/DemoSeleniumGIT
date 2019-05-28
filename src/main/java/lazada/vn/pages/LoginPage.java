package lazada.vn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lazada.vn.base.TestBase;



public class LoginPage extends TestBase {
	
	//Page Factory:
	@FindBy (xpath="//div[@id='anonLogin']")
	WebElement clickLoginBtn;
	
	@FindBy (xpath="//*[@id='container']/div/div[2]/form/div/div[1]/div[1]")
	WebElement inputUserEmail;
	
	@FindBy (xpath=" //input[@placeholder='Please enter your password'] ")
	WebElement inputUserPassword;
	
	@FindBy (xpath="//span[@class='nc_iconfont btn_slide']")
	WebElement sliderLoginBtn;
	

	//Initializing The Page Objects:
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void navigateLoginPage(){
		
		clickLoginBtn.click();
	}
	
	
	public String checkTitleLoginPage(){
		
		return driver.getTitle();
	}
	
	public LoginPage loginwithEmailRegistered(String username, String password){
	
		
		//Focus on Email Field
		Actions focusEmailField = new Actions(driver);
		focusEmailField.moveToElement(inputUserEmail);
		focusEmailField.click();
		focusEmailField.sendKeys(username);
		focusEmailField.build().perform();

		// Focus on Password Field
		Actions focusPasswordField = new Actions(driver);
		focusPasswordField.moveToElement(inputUserPassword);
		focusPasswordField.click();
		focusPasswordField.sendKeys(password);
		focusPasswordField.build().perform();

		//TestUtil.waitElementVisible(sliderLoginBtn, 10);
				
		//Drag and drop Slider button to Login
		WebElement sliderLogin = sliderLoginBtn;
		
		int xOff = 1300;
		int yOff = 208;
		
		Actions actionLogin = new Actions(driver);
		actionLogin.dragAndDropBy(sliderLogin, xOff, yOff).release().build().perform();
		sliderLogin.click();
			
		return new LoginPage();
			
		
	}
	

}
