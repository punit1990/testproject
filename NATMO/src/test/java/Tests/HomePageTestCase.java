package Tests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Listener.ExtentTestManager;
import PageObjects.HomePage_Page;

public class HomePageTestCase {

	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	JavascriptExecutor js;

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
	public void Verify_NATMO_HomePage() {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		String title = driver.getTitle();
		Assert.assertEquals(title, "National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "User successfully landed to the home page");
	}

	@Test(priority = 2)
	public void Verify_LogoOfThe_Application() {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		Assert.assertTrue(driver.findElement(By.xpath(HomePage_Page.logo)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Verified Logo of the application");
	}

	@Test(priority = 3)
	public void Verify_ClickOnLogoOfThe_Application() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on The Logo of the application");
		driver.findElement(By.xpath(HomePage_Page.logo)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "Verified Logo of the application");
		String logo = driver.getTitle();
		Assert.assertEquals(logo, "National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "User successfully landed to the home page");
	}

	@Test(priority = 4)
	public void Verify_Application_FullName() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		String name = driver.findElement(By.xpath(HomePage_Page.logoFullName)).getText();
		Assert.assertEquals(name, "National Atlas & Thematic Mapping Organisation");
	}

	@Test(priority = 5)
	public void Verify_TopPanel_name() {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify home page link in the application.");
		Assert.assertTrue(driver.findElement(By.xpath(HomePage_Page.home)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Verify ebook Services page link in the application.");
		Assert.assertTrue(driver.findElement(By.xpath(HomePage_Page.ebookServices)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Verify map/atlas Service page link in the application.");
		Assert.assertTrue(driver.findElement(By.xpath(HomePage_Page.mapService)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Verify themes page link in the application.");
		Assert.assertTrue(driver.findElement(By.xpath(HomePage_Page.themes)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Verify aboutUs page link in the application.");
		Assert.assertTrue(driver.findElement(By.xpath(HomePage_Page.aboutUs)).isDisplayed());
	}

	@Test(priority = 8)
	public void Verify_AtlasMap_SearchBox() {

		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		ExtentTestManager.getTest().log(Status.INFO, "User should see the Atlas / Map Service search box");
		WebElement searchBox = driver.findElement(By.xpath(HomePage_Page.atlasMapSearchBox));
		Assert.assertTrue(searchBox.isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "User should see the Search button");
		WebElement searchBtn = driver.findElement(By.xpath(HomePage_Page.searchBtn));
		Assert.assertTrue(searchBtn.isDisplayed());

	}

	@Test(priority = 9)
	public void Verify_SearchBox_With_Valid_Input() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		ExtentTestManager.getTest().log(Status.INFO, "Enter valid input in search bos");
		driver.findElement(By.xpath(HomePage_Page.atlasMapSearchBox)).sendKeys("Tourism");
		ExtentTestManager.getTest().log(Status.INFO, "Click on Search button");
		driver.findElement(By.xpath(HomePage_Page.searchBtn)).click();
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePage_Page.verifySearchedTxt)))
				.isDisplayed();
		Thread.sleep(2000);
		String searchName = driver.findElement(By.xpath(HomePage_Page.verifySearchedTxt)).getText();
		Assert.assertEquals(searchName, "Tourism");
	}

	@Test(priority = 11)
	public void Verify_Slider() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		ExtentTestManager.getTest().log(Status.INFO, "Click on Next arrow to move slide");
		for (int i = 0; i <= 4; i++) {
			driver.findElement(By.xpath(HomePage_Page.sliderNext)).click();
			Thread.sleep(3000);
		}
		ExtentTestManager.getTest().log(Status.INFO, "Click on Prev arrow to move slide");
		for (int i = 0; i <= 4; i++) {
			driver.findElement(By.xpath(HomePage_Page.sliderPrev)).click();
			Thread.sleep(3000);
		}

	}

	@Test(priority = 12)
	public void Verify_MouseHover_To_MapService() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		ExtentTestManager.getTest().log(Status.INFO, "user can see the list of map services in dropdown.");
		action = new Actions(driver);
		WebElement move = driver.findElement(By.xpath(HomePage_Page.mouseHover));
		action.moveToElement(move).perform();
		Thread.sleep(3000);
		WebElement mapDropdown = driver.findElement(By.xpath(HomePage_Page.mouseHoverDropdown));
		Assert.assertTrue(mapDropdown.isDisplayed());
	}

	@Test(priority = 13)
	public void Verify_Click_on_MapService() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		ExtentTestManager.getTest().log(Status.INFO, "user can see the list of map services in dropdown.");
		action = new Actions(driver);
		WebElement move = driver.findElement(By.xpath(HomePage_Page.mouseHover));
		action.moveToElement(move).perform();
	}

	@Test(priority = 13)
	public void Verify_and_Select_MapService_from_Dropdown() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		ExtentTestManager.getTest().log(Status.INFO, "user can see the list of map services in dropdown.");
		action = new Actions(driver);
		WebElement move = driver.findElement(By.xpath(HomePage_Page.mouseHover));
		action.moveToElement(move).perform();
		ExtentTestManager.getTest().log(Status.INFO, "select National School Atlas service from dropdown.");
		WebElement selectMap = driver.findElement(By.xpath(HomePage_Page.selectDropDownValue));
		action.moveToElement(selectMap).click().perform();
		Thread.sleep(5000);
		String checkbox = driver.findElement(By.xpath(HomePage_Page.checkbox_NSA)).getAttribute("class");
		System.out.println(checkbox);
		Assert.assertEquals(checkbox, "facetapi-active");
		
	}
	@Test(priority = 14)
	public void Verify_Bottom_PanelOnHomePage() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on contact us page.");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(HomePage_Page.contactUs)).click();
		Thread.sleep(4000);
		String cTitle = driver.getTitle();
		Assert.assertEquals(cTitle, "Contact Us | National Atlas & Thematic Mapping Organisation");
		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.INFO, "Verified contact us page.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Help page.");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(HomePage_Page.help)).click();
		Thread.sleep(4000);
		String hTitle = driver.getTitle();
		Assert.assertEquals(hTitle, "NATMO");
		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.INFO, "Verified Help page.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Terms & Conditions page.");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(HomePage_Page.terms)).click();
		Thread.sleep(4000);
		String tcTitle = driver.getTitle();
		Assert.assertEquals(tcTitle, "Terms And Conditions | National Atlas & Thematic Mapping Organisation");
		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.INFO, "Verified Terms And Conditions page.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Website Policies page.");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(HomePage_Page.policies)).click();
		Thread.sleep(4000);
		String wpTitle = driver.getTitle();
		Assert.assertEquals(wpTitle, "Website Policies | National Atlas & Thematic Mapping Organisation");
		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.INFO, "Verified Website Policies page.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on FAQ page.");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath(HomePage_Page.faq)).click();
		Thread.sleep(4000);
		String faqTitle = driver.getTitle();
		Assert.assertEquals(faqTitle, "FAQ | National Atlas & Thematic Mapping Organisation");
		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.INFO, "Verified FAQ page.");
	}
	
	@Test(priority = 15)
	public void Verify_Application_Header() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(HomePage_Page.signIn)).click();
		Thread.sleep(2000);
		String signInTitle = driver.getTitle();
		Assert.assertEquals(signInTitle, "Sign In | National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "Verified SignIn page.");
		driver.navigate().back();
		Thread.sleep(2000);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Registration page.");
		driver.findElement(By.xpath(HomePage_Page.register)).click();
		Thread.sleep(2000);
		String regTitle = driver.getTitle();
		Assert.assertEquals(regTitle, "Create new account | National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "Verified Registration page.");
		driver.navigate().back();
		Thread.sleep(2000);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Screen Reader link.");
		driver.findElement(By.xpath(HomePage_Page.screenReader)).click();
		Thread.sleep(2000);
		String screenReaderTitle = driver.getTitle();
		Assert.assertEquals(screenReaderTitle, "Screen Reader Access | National Atlas & Thematic Mapping Organisation");
		ExtentTestManager.getTest().log(Status.INFO, "Verified Screen Reader page.");
		driver.navigate().back();
		Thread.sleep(2000);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Hindi link.");
		driver.findElement(By.xpath(HomePage_Page.langHindi)).click();
		Thread.sleep(2000);
		String hindiAttribute = driver.findElement(By.xpath(HomePage_Page.langHindiActive)).getAttribute("class");
		Assert.assertEquals(hindiAttribute, "language-link active");
		ExtentTestManager.getTest().log(Status.INFO, "user has successfully changed hindi language.");
		Thread.sleep(2000);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on English link.");
		driver.findElement(By.xpath(HomePage_Page.langEng)).click();
		Thread.sleep(2000);
		String engAttribute = driver.findElement(By.xpath(HomePage_Page.langEngActive)).getAttribute("class");
		Assert.assertEquals(engAttribute, "language-link active");
		ExtentTestManager.getTest().log(Status.INFO, "user has successfully changed english language.");
		Thread.sleep(2000);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Skip to main content link.");
		driver.findElement(By.xpath(HomePage_Page.skipToMainContent)).click();
		Thread.sleep(2000);
		String skipToMainContent = driver.getCurrentUrl();
		Assert.assertEquals(skipToMainContent, "http://192.168.1.204:8083/#main-content");
		driver.navigate().back();
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Skip to Navigation link.");
		driver.findElement(By.xpath(HomePage_Page.skipToNavigation)).click();
		Thread.sleep(2000);
		String skipToNavigation = driver.getCurrentUrl();
		Assert.assertEquals(skipToNavigation, "http://192.168.1.204:8083/#skip-navigate");
		driver.navigate().back();
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Green color button.");
		WebElement greencolor = driver.findElement(By.xpath(HomePage_Page.colorgreen));
		Assert.assertTrue(greencolor.isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Green color button is present.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify yellow color button.");
		WebElement yellowcolor = driver.findElement(By.xpath(HomePage_Page.coloryellow));
		Assert.assertTrue(yellowcolor.isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "yellow color button is present.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify red color button.");
		WebElement redcolor = driver.findElement(By.xpath(HomePage_Page.colorred));
		Assert.assertTrue(redcolor.isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "red color button is present.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify white color button.");
		WebElement whitecolor = driver.findElement(By.xpath(HomePage_Page.colorred));
		Assert.assertTrue(whitecolor.isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "white color button is present.");
		}
	
	@Test(priority = 16)
	public void Verify_Application_footer() {
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.\n");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify CopyRights information is present in footer.");
		WebElement copyright = driver.findElement(By.xpath(HomePage_Page.copyRights));
		Assert.assertTrue(copyright.isDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Best viewed information is present in footer.");
		WebElement view = driver.findElement(By.xpath(HomePage_Page.bestView));
		Assert.assertTrue(view.isDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify visitor count is present in footer.");
		WebElement visit = driver.findElement(By.xpath(HomePage_Page.visit));
		Assert.assertTrue(visit.isDisplayed());
		String visitCount =driver.findElement(By.xpath(HomePage_Page.visitNumber)).getText();	
	}
	
	
	@AfterMethod
	public void close() {
		driver.close();
	}

}
