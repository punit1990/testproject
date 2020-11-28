package com.lucknow.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.lucknow.qa.base.TestBase;
import com.lucknow.qa.pages.HomePage;
import com.lucknow.qa.pages.LoginPage;
import com.qa.lucknow.ExtentReport.ExtentTestManager;

public class LoginPageTest extends TestBase{

	

	LoginPage loginPage;
	HomePage homePage;
	

	LoginPageTest(){
		super();	
	}



	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority=1)
	public void verifyLoginPageTitle() {
		
		String title = loginPage.validateLoginPageTitle();
		assertEquals(title, "Sign In | Lucknow GIS Portal");
	}

	@Test(priority=2)
	public void loginToWebProtal() {
		
		ExtentTestManager.getTest().log(Status.INFO, "Enter Username");
		loginPage.loginUserName("water");
		ExtentTestManager.getTest().log(Status.INFO, "Enter password");
		loginPage.loginPassword("abc123");
		ExtentTestManager.getTest().log(Status.INFO, "Click on Sign In button");
		homePage=loginPage.clickOnSignInButton();
		ExtentTestManager.getTest().log(Status.INFO, "user has successfully logged In into the portal");
	

	}

	@AfterMethod
	public void tearDown() {
		//ExtentTestManager.endTest();
		driver.quit();
	}







}
