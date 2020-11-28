package com.lucknow.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.lucknow.qa.base.TestBase;
import com.lucknow.qa.pages.HomePage;
import com.lucknow.qa.pages.LoginPage;
import com.qa.lucknow.ExtentReport.ExtentTestManager;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	HomePageTest(){
		super();

	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		loginPage.loginUserName("water");
		loginPage.loginPassword("abc123");
		homePage = loginPage.clickOnSignInButton();
	}

	//	@Test
	//	public void verifyClickOnBufferAnalysis() {
	//		homePage.moveToWaterMenu();
	//	}

//	@Test(priority=1)
//	public void verifyClickOnProfileIcon() {
//		ExtentTestManager.getTest().log(Status.INFO, "Click on user profile icon");
//		ExtentTestManager.getTest().log(Status.INFO, "Verified logged In user");
//		homePage.click_On_Profile_Icon();
//	}
//
//	@Test(priority=2)
//	public void verify_Click_On_Help() {
//		ExtentTestManager.getTest().log(Status.INFO, "Click on Help link");
//		homePage.clickOnHelpIcon();	
//	}

	@Test(priority=3)
	public void verify_click_On_Bookmark_Link() {
		homePage.clickOnBookmarkLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
