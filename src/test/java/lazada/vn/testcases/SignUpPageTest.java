package lazada.vn.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lazada.vn.base.TestBase;

public class SignUpPage extends TestBase {
	
	
	// Page Factory - OR:
	@FindBy(xpath = "//img[@src='/img/cloud-login-logo.fea1aa49.svg']")
	WebElement cloudLogo;
	
	
	@FindBy(xpath="//*[@id='identifierId']")
	WebElement userEmail;
	
	@FindBy(name="password")
	WebElement inputPwd;
	
	@FindBy(xpath="//*[contains(text(),'Tiếp theo')]")
	WebElement nextBtn;
	
	@FindBy(xpath="//*[@id='passwordNext']")
	WebElement nextInputPwd;

	// Initializing The Page Objects:
	public SignUpPage() {
		
			PageFactory.initElements(driver, this);
		}
	
	
	

}
