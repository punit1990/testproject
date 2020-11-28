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
import PageObjects.GeoPortalPage;


public class GeoPortalTestCase {

	public Actions action;
	public static WebDriver driver;
	@BeforeSuite
	public void DriverProperty() {
		System.setProperty("webdriver.gecko.driver", "D:\\Project\\NATMO\\geckodriver.exe");

	}

	@BeforeMethod
	public void ExtentReportInitialize(ITestContext context) {
		//a
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		context.setAttribute("WebDriver", driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void SGL_NATMO_GeoPortal_01() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "To verify that user be able to perform ID tool functionality.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Map/Atlas Services.");
		WebElement hover = driver.findElement(By.xpath(GeoPortalPage.mapAtlasService));
		action = new Actions(driver);
		action.moveToElement(hover).perform();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on \"All\" option of service drop-down list.");
		WebElement clickAll =  driver.findElement(By.xpath(GeoPortalPage.mapDropDown));
		action.moveToElement(clickAll).click().perform();
		driver.findElement(By.xpath(GeoPortalPage.search)).sendKeys("Bardhaman");
		driver.findElement(By.xpath(GeoPortalPage.apply)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on \"View in Geoportal\" button of any dataset.");
		driver.findElement(By.xpath(GeoPortalPage.Geoportal)).click();
		Thread.sleep(3000);
		driver.switchTo().frame("IGIS_MapViewer");
		driver.findElement(By.xpath(GeoPortalPage.closeLegend)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Identify Link.");
		driver.findElement(By.xpath(GeoPortalPage.identifyLink)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on any attribute on the GIS map.");
		driver.findElement(By.xpath(GeoPortalPage.map)).click();
		Assert.assertTrue(driver.findElement(By.xpath(GeoPortalPage.fetureInfo)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Feture Info Pop-up has been successfully displayed with details of particular attribute which are selected from the  GIS map.");
		Thread.sleep(300);
		
	}
	
	@Test(priority = 2)
	public void SGL_NATMO_GeoPortal_02() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "To verify that user be able to close ID Tool popup.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Map/Atlas Services.");
		WebElement hover = driver.findElement(By.xpath(GeoPortalPage.mapAtlasService));
		action = new Actions(driver);
		action.moveToElement(hover).perform();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on \"All\" option of service drop-down list.");
		WebElement clickAll =  driver.findElement(By.xpath(GeoPortalPage.mapDropDown));
		action.moveToElement(clickAll).click().perform();
		driver.findElement(By.xpath(GeoPortalPage.search)).sendKeys("Bardhaman");
		driver.findElement(By.xpath(GeoPortalPage.apply)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on \"View in Geoportal\" button of any dataset.");
		driver.findElement(By.xpath(GeoPortalPage.Geoportal)).click();
		Thread.sleep(3000);
		driver.switchTo().frame("IGIS_MapViewer");
		driver.findElement(By.xpath(GeoPortalPage.closeLegend)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Identify Link.");
		driver.findElement(By.xpath(GeoPortalPage.identifyLink)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on any attribute on the GIS map.");
		driver.findElement(By.xpath(GeoPortalPage.map)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Close option from the feature info Pop-up.");
		driver.findElement(By.xpath(GeoPortalPage.btnClose)).click();
		Assert.assertFalse(driver.findElement(By.xpath(GeoPortalPage.fetureInfo)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Feture Info Pop-up has been successfully closed.");
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 3)
	public void SGL_NATMO_GeoPortal_03() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "To verify that user be able to clear ID tool details.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Map/Atlas Services.");
		WebElement hover = driver.findElement(By.xpath(GeoPortalPage.mapAtlasService));
		action = new Actions(driver);
		action.moveToElement(hover).perform();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on \"All\" option of service drop-down list.");
		WebElement clickAll =  driver.findElement(By.xpath(GeoPortalPage.mapDropDown));
		action.moveToElement(clickAll).click().perform();
		driver.findElement(By.xpath(GeoPortalPage.search)).sendKeys("Bardhaman");
		driver.findElement(By.xpath(GeoPortalPage.apply)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on \"View in Geoportal\" button of any dataset.");
		driver.findElement(By.xpath(GeoPortalPage.Geoportal)).click();
		Thread.sleep(3000);
		driver.switchTo().frame("IGIS_MapViewer");
		driver.findElement(By.xpath(GeoPortalPage.closeLegend)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Identify Link.");
		driver.findElement(By.xpath(GeoPortalPage.identifyLink)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on any attribute on the GIS map.");
		driver.findElement(By.xpath(GeoPortalPage.map)).click();
		Thread.sleep(2000);
		String beforeResult = driver.findElement(By.xpath(GeoPortalPage.featureResult)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "Click on Clear option from the feature info Pop-up.");
		driver.findElement(By.xpath(GeoPortalPage.clear)).click();
		String afterResult = driver.findElement(By.xpath(GeoPortalPage.featureResult)).getText();
		Assert.assertNotEquals(beforeResult, afterResult);
		ExtentTestManager.getTest().log(Status.INFO, "User is able to clear frature info details.");
	}
	
	@Test(priority = 9)
	public void SGL_NATMO_GeoPortal_09() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "To verify that user be able to clear ID tool details.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
	
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user be able to Full Extent GIS map.");
		ExtentTestManager.getTest().log(Status.INFO, "Click on Map/Atlas Services.");
		WebElement hover = driver.findElement(By.xpath(GeoPortalPage.mapAtlasService));
		action = new Actions(driver);
		action.moveToElement(hover).perform();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on \"All\" option of service drop-down list.");
		WebElement clickAll =  driver.findElement(By.xpath(GeoPortalPage.mapDropDown));
		action.moveToElement(clickAll).click().perform();
		driver.findElement(By.xpath(GeoPortalPage.search)).sendKeys("Bardhaman");
		driver.findElement(By.xpath(GeoPortalPage.apply)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on \"View in Geoportal\" button of any dataset.");
		driver.findElement(By.xpath(GeoPortalPage.Geoportal)).click();
		Thread.sleep(3000);
		driver.switchTo().frame("IGIS_MapViewer");
		driver.findElement(By.xpath(GeoPortalPage.closeLegend)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on select Full Extent option.");
		driver.findElement(By.xpath(GeoPortalPage.zoomToExtent)).click();
		Thread.sleep(3000);
	}	
	
	@Test(priority = 10)
	public void SGL_NATMO_GeoPortal_10() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "To verify that user  be able to perform Swipe tool using By Layer option.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
	
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user be able to Full Extent GIS map.");
		ExtentTestManager.getTest().log(Status.INFO, "Click on Map/Atlas Services.");
		WebElement hover = driver.findElement(By.xpath(GeoPortalPage.mapAtlasService));
		action = new Actions(driver);
		action.moveToElement(hover).perform();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on \"All\" option of service drop-down list.");
		WebElement clickAll =  driver.findElement(By.xpath(GeoPortalPage.mapDropDown));
		action.moveToElement(clickAll).click().perform();
		driver.findElement(By.xpath(GeoPortalPage.search)).sendKeys("Bardhaman");
		driver.findElement(By.xpath(GeoPortalPage.apply)).click();
		ExtentTestManager.getTest().log(Status.INFO, "Click on \"View in Geoportal\" button of any dataset.");
		driver.findElement(By.xpath(GeoPortalPage.Geoportal)).click();
		Thread.sleep(3000);
		driver.switchTo().frame("IGIS_MapViewer");
		driver.findElement(By.xpath(GeoPortalPage.closeLegend)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(GeoPortalPage.MoistureRegion)).click();
		Thread.sleep(2000);
		WebElement swipe = driver.findElement(By.xpath(GeoPortalPage.swipe));
		WebElement bylayer = driver.findElement(By.xpath(GeoPortalPage.swipeByLayer));
		action.moveToElement(swipe).perform();
		Thread.sleep(2000);
		action.moveToElement(bylayer).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(GeoPortalPage.swipeStart)).click();
		
	}
		
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
