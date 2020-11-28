package com.lucknow.qa.pages;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.lucknow.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//i[@class='fa fa-tint']")
	WebElement mouse_water;

	@FindBy(id="gisqueries")
	WebElement mouse_gis_queries;

	@FindBy(id="bufferanalysisforotheravailableutilities")
	WebElement bufferAnalysis;

	@FindBy(xpath="//img[@src=\"/Content/Images/user.svg\"]")
	WebElement clickOnProfileIcon;

	@FindBy(xpath="//span[text()=\"Welcome WaterUser \"]")
	WebElement txt_waterUser;

	@FindBy(xpath="//ul[@class=\"list-inline nav-top map-icons\"]/li/a[@onclick=\"TriggerToolBarClick_New('HelpBTN')\"]")
	WebElement ClickOnHelp;

	@FindBy(id="addbookmark")
	WebElement ClickOnBookmark;
	
	@FindBy(xpath="//div[@class=\"x-form-element\"]/input[@id=\"ed_name\"]")
	WebElement bookMarkName;
	
	@FindBy(name="ed_desc")
	WebElement bookMarkDesc;
	
	@FindBy(id="btn_add")
	WebElement btnAdd;
	
	HomePage(){
		PageFactory.initElements(driver, this);
	}


	//	public NearByServicesPage moveToWaterMenu() {
	//		Actions action = new Actions(driver);
	//		action.moveToElement(mouse_water).perform();
	//		action.moveToElement(mouse_gis_queries).perform();
	//		action.moveToElement(bufferAnalysis).click().perform();
	//		return new NearByServicesPage();
	//	}

	public boolean click_On_Profile_Icon() {
		clickOnProfileIcon.click();
		if(txt_waterUser.isDisplayed())
		{

			return true;
		}
		else {

			return false;
		}
	}

	public void clickOnHelpIcon() {
		ClickOnHelp.click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Lucknow Smart City Ltd.");
		driver.close();
		driver.switchTo().window(parentWindow);

	}
	
	public void clickOnBookmarkLink() {
		ClickOnBookmark.click();
		bookMarkName.sendKeys("Demo");
		bookMarkDesc.sendKeys("Added for testing");
		btnAdd.click();
	}
	
}
