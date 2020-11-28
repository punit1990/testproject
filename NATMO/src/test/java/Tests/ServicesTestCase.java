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
import PageObjects.ServicesPage;

public class ServicesTestCase {

	public Actions action;
	public static WebDriver driver;
	@BeforeSuite
	public void DriverProperty() {
		System.setProperty("webdriver.gecko.driver", "D:\\Project\\NATMO\\geckodriver.exe");

	}
	//a
	@BeforeMethod
	public void ExtentReportInitialize(ITestContext context) {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		context.setAttribute("WebDriver", driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void SGL_NATMO_Services_01() throws InterruptedException{
		
		ExtentTestManager.getTest().log(Status.INFO, "To verify that User get the list of the Services from Header menu.");	
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(Status.INFO, "Click on Map/Atlas Services.");
	WebElement hover = driver.findElement(By.xpath(ServicesPage.mapAtlasService));
	action = new Actions(driver);
	action.moveToElement(hover).perform();
	Thread.sleep(3000);
	Assert.assertTrue(driver.findElement(By.xpath(ServicesPage.mapDropDown)).isDisplayed());
	ExtentTestManager.getTest().log(Status.INFO, "Map/Atlas Services Dropdown list has been successfully displayed.");
	
	}
	
	@Test(priority = 2)
	public void SGL_NATMO_Services_02() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To Verify user able to click on anyone service and get the list of dataset on result page.");
		ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Map/Atlas Services.");
		action = new Actions(driver);
		WebElement move = driver.findElement(By.xpath(ServicesPage.mapAtlasService));
		action.moveToElement(move).perform();
		ExtentTestManager.getTest().log(Status.INFO, "select National School Atlas service from dropdown.");
		WebElement selectMap = driver.findElement(By.xpath(ServicesPage.selectDropDownValue));
		action.moveToElement(selectMap).click().perform();
		Thread.sleep(5000);
		String checkbox = driver.findElement(By.xpath(ServicesPage.checkbox_NSA)).getAttribute("class");
		System.out.println(checkbox);
		Assert.assertEquals(checkbox, "facetapi-active");
	}
	
	@Test(priority = 3)
	public void SGL_NATMO_Services_03() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To Verify that user get the list of the searched service using search box on dataset page.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Map/Atlas Services.");
		action = new Actions(driver);
		WebElement move = driver.findElement(By.xpath(ServicesPage.mapAtlasService));
		action.moveToElement(move).perform();
		ExtentTestManager.getTest().log(Status.INFO, "select National School Atlas service from dropdown.");
		WebElement selectMap = driver.findElement(By.xpath(ServicesPage.selectDropDownValue));
		action.moveToElement(selectMap).click().perform();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Enter search text in Search box.");
		driver.findElement(By.xpath(ServicesPage.search)).sendKeys("soil");
		ExtentTestManager.getTest().log(Status.INFO, "Click on Apply button.");
		driver.findElement(By.xpath(ServicesPage.btnApply)).click();
		Thread.sleep(2000);
		String searchTitle = driver.findElement(By.xpath(ServicesPage.searchResult)).getText();
		Assert.assertEquals(searchTitle, "Soil");
		ExtentTestManager.getTest().log(Status.INFO, "User has successfully get the search result.");
	}
	
	@Test(priority = 8)
	public void SGL_NATMO_Services_08() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user able to see services in list view format after click on list view functionality.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Map/Atlas Services.");
		action = new Actions(driver);
		WebElement move = driver.findElement(By.xpath(ServicesPage.mapAtlasService));
		action.moveToElement(move).perform();
		ExtentTestManager.getTest().log(Status.INFO, "select National School Atlas service from dropdown.");
		WebElement selectMap = driver.findElement(By.xpath(ServicesPage.selectDropDownValue));
		action.moveToElement(selectMap).click().perform();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on List view icon.");
		driver.findElement(By.xpath(ServicesPage.listView)).click();
		Thread.sleep(3000);
		String list = driver.findElement(By.xpath(ServicesPage.list)).getAttribute("class");
		Assert.assertEquals(list, "col-sm-3 list");
		ExtentTestManager.getTest().log(Status.INFO, "User can see the services in list view.");
	}
	
	@Test(priority = 9)
	public void SGL_NATMO_Services_09() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user can't able to click on dataset name text and can't navigate to detail information of that dataset.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Map/Atlas Services.");
		action = new Actions(driver);
		WebElement move = driver.findElement(By.xpath(ServicesPage.mapAtlasService));
		action.moveToElement(move).perform();
		ExtentTestManager.getTest().log(Status.INFO, "select National School Atlas service from dropdown.");
		WebElement selectMap = driver.findElement(By.xpath(ServicesPage.selectDropDownValue));
		action.moveToElement(selectMap).click().perform();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on List view icon.");
		driver.findElement(By.xpath(ServicesPage.listView)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(ServicesPage.gridView)).click();
		Thread.sleep(3000);
		String grid = driver.findElement(By.xpath(ServicesPage.grid)).getAttribute("class");
		Assert.assertEquals(grid, "col-sm-3 grid");
		ExtentTestManager.getTest().log(Status.INFO, "User can see the services in grid view.");
	}
	
	
	
	
	
	
	
	 
	
	
	
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
