package lazada.vn.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lazada.vn.base.TestBase;
import lazada.vn.util.TestUtil;

public class HomePage extends TestBase{
	
	
	// Page Factory - OR:
	@FindBy(xpath = "//img[@src='//laz-img-cdn.alicdn.com/images/ims-web/TB1f6tgdAfb_uJjSsD4XXaqiFXa.png")
	WebElement lazadaLogo;
	
	@FindBy (xpath=" //span[contains(text(),'Đỗ Nam')] ")
	WebElement accountName;
	
	@FindBy (xpath=" //*[@id='q'] ")
	WebElement searchLazadaField;
	
	@FindBy (xpath=" //*[@id='Level_1_Category_No1'] ")
	WebElement hoverMainCategory;
	
	@FindBy (xpath=" //span[contains(text(),'Mobiles')] ")
	WebElement hoverSubCategory;
	
	@FindBy (xpath=" //span[contains(text(),'Samsung')] ")
	WebElement selectBrand;
	
	@FindBy (xpath=" //span[contains(text(),'Free Shipping')] ")
	WebElement selectService;
	
	@FindBy (xpath=" //span[contains(text(),'Local')] ")
	WebElement selectLocation;
	
	@FindBy (xpath=" //span[contains(text(),'64GB')] ")
	WebElement selectStorageCapacity;
	
	@FindBy (xpath=" //span[contains(text(),'Black')] ")
	WebElement selectColorFamily;
	
	@FindBy (xpath=" //span[contains(text(),'More than 5.6 Inch')] ")
	WebElement selectPhoneScreen;
	
	@FindBy (xpath=" //span[contains(text(),'4GB')] ")
	WebElement selectRAM;
	
	@FindBy (xpath=" //span[contains(text(),'4G')] ")
	WebElement selectNetwork;
	
	@FindBy (xpath=" //span[contains(text(),'Android')] ")
	WebElement selectOperating;
	
	@FindBy (xpath=" //span[contains(text(),'Touchscreen')] ")
	WebElement selectFeatures;
	
	@FindBy (xpath=" //span[contains(text(),'Dual')] ")
	WebElement selectSimSlots;
	
	

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
		
		
		// Hover on sub Category
		//Actions hoversubCategory = new Actions(driver);
		//hoversubCategory.moveToElement(hoverSubCategory).build().perform();		
		TestUtil.waitElementVisible(hoverSubCategory, 10).click();
		TestUtil.Sleep(8);
		TestUtil.waitElementVisible(selectBrand, 20).click();
		TestUtil.Sleep(8);
		TestUtil.waitElementVisible(selectService, 20).click();
		TestUtil.Sleep(8);
		TestUtil.waitElementVisible(selectLocation, 20).click();
		TestUtil.Sleep(8);
		TestUtil.waitElementVisible(selectStorageCapacity, 30).click();
		TestUtil.Sleep(8);
		TestUtil.waitElementVisible(selectColorFamily, 40).click();
		TestUtil.Sleep(8);
		TestUtil.waitElementVisible(selectPhoneScreen, 40).click();
		TestUtil.Sleep(8);
		TestUtil.waitElementVisible(selectRAM, 40).click();
		TestUtil.Sleep(8);
		TestUtil.waitElementVisible(selectNetwork, 40).click();
		TestUtil.Sleep(8);
		TestUtil.waitElementVisible(selectOperating, 50).click();

		
		return new HomePage();
	}
	
	
}
