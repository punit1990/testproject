package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import ExcelUtilities.ReusableUtil;
import Listener.ExtentTestManager;
import PageObjects.UserProfilePage;

public class UserProfileTestCase {
	
	public static WebDriver driver;

	@BeforeSuite
	public void DriverProperty() {
		System.setProperty("webdriver.gecko.driver", "D:\\Project\\NATMO\\geckodriver.exe");

	}//a

	@BeforeMethod
	public void ExtentReportInitialize(ITestContext context) {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		context.setAttribute("WebDriver", driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void SGL_NATMO_UserProfile_01() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get user profile drop down on RHT side after login.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(UserProfilePage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Enter username or email id.");
		driver.findElement(By.xpath(UserProfilePage.email)).sendKeys("admin");
		ExtentTestManager.getTest().log(Status.INFO, "Enter password.");
		driver.findElement(By.xpath(UserProfilePage.password)).sendKeys("super1234");
		String captxt = driver.findElement(By.xpath(UserProfilePage.captchaQuestion)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
		driver.findElement(By.name(UserProfilePage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn button.");
		driver.findElement(By.xpath(UserProfilePage.btnLogin)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on Admin link.");
		driver.findElement(By.xpath(UserProfilePage.adminDropdown)).click();
		Thread.sleep(5000);
		WebElement profile = driver.findElement(By.xpath(UserProfilePage.profileLink));
		Assert.assertTrue(profile.isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "User can see the list of options.");
		
	}
	
	@Test(priority = 2)
	public void SGL_NATMO_UserProfile_02() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To vetify that user get User Profile page by clicks on \"User Profile\" option from drop down.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(UserProfilePage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Enter username or email id.");
		driver.findElement(By.xpath(UserProfilePage.email)).sendKeys("admin");
		ExtentTestManager.getTest().log(Status.INFO, "Enter password.");
		driver.findElement(By.xpath(UserProfilePage.password)).sendKeys("super1234");
		String captxt = driver.findElement(By.xpath(UserProfilePage.captchaQuestion)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
		driver.findElement(By.name(UserProfilePage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn button.");
		driver.findElement(By.xpath(UserProfilePage.btnLogin)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Admin link.");
		driver.findElement(By.xpath(UserProfilePage.adminDropdown)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on Profile link.");
		driver.findElement(By.xpath(UserProfilePage.profileLink)).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(UserProfilePage.profilePage)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "User is at user Profile page.");
	}
	
	@Test(priority = 4)
	public void SGL_NATMO_UserProfile_04() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To vetify that user  get \"Cart Summary\" page of logged in user  by clicks on \"Cart Summary\" option from drop down.");
		ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(UserProfilePage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Enter username or email id.");
		driver.findElement(By.xpath(UserProfilePage.email)).sendKeys("admin");
		ExtentTestManager.getTest().log(Status.INFO, "Enter password.");
		driver.findElement(By.xpath(UserProfilePage.password)).sendKeys("super1234");
		String captxt = driver.findElement(By.xpath(UserProfilePage.captchaQuestion)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
		driver.findElement(By.name(UserProfilePage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn button.");
		driver.findElement(By.xpath(UserProfilePage.btnLogin)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Admin link.");
		driver.findElement(By.xpath(UserProfilePage.adminDropdown)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on Cart Summary link.");
		driver.findElement(By.xpath(UserProfilePage.cartSummary)).click();
		Thread.sleep(3000);
		String cartTitle = driver.getTitle();
		Assert.assertEquals(cartTitle, "Cart | National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "User is at Cart Summary page.");
	}
	
	@Test(priority = 5)
	public void SGL_NATMO_UserProfile_05() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To vetify that user get \"Order History\" page of logged in user  by clicks on \"Order History\" option from drop down.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(UserProfilePage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Enter username or email id.");
		driver.findElement(By.xpath(UserProfilePage.email)).sendKeys("admin");
		ExtentTestManager.getTest().log(Status.INFO, "Enter password.");
		driver.findElement(By.xpath(UserProfilePage.password)).sendKeys("super1234");
		String captxt = driver.findElement(By.xpath(UserProfilePage.captchaQuestion)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
		driver.findElement(By.name(UserProfilePage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn button.");
		driver.findElement(By.xpath(UserProfilePage.btnLogin)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Admin link.");
		driver.findElement(By.xpath(UserProfilePage.adminDropdown)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on Order History link.");
		driver.findElement(By.xpath(UserProfilePage.orderHistory)).click();
		Thread.sleep(3000);
		String historyTitle = driver.getTitle();
		Assert.assertEquals(historyTitle, "Orders Management | National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "User is at Orders Management page.");
	}
	
	@Test(priority = 6)
	public void SGL_NATMO_UserProfile_06() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To vetify that user logout from NATMO application.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(UserProfilePage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Enter username or email id.");
		driver.findElement(By.xpath(UserProfilePage.email)).sendKeys("admin");
		ExtentTestManager.getTest().log(Status.INFO, "Enter password.");
		driver.findElement(By.xpath(UserProfilePage.password)).sendKeys("super1234");
		String captxt = driver.findElement(By.xpath(UserProfilePage.captchaQuestion)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
		driver.findElement(By.name(UserProfilePage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn button.");
		driver.findElement(By.xpath(UserProfilePage.btnLogin)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Admin link.");
		driver.findElement(By.xpath(UserProfilePage.adminDropdown)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on Log Out link.");
		driver.findElement(By.xpath(UserProfilePage.logOut)).click();
		Thread.sleep(3000);
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "User has successfully logged out.");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	
	
	

}
