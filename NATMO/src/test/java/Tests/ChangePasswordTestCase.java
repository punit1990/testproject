package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ExcelUtilities.ReusableUtil;
import Listener.ExtentTestManager;
import PageObjects.ChangePasswordPage;

public class ChangePasswordTestCase {

	public static WebDriver driver;
	public Actions action;
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
	}
	
	@Test(priority = 1)
	public void CGL_NATMO_ChangePassword_01() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get Change Password page from user profile drop down.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(ChangePasswordPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Enter username or email id.");
		driver.findElement(By.xpath(ChangePasswordPage.email)).sendKeys("admin");
		ExtentTestManager.getTest().log(Status.INFO, "Enter password.");
		driver.findElement(By.xpath(ChangePasswordPage.password)).sendKeys("super1234");
		String captxt = driver.findElement(By.xpath(ChangePasswordPage.captchaQuestion)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
		driver.findElement(By.name(ChangePasswordPage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn button.");
		driver.findElement(By.xpath(ChangePasswordPage.btnLogin)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ChangePasswordPage.clkAdmin)).click();
		Thread.sleep(3000);
		WebElement mte = driver.findElement(By.xpath(ChangePasswordPage.changePassword));
		action = new Actions(driver);
		action.moveToElement(mte).click().perform();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath(ChangePasswordPage.currentPassword)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(ChangePasswordPage.newPassword)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(ChangePasswordPage.confirmPassword)).isDisplayed());
}

	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
//a