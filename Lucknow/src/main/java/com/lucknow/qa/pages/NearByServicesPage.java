package com.lucknow.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lucknow.qa.base.TestBase;

public class NearByServicesPage extends TestBase {
	

	@FindBy(id="txtBufferValue")
	WebElement enterBufferValue;
	
	@FindBy(id="btnBufferAnalysisGo")
	WebElement goBtn;
	
	@FindBy(css="button[class='confirm']")
	WebElement clickOnPopUp;
	
	@FindBy(xpath="//div[@id=\"OpenLayers_Layer_WMS_388\"]/img[@class=\"olTileImage\"]")
	
	WebElement clickOnImg;
	

	public NearByServicesPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void enterBufferValue() throws InterruptedException {
		enterBufferValue.clear();
		Thread.sleep(2000);
		enterBufferValue.sendKeys("1000");
		goBtn.click();
	}
	public void clickOnOkPopUp() {
		clickOnPopUp.click();
	}
	
	public void clickONiMG() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(clickOnImg, 0, 0).click().build().perform();
		
		
	}
	
}
