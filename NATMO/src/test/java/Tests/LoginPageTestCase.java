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
import PageObjects.LoginPage;

public class LoginPageTestCase {

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
	public void SGL_NATMO_Login_01() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user get Login page.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(LoginPage.signIn)).click();
		Thread.sleep(2000);
		String signInTitle = driver.getTitle();
		Assert.assertEquals(signInTitle, "Sign In | National Atlas & Thematic Mapping Organisation");
		Assert.assertTrue(driver.findElement(By.xpath(LoginPage.email)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Username or email address text box displayed.");
		Assert.assertTrue(driver.findElement(By.xpath(LoginPage.password)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Login Password text box displayed.");
		Assert.assertTrue(driver.findElement(By.name(LoginPage.captcha)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Captcha text box displayed.");
		Assert.assertTrue(driver.findElement(By.xpath(LoginPage.btnLogin)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Login button displayed.");
	}
		
	@Test(priority = 2)
	public void SGL_NATMO_Login_02() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user login with valid username,password  and code display by image.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(LoginPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Enter username or email id.");
		driver.findElement(By.xpath(LoginPage.email)).sendKeys("admin");
		ExtentTestManager.getTest().log(Status.INFO, "Enter password.");
		driver.findElement(By.xpath(LoginPage.password)).sendKeys("super1234");
		String captxt = driver.findElement(By.xpath(LoginPage.captchaQuestion)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
		driver.findElement(By.name(LoginPage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn button.");
		driver.findElement(By.xpath(LoginPage.btnLogin)).click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Welcome | National Atlas & Thematic Mapping Organisation");
		
	}

	@Test(priority = 3)
	public void SGL_NATMO_Login_03() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "To verify that entered password in password input box not in readable format.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(LoginPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Verify that password is not in readable format.");
		driver.findElement(By.xpath(LoginPage.password)).sendKeys("super1234");
		Thread.sleep(1000);
		String pwdtype = driver.findElement(By.xpath(LoginPage.password)).getAttribute("type");
		Assert.assertEquals(pwdtype, "password");
	}

	@Test(priority = 4)
	public void SGL_NATMO_Login_04() throws InterruptedException{
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user redirect to \"Create new Account\" page clicks on \"Create new Account\" button.");
		ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(LoginPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Create New Account link.");
		driver.findElement(By.xpath(LoginPage.createNewAccount)).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Create new account | National Atlas & Thematic Mapping Organisation");
	}

	@Test(priority = 5)
	public void SGL_NATMO_Login_05() throws InterruptedException{
		
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user redirect to  \"Forget password\" page clicks on \"Forget Password\" button.");
		ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(LoginPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Forget Password link.");
		driver.findElement(By.xpath(LoginPage.forgetPassword)).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Forget password | National Atlas & Thematic Mapping Organisation");
	}
	
	@Test(priority = 6)
	public void SGL_NATMO_Login_06() throws InterruptedException{
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user redirect to \"Forget username\" page clicks on \"Forget username\" button.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on SignIn page.");
		driver.findElement(By.xpath(LoginPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Forget Username link.");
		driver.findElement(By.xpath(LoginPage.forgetUsername)).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "User account | National Atlas & Thematic Mapping Organisation");
	}
	
	@Test(priority = 7)
	public void SGL_NATMO_Login_07() throws InterruptedException{
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user not able to Sign In in NATMO application with blank details of the UserName and Password.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Sign In link.");
		driver.findElement(By.xpath(LoginPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on Log In.");
		driver.findElement(By.xpath(LoginPage.btnLogin)).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath(LoginPage.errorBox)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Username or email address field is required");
		Thread.sleep(2000);
	}
	
	@Test(priority = 8)
	public void SGL_NATMO_Login_08() throws InterruptedException{
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user not able to Sign In in NATMO application with valid Username and invalid Password.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Sign In link.");
		driver.findElement(By.xpath(LoginPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Enter username or email id.");
		driver.findElement(By.xpath(LoginPage.email)).sendKeys("admin");
		ExtentTestManager.getTest().log(Status.INFO, "Enter password.");
		driver.findElement(By.xpath(LoginPage.password)).sendKeys("super12345");
		String capCode = driver.findElement(By.xpath(LoginPage.captchaQuestion)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
		driver.findElement(By.name(LoginPage.captcha)).sendKeys(ReusableUtil.captchaCode(capCode));
		ExtentTestManager.getTest().log(Status.INFO, "Click on Log In.");
		driver.findElement(By.xpath(LoginPage.btnLogin)).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath(LoginPage.errorBox)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Sorry, unrecognized username or password. Have you forgotten your password?");
		Thread.sleep(2000);
	}
	
	@Test(priority = 9)
	public void SGL_NATMO_Login_09() throws InterruptedException{
		ExtentTestManager.getTest().log(Status.INFO, "To verify that user not able to Sign In in NATMO application with invalid Username and invalid Password.");
		ExtentTestManager.getTest().log(Status.INFO, " User is at landing page of the Browser.");
		ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
		driver.get("http://192.168.1.204:8083/");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click on Sign In link.");
		driver.findElement(By.xpath(LoginPage.signIn)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Enter username or email id.");
		driver.findElement(By.xpath(LoginPage.email)).sendKeys("super");
		ExtentTestManager.getTest().log(Status.INFO, "Enter password.");
		driver.findElement(By.xpath(LoginPage.password)).sendKeys("super12345");
		String capCode = driver.findElement(By.xpath(LoginPage.captchaQuestion)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
		driver.findElement(By.name(LoginPage.captcha)).sendKeys(ReusableUtil.captchaCode(capCode));
		ExtentTestManager.getTest().log(Status.INFO, "Click on Log In.");
		driver.findElement(By.xpath(LoginPage.btnLogin)).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath(LoginPage.errorBox)).isDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Sorry, unrecognized username or password. Have you forgotten your password?");
		Thread.sleep(2000);
	}
	

	@AfterMethod
	public void close() {
		driver.close();
	}
}
