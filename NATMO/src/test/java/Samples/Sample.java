package Samples;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Listener.ExtentTestManager;
public class Sample {
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
	}

	@AfterMethod
	public void close() {
		driver.close();
		System.out.println("driver close........................");
	}
	

@Test
public void SGL_J_K_Contact_01() throws Exception {

ExtentTestManager.getTest().log(Status.INFO," Open Browser.\n");



ExtentTestManager.getTest().log(Status.INFO,"Enter URL of the NATMO application in address bar.");
driver.get("http://192.168.1.204:8083/");



}
}
