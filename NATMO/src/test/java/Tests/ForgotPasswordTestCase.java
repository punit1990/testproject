package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import PageObjects.ForgotPasswordPage;

public class ForgotPasswordTestCase {

	public static WebDriver driver;
	@BeforeSuite
	public void DriverProperty() {
		System.setProperty("webdriver.gecko.driver", "D:\\Project\\NATMO\\geckodriver.exe");

	}

	@BeforeMethod
	public void ExtentReportInitialize(ITestContext context) {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		context.setAttribute("WebDriver", driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}//a

	@Test(priority = 1)
	public void SGL_NATMO_ForgotPassword_01() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get form of Forgot Password.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(ForgotPasswordPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Forgot Password Link.");
		driver.findElement(By.xpath(ForgotPasswordPage.forgotPassword)).click();
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Forget password | National Atlas & Thematic Mapping Organisation");
		Assert.assertTrue(driver.findElement(By.xpath(ForgotPasswordPage.usernameOrEmail)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(ForgotPasswordPage.enterCaptcha)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "user is at forgot password page.");
	}

	@Test(priority = 2)
	public void SGL_NATMO_ForgotPassword_02() throws InterruptedException{
		
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get form of Forgot Password from login failed message.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(ForgotPasswordPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Forgot Password Link.");
		driver.findElement(By.xpath(ForgotPasswordPage.forgotPassword)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on Email New Password Link.");
		driver.findElement(By.xpath(ForgotPasswordPage.emailNewPassword)).click();
		Assert.assertTrue(driver.findElement(By.xpath(ForgotPasswordPage.errorMessage)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Username or e-mail address field is required.Math question field is required.");
		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void SGL_NATMO_ForgotPassword_03() throws InterruptedException{
		
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get failed message for invalid user or invalid e-mail to new password.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(ForgotPasswordPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Forgot Password Link.");
		driver.findElement(By.xpath(ForgotPasswordPage.forgotPassword)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Enter Username or e-mail address.");
		driver.findElement(By.xpath(ForgotPasswordPage.usernameOrEmail)).sendKeys("super");
		ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
		String captxt = driver.findElement(By.xpath(ForgotPasswordPage.captchaQuestion)).getText();
		driver.findElement(By.name(ForgotPasswordPage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
		ExtentTestManager.getTest().log(Status.INFO, "Click on Email New Password Link.");
		driver.findElement(By.xpath(ForgotPasswordPage.emailNewPassword)).click();
		Assert.assertTrue(driver.findElement(By.xpath(ForgotPasswordPage.errorMessage)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Sorry, unrecognized username and email.");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
