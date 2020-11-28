package com.lucknow.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lucknow.qa.base.TestBase;
import com.lucknow.qa.pages.HomePage;
import com.lucknow.qa.pages.LoginPage;
import com.lucknow.qa.pages.NearByServicesPage;

public class NearByServicesPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	NearByServicesPage nearbyservicespage;
	
	public NearByServicesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		loginPage.loginUserName("water");
		loginPage.loginPassword("abc123");
		homePage = loginPage.clickOnSignInButton();
		//nearbyservicespage = homePage.moveToWaterMenu();
	}
	
	
	@Test
	public void enterBufferValueAndClickOnOkButton() throws InterruptedException {
		nearbyservicespage.enterBufferValue();
		nearbyservicespage.clickOnOkPopUp();
		nearbyservicespage.clickONiMG();
	}
	
	
	
}
