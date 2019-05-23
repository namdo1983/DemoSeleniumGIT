package lazada.vn.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lazada.vn.base.TestBase;

public class HomePage extends TestBase{
	
	
	// Page Factory - OR:
	@FindBy(xpath = "//img[@src='//laz-img-cdn.alicdn.com/images/ims-web/TB1f6tgdAfb_uJjSsD4XXaqiFXa.png")
	WebElement lazadaLogo;
	
	@FindBy (xpath=" //span[contains(text(),'Đỗ Nam')] ")
	WebElement accountName;
	
	@FindBy (xpath=" //*[@id='q'] ")
	WebElement searchLazadaField;
	
	@FindBy (xpath=" //span[contains(text(),'Electronic Devices')] ")
	WebElement hoverMainCategory;
	
	@FindBy (xpath=" //span[contains(text(),'Mobiles')] ")
	WebElement hoverSubCategory;

	// Initializing The Page Objects:
	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public void verifyUserNameAfterLogged(){
		
		accountName.isDisplayed();
	}
	
	public String checkTitleHomePage(){
		
		return driver.getTitle();
	}
	
	public HomePage searchProductWithKeyword(){
		
		//Focus on search with keyword
		Actions focusSearch = new Actions(driver);
		focusSearch.moveToElement(searchLazadaField);
		focusSearch.click();
		focusSearch.sendKeys("scooter");	
		focusSearch.sendKeys(Keys.ENTER);
		focusSearch.build().perform();
		
		return new HomePage();
	}
	
	public HomePage searchProductWithSelection(){
		
		//Hover on main Category
		Actions hovermainCategory = new Actions(driver);
		hovermainCategory.moveToElement(hoverMainCategory);
		hovermainCategory.build().perform();
		
		// Hover on sub1 Category
		Actions hoversubCategory = new Actions(driver);
		hoversubCategory.moveToElement(hoverSubCategory);
		hoversubCategory.build().perform();

		return new HomePage();
	}
	
	
}
