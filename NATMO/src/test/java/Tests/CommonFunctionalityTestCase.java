package Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Listener.ExtentTestManager;
import PageObjects.CommonFunctionalityPage;
import PageObjects.HomePage_Page;

public class CommonFunctionalityTestCase {

	public static WebDriver driver;
	public static JavascriptExecutor js;

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
	public void SGL_NATMO_COMMON_01() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user able to get Website policies page.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on Website Policies page.");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(CommonFunctionalityPage.policies)).click();
		Thread.sleep(2000);
		String wpTitle = driver.getTitle();
		Assert.assertEquals(wpTitle, "Website Policies | National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "Verified Website Policies page.");
	}

	@Test(priority = 2)
	public void SGL_NATMO_COMMON_02() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user able to get  Help page.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on Help page.");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(CommonFunctionalityPage.help)).click();
		Thread.sleep(2000);
		String hTitle = driver.getTitle();
		Assert.assertEquals(hTitle, "NATMO");
		ExtentTestManager.getTest().log(Status.INFO, "Verified Help page.");
	}

	@Test(priority = 3)
	public void SGL_NATMO_COMMON_03() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user able to get  Contect Us page.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on contact us page.");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(CommonFunctionalityPage.contactUs)).click();
		Thread.sleep(2000);
		String cTitle = driver.getTitle();
		Assert.assertEquals(cTitle, "Contact Us | National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "Verified contact us page.");
	}

	@Test(priority = 5)
	public void SGL_NATMO_COMMON_05() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user able to get  Terms & Conditions page.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on Terms & Conditions page.");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(CommonFunctionalityPage.terms)).click();
		Thread.sleep(2000);
		String tcTitle = driver.getTitle();
		Assert.assertEquals(tcTitle, "Terms And Conditions | National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "Verified Terms And Conditions page.");
	}

	@Test(priority = 6)
	public void SGL_NATMO_COMMON_06() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user able to view 'Skip to Content' button on Header.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on Skip to main content link.");
		driver.findElement(By.xpath(CommonFunctionalityPage.skipToMainContent)).click();
		Thread.sleep(2000);
		String skipToMainContent = driver.getCurrentUrl();
		Assert.assertEquals(skipToMainContent, "http://192.168.1.204:8083/#main-content");
		driver.navigate().back();
		Thread.sleep(1000);
	}
	//a
	@Test(priority = 7)
	public void SGL_NATMO_COMMON_07() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get screen from Navigation to rest of page by clicks on 'Skip to Navigation' button.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on Skip to Navigation link.");
		driver.findElement(By.xpath(CommonFunctionalityPage.skipToNavigation)).click();
		Thread.sleep(2000);
		String skipToNavigation = driver.getCurrentUrl();
		Assert.assertEquals(skipToNavigation, "http://192.168.1.204:8083/#skip-navigate");
		driver.navigate().back();
		Thread.sleep(1000);
	}

	@Test(priority = 8)
	public void SGL_NATMO_COMMON_08() {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get dynamic count of 'Total visitors' on bottom panel.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		ExtentTestManager.getTest().log(Status.INFO, "Verify visitor count is present in footer.");
		WebElement visit = driver.findElement(By.xpath(HomePage_Page.visit));
		Assert.assertTrue(visit.isDisplayed());
		String visitCount = driver.findElement(By.xpath(HomePage_Page.visitNumber)).getText();
		driver.navigate().refresh();
		String increaseVisitCount = driver.findElement(By.xpath(HomePage_Page.visitNumber)).getText();
		Assert.assertNotEquals(visitCount, increaseVisitCount);
	}

	@Test(priority = 10)
	public void SGL_NATMO_COMMON_10() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get play & pause button on image slider.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		Thread.sleep(5000);
		driver.findElement(By.xpath(CommonFunctionalityPage.playImgSlide1)).click();
		Thread.sleep(5000);
		String att = driver.findElement(By.xpath(CommonFunctionalityPage.playImgSlide1)).getAttribute("class");
		System.out.println(att);
	}

	@Test(priority = 13)
	public void SGL_NATMO_COMMON_13() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get text size increased by clicks on A+ button.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on A+ to increase font size.");
		String beforeifSize = driver.findElement(By.xpath(CommonFunctionalityPage.skipToMainContent)).getCssValue("font-size");
		driver.findElement(By.xpath(CommonFunctionalityPage.increaseFontSize)).click();
		Thread.sleep(2000);
		String afterifSize = driver.findElement(By.xpath(CommonFunctionalityPage.skipToMainContent)).getCssValue("font-size");
		Assert.assertNotEquals(beforeifSize, afterifSize);
		ExtentTestManager.getTest().log(Status.INFO, "Font size get successfully increased.");

	}

	@Test(priority = 14)
	public void SGL_NATMO_COMMON_14() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get text size decreased by clicks on A- button.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on A- to decrease font size.");
		String beforedfSize = driver.findElement(By.xpath(CommonFunctionalityPage.skipToMainContent)).getCssValue("font-size");
		driver.findElement(By.xpath(CommonFunctionalityPage.decreaseFontSize)).click();
		Thread.sleep(2000);
		String afterdfSize = driver.findElement(By.xpath(CommonFunctionalityPage.skipToMainContent)).getCssValue("font-size");
		Assert.assertNotEquals(beforedfSize, afterdfSize);
		ExtentTestManager.getTest().log(Status.INFO, "Font size get successfully decreased.");
	}

	@Test(priority = 15)
	public void SGL_NATMO_COMMON_15() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get text size reseted by clicks on A button.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on A+ to increase font size.");
		driver.findElement(By.xpath(CommonFunctionalityPage.increaseFontSize)).click();
		Thread.sleep(2000);
		String ifSize = driver.findElement(By.xpath(CommonFunctionalityPage.skipToMainContent)).getCssValue("font-size");
		ExtentTestManager.getTest().log(Status.INFO, "Click on A to reset font size.");
		driver.findElement(By.xpath(CommonFunctionalityPage.resetFontSize)).click();
		Thread.sleep(2000);
		String dfSize = driver.findElement(By.xpath(CommonFunctionalityPage.skipToMainContent)).getCssValue("font-size");
		Assert.assertNotEquals(ifSize, dfSize);
		ExtentTestManager.getTest().log(Status.INFO, "Font size get successfully decreased.");
	}

	@Test(priority = 16)
	public void SGL_NATMO_COMMON_16() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user able to change language (from English to Hindi) / (from Hindi to English) for Home page.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Click on Hindi link.");
		driver.findElement(By.xpath(CommonFunctionalityPage.langHindi)).click();
		Thread.sleep(2000);
		String hindiAttribute = driver.findElement(By.xpath(CommonFunctionalityPage.langHindiActive)).getAttribute("class");
		Assert.assertEquals(hindiAttribute, "language-link active");
		ExtentTestManager.getTest().log(Status.INFO, "user has successfully changed hindi language.");
		Thread.sleep(2000);

		ExtentTestManager.getTest().log(Status.INFO, "Click on English link.");
		driver.findElement(By.xpath(CommonFunctionalityPage.langEng)).click();
		Thread.sleep(2000);
		String engAttribute = driver.findElement(By.xpath(CommonFunctionalityPage.langEngActive)).getAttribute("class");
		Assert.assertEquals(engAttribute, "language-link active");
		ExtentTestManager.getTest().log(Status.INFO, "user has successfully changed english language.");
		Thread.sleep(2000);
	}

	@Test(priority = 17)
	public void SGL_NATMO_COMMON_17() {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user able to view four different color button in home page.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");

		ExtentTestManager.getTest().log(Status.INFO, "Verify Green color button.");
		WebElement greencolor = driver.findElement(By.xpath(CommonFunctionalityPage.colorgreen));
		Assert.assertTrue(greencolor.isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Green color button is present.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify yellow color button.");
		WebElement yellowcolor = driver.findElement(By.xpath(CommonFunctionalityPage.coloryellow));
		Assert.assertTrue(yellowcolor.isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "yellow color button is present.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify red color button.");
		WebElement redcolor = driver.findElement(By.xpath(CommonFunctionalityPage.colorred));
		Assert.assertTrue(redcolor.isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "red color button is present.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify white color button.");
		WebElement whitecolor = driver.findElement(By.xpath(CommonFunctionalityPage.colorred));
		Assert.assertTrue(whitecolor.isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "white color button is present.");
	}
	
	@Test(priority = 18)
	public void SGL_NATMO_COMMON_18() throws InterruptedException{
		
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get home page text with color according to clicks on color button.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify red color button.");
		driver.findElement(By.xpath(CommonFunctionalityPage.colorred)).click();
		Thread.sleep(3000);
		String color = driver.findElement(By.xpath(CommonFunctionalityPage.skipToMainContent)).getCssValue("color");
		String hex = Color.fromString(color).asHex();
		Assert.assertEquals(hex, "#ff0000");
		ExtentTestManager.getTest().log(Status.INFO, "color has been successfully changed.");
	}
	@Test(priority = 19)
	public void SGL_NATMO_COMMON_19() throws InterruptedException {
		
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get 'Screen Reader Access' page by clicks on 'Screen Reader Access' button.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Screen Reader link.");
		driver.findElement(By.xpath(CommonFunctionalityPage.screenReader)).click();
		Thread.sleep(2000);
		String screenReaderTitle = driver.getTitle();
		Assert.assertEquals(screenReaderTitle, "Screen Reader Access | National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "Verified Screen Reader page.");
		Thread.sleep(2000);
	}
	


	@AfterMethod
	public void close() {
		driver.close();
	}
}
