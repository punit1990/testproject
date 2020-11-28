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
import Listener.ExtentTestManager;
import PageObjects.ThemesPage;

public class ThemesTestCase {

	public Actions action;
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
	public void SGL_NATMO_Themes_01() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify that User get the  NATMO Themes on home of the application.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(Status.INFO, "Click on Themes.");
	WebElement hover = driver.findElement(By.xpath(ThemesPage.themes));
	action = new Actions(driver);
	action.moveToElement(hover).perform();
	Thread.sleep(3000);
	Assert.assertTrue(driver.findElement(By.xpath(ThemesPage.themesDropdown)).isDisplayed());
	ExtentTestManager.getTest().log(Status.INFO, "Themes Dropdown list has been successfully displayed.");
	
	}
	
	@Test(priority = 2)
	public void SGL_NATMO_Themes_02() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To Verify user able to get the result page with the list of the dataset according to the selected theme.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(Status.INFO, "Click on Themes.");
	WebElement hover = driver.findElement(By.xpath(ThemesPage.themes));
	action = new Actions(driver);
	action.moveToElement(hover).perform();
	ExtentTestManager.getTest().log(Status.INFO, "Click on Theme from the drop-down list. ");
	WebElement selectoption = driver.findElement(By.xpath(ThemesPage.themesDropdown));
	action.moveToElement(selectoption).click().perform();
	Thread.sleep(5000);
	String active = driver.findElement(By.xpath(ThemesPage.themeCheckbox)).getAttribute("class");
	System.out.println(active);
	Assert.assertEquals(active, "facetapi-active");
	ExtentTestManager.getTest().log(Status.INFO, "User will get the search result page with the list of the dataset of the selected Theme.");
	
	}
	
	@Test(priority = 3)
	public void SGL_NATMO_Themes_03() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify that user able to click on \"View metadata\" button and get detail information of that theme.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(Status.INFO, "Click on Themes.");
	WebElement hover = driver.findElement(By.xpath(ThemesPage.themes));
	action = new Actions(driver);
	action.moveToElement(hover).perform();
	ExtentTestManager.getTest().log(Status.INFO, "Click on Theme from the drop-down list. ");
	WebElement selectoption = driver.findElement(By.xpath(ThemesPage.themesDropdown));
	action.moveToElement(selectoption).click().perform();
	ExtentTestManager.getTest().log(Status.INFO, "Click on Metadata button.");
	driver.findElement(By.xpath(ThemesPage.metadata)).click();
	Thread.sleep(3000);
	Assert.assertTrue(driver.findElement(By.xpath(ThemesPage.metadataresult)).isDisplayed());
	ExtentTestManager.getTest().log(Status.INFO, "User will get the detail information of that theme.");
	
	}
	
	
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
