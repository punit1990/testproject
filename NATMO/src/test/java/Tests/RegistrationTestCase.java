package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import ExcelUtilities.ReusableUtil;
import Listener.ExtentTestManager;
import PageObjects.RegistrationPage;

public class RegistrationTestCase {

	
	public static WebDriver driver;
	public Select select;
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
	public void SGL_NATMO_Registration_01() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify that user get Register page for user account creation.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	ExtentTestManager.getTest().log(Status.INFO, "Click on Registration link.");
	driver.findElement(By.xpath(RegistrationPage.registrationLink)).click();
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.salutation)).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.firstName)).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.lastName)).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.Country)).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.mobileNo)).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.userName)).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.emailAddress)).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.about)).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.residenceCheckbox)).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.captcha)).isDisplayed());
	ExtentTestManager.getTest().log(Status.INFO, "User has successfully navigated to the Registration page.");
	Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void SGL_NATMO_Registration_02() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify that user register with all valid details.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	ExtentTestManager.getTest().log(Status.INFO, "Click on Registration link.");
	driver.findElement(By.xpath(RegistrationPage.registrationLink)).click();
	ExtentTestManager.getTest().log(Status.INFO, "Select salutation from dropdown.");
	WebElement salutationDropdown = driver.findElement(By.xpath(RegistrationPage.salutation));
	select = new Select(salutationDropdown);
	select.selectByVisibleText("Mr.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter First name in textbox.");
	driver.findElement(By.xpath(RegistrationPage.firstName)).sendKeys("test");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Last name in textbox.");
	driver.findElement(By.xpath(RegistrationPage.lastName)).sendKeys("automation");
	ExtentTestManager.getTest().log(Status.INFO, "Select Country from dropdown.");
	WebElement countryDropdown = driver.findElement(By.xpath(RegistrationPage.Country));
	select = new Select(countryDropdown);
	select.selectByVisibleText("India (+91)");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Mobile Number in textbox.");
	driver.findElement(By.xpath(RegistrationPage.mobileNo)).sendKeys("9856236521");
	ExtentTestManager.getTest().log(Status.INFO, "Enter UserName in textbox.");
	driver.findElement(By.xpath(RegistrationPage.userName)).sendKeys("automation");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Email Address in textbox.");
	driver.findElement(By.xpath(RegistrationPage.emailAddress)).sendKeys("automation@gmail.com");
	ExtentTestManager.getTest().log(Status.INFO, "Enter About text in textbox.");
	driver.findElement(By.xpath(RegistrationPage.about)).sendKeys("Test Automation script");
	ExtentTestManager.getTest().log(Status.INFO, "Select Residence within india? checkbox.");
	driver.findElement(By.xpath(RegistrationPage.residenceCheckbox)).click();
	String captxt = driver.findElement(By.xpath(RegistrationPage.captchaQuestion)).getText();
	ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
	driver.findElement(By.xpath(RegistrationPage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
	driver.findElement(By.xpath(RegistrationPage.btnCreateAccount)).click();
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.registrationSuccessMsg)).isDisplayed());
	Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void SGL_NATMO_Registration_03() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify username validation in user registration.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	ExtentTestManager.getTest().log(Status.INFO, "Click on Registration link.");
	driver.findElement(By.xpath(RegistrationPage.registrationLink)).click();
	ExtentTestManager.getTest().log(Status.INFO, "Select salutation from dropdown.");
	WebElement salutationDropdown = driver.findElement(By.xpath(RegistrationPage.salutation));
	select = new Select(salutationDropdown);
	select.selectByVisibleText("Mr.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter First name in textbox.");
	driver.findElement(By.xpath(RegistrationPage.firstName)).sendKeys("test1");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Last name in textbox.");
	driver.findElement(By.xpath(RegistrationPage.lastName)).sendKeys("automation1");
	ExtentTestManager.getTest().log(Status.INFO, "Select Country from dropdown.");
	WebElement countryDropdown = driver.findElement(By.xpath(RegistrationPage.Country));
	select = new Select(countryDropdown);
	select.selectByVisibleText("India (+91)");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Mobile Number in textbox.");
	driver.findElement(By.xpath(RegistrationPage.mobileNo)).sendKeys("9856236520");
	ExtentTestManager.getTest().log(Status.INFO, "Enter UserName in textbox.");
	driver.findElement(By.xpath(RegistrationPage.userName)).sendKeys("automation_sgl");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Email Address in textbox.");
	driver.findElement(By.xpath(RegistrationPage.emailAddress)).sendKeys("automationsgl@gmail.com");
	ExtentTestManager.getTest().log(Status.INFO, "Enter About text in textbox.");
	driver.findElement(By.xpath(RegistrationPage.about)).sendKeys("Test Automation script");
	ExtentTestManager.getTest().log(Status.INFO, "Select Residence within india? checkbox.");
	driver.findElement(By.xpath(RegistrationPage.residenceCheckbox)).click();
	String captxt = driver.findElement(By.xpath(RegistrationPage.captchaQuestion)).getText();
	ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
	driver.findElement(By.xpath(RegistrationPage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
	driver.findElement(By.xpath(RegistrationPage.btnCreateAccount)).click();
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.registrationSuccessMsg)).isDisplayed());
	Thread.sleep(3000);
	}
	
	@Test(priority = 4)
	public void SGL_NATMO_Registration_04() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify that user redirect to Login page clicks on \"Log in\" button.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	ExtentTestManager.getTest().log(Status.INFO, "Click on Registration link.");
	driver.findElement(By.xpath(RegistrationPage.registrationLink)).click();
	ExtentTestManager.getTest().log(Status.INFO, "Select salutation from dropdown.");
	WebElement salutationDropdown = driver.findElement(By.xpath(RegistrationPage.salutation));
	select = new Select(salutationDropdown);
	select.selectByVisibleText("Mr.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter First name in textbox.");
	driver.findElement(By.xpath(RegistrationPage.firstName)).sendKeys("test1");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Last name in textbox.");
	driver.findElement(By.xpath(RegistrationPage.lastName)).sendKeys("automation1");
	ExtentTestManager.getTest().log(Status.INFO, "Select Country from dropdown.");
	WebElement countryDropdown = driver.findElement(By.xpath(RegistrationPage.Country));
	select = new Select(countryDropdown);
	select.selectByVisibleText("India (+91)");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Mobile Number in textbox.");
	driver.findElement(By.xpath(RegistrationPage.mobileNo)).sendKeys("9856236500");
	ExtentTestManager.getTest().log(Status.INFO, "Enter UserName in textbox.");
	driver.findElement(By.xpath(RegistrationPage.userName)).sendKeys("automation*sgl");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Email Address in textbox.");
	driver.findElement(By.xpath(RegistrationPage.emailAddress)).sendKeys("automationsgligs@gmail.com");
	ExtentTestManager.getTest().log(Status.INFO, "Enter About text in textbox.");
	driver.findElement(By.xpath(RegistrationPage.about)).sendKeys("Test Automation script");
	ExtentTestManager.getTest().log(Status.INFO, "Select Residence within india? checkbox.");
	driver.findElement(By.xpath(RegistrationPage.residenceCheckbox)).click();
	String captxt = driver.findElement(By.xpath(RegistrationPage.captchaQuestion)).getText();
	ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
	driver.findElement(By.xpath(RegistrationPage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
	driver.findElement(By.xpath(RegistrationPage.btnCreateAccount)).click();
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.registrationErrorMsg)).isDisplayed());
	Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void SGL_NATMO_Registration_05() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify that user redirect to  \"Forgot Password\" page clicks on \"Forgot Password\" button.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	ExtentTestManager.getTest().log(Status.INFO, "Click on Registration link.");
	driver.findElement(By.xpath(RegistrationPage.registrationLink)).click();
	ExtentTestManager.getTest().log(Status.INFO, "Click on Forget Password link.");
	driver.findElement(By.xpath(RegistrationPage.forgetPassword)).click();
	Thread.sleep(2000);
	String title = driver.getTitle();
	Assert.assertEquals(title, "Forget password | National Atlas & Thematic Mapping Organisation");
	}
	
	@Test(priority = 6)
	public void SGL_NATMO_Registration_06() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify that user redirect to \"Forgot Username\" page clicks on \"Forgot Username\" button.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	ExtentTestManager.getTest().log(Status.INFO, "Click on Registration link.");
	driver.findElement(By.xpath(RegistrationPage.registrationLink)).click();
	ExtentTestManager.getTest().log(Status.INFO, "Click on Sign In link.");
	driver.findElement(By.xpath(RegistrationPage.signIn)).click();
	Thread.sleep(2000);
	String title = driver.getTitle();
	Assert.assertEquals(title, "Sign In | National Atlas & Thematic Mapping Organisation");
	}
	
	@Test(priority = 7)
	public void SGL_NATMO_Registration_07() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify that user not able to register without fill one or more mandatory field in register form.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	ExtentTestManager.getTest().log(Status.INFO, "Click on Registration link.");
	driver.findElement(By.xpath(RegistrationPage.registrationLink)).click();
	ExtentTestManager.getTest().log(Status.INFO, "Click on Forget Username link.");
	driver.findElement(By.xpath(RegistrationPage.forgetUsername)).click();
	Thread.sleep(2000);
	String title = driver.getTitle();
	Assert.assertEquals(title, "User account | National Atlas & Thematic Mapping Organisation");
	}
	
	@Test(priority = 8)
	public void SGL_NATMO_Registration_007() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify that user not able to register without fill one or more mandatory field in register form.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	ExtentTestManager.getTest().log(Status.INFO, "Click on Registration link.");
	driver.findElement(By.xpath(RegistrationPage.registrationLink)).click();
	ExtentTestManager.getTest().log(Status.INFO, "Select salutation from dropdown.");
	WebElement salutationDropdown = driver.findElement(By.xpath(RegistrationPage.salutation));
	select = new Select(salutationDropdown);
	select.selectByVisibleText("Mr.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter First name in textbox.");
	driver.findElement(By.xpath(RegistrationPage.firstName));
	ExtentTestManager.getTest().log(Status.INFO, "Enter Last name in textbox.");
	driver.findElement(By.xpath(RegistrationPage.lastName)).sendKeys("automation1");
	ExtentTestManager.getTest().log(Status.INFO, "Select Country from dropdown.");
	WebElement countryDropdown = driver.findElement(By.xpath(RegistrationPage.Country));
	select = new Select(countryDropdown);
	select.selectByVisibleText("India (+91)");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Mobile Number in textbox.");
	driver.findElement(By.xpath(RegistrationPage.mobileNo));
	ExtentTestManager.getTest().log(Status.INFO, "Enter UserName in textbox.");
	driver.findElement(By.xpath(RegistrationPage.userName)).sendKeys("aautomationsgl");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Email Address in textbox.");
	driver.findElement(By.xpath(RegistrationPage.emailAddress));
	ExtentTestManager.getTest().log(Status.INFO, "Enter About text in textbox.");
	driver.findElement(By.xpath(RegistrationPage.about)).sendKeys("Test Automation script");
	ExtentTestManager.getTest().log(Status.INFO, "Select Residence within india? checkbox.");
	driver.findElement(By.xpath(RegistrationPage.residenceCheckbox));
	String captxt = driver.findElement(By.xpath(RegistrationPage.captchaQuestion)).getText();
	ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
	driver.findElement(By.xpath(RegistrationPage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
	driver.findElement(By.xpath(RegistrationPage.btnCreateAccount)).click();
	
	Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.registrationError)).isDisplayed());
	Thread.sleep(3000);
	}
	
	@Test(priority = 9)
	public void SGL_NATMO_Registration_08() throws InterruptedException{
	ExtentTestManager.getTest().log(Status.INFO, "To verify that user not able to register with same username which is already registered.");
	ExtentTestManager.getTest().log(Status.INFO, "User is at landing page of the Browser.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter URL of the NATMO application in address bar.");
	driver.get("http://192.168.1.204:8083/");
	
	ExtentTestManager.getTest().log(Status.INFO, "Click on Registration link.");
	driver.findElement(By.xpath(RegistrationPage.registrationLink)).click();
	ExtentTestManager.getTest().log(Status.INFO, "Select salutation from dropdown.");
	WebElement salutationDropdown = driver.findElement(By.xpath(RegistrationPage.salutation));
	select = new Select(salutationDropdown);
	select.selectByVisibleText("Mr.");
	ExtentTestManager.getTest().log(Status.INFO, "Enter First name in textbox.");
	driver.findElement(By.xpath(RegistrationPage.firstName)).sendKeys("test");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Last name in textbox.");
	driver.findElement(By.xpath(RegistrationPage.lastName)).sendKeys("automation");
	ExtentTestManager.getTest().log(Status.INFO, "Select Country from dropdown.");
	WebElement countryDropdown = driver.findElement(By.xpath(RegistrationPage.Country));
	select = new Select(countryDropdown);
	select.selectByVisibleText("India (+91)");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Mobile Number in textbox.");
	driver.findElement(By.xpath(RegistrationPage.mobileNo)).sendKeys("9856236521");
	ExtentTestManager.getTest().log(Status.INFO, "Enter UserName in textbox.");
	driver.findElement(By.xpath(RegistrationPage.userName)).sendKeys("automation");
	ExtentTestManager.getTest().log(Status.INFO, "Enter Email Address in textbox.");
	driver.findElement(By.xpath(RegistrationPage.emailAddress)).sendKeys("automation@gmail.com");
	ExtentTestManager.getTest().log(Status.INFO, "Enter About text in textbox.");
	driver.findElement(By.xpath(RegistrationPage.about)).sendKeys("Test Automation script");
	ExtentTestManager.getTest().log(Status.INFO, "Select Residence within india? checkbox.");
	driver.findElement(By.xpath(RegistrationPage.residenceCheckbox)).click();
	String captxt = driver.findElement(By.xpath(RegistrationPage.captchaQuestion)).getText();
	ExtentTestManager.getTest().log(Status.INFO, "Enter captcha code.");
	driver.findElement(By.xpath(RegistrationPage.captcha)).sendKeys(ReusableUtil.captchaCode(captxt));
	driver.findElement(By.xpath(RegistrationPage.btnCreateAccount)).click();
	System.out.println(driver.findElement(By.xpath("//em[text()]")).getText());
	//Assert.assertTrue(driver.findElement(By.xpath(RegistrationPage.registrationSuccessMsg)).isDisplayed());
	Thread.sleep(30000);
	}
	
	
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
