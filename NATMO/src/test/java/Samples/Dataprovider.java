package Samples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ExcelUtilities.ExcelUtils;
import Listener.ExtentTestManager;

public class Dataprovider {
	public String sTestCaseName;

	public int iTestCaseRow;

	public static WebDriver driver;

	@BeforeSuite
	public void DriverProperty() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\Software\\Automation\\Automation Tools\\Fire Fox Gecko Driver\\geckodriver.exe");

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

	@DataProvider(name = "Name of provider")

	public Object[][] Authentication_PMC_Electrical_7to9() throws Exception {

		// Setting up the Test Data Excel file

		ExcelUtils.setExcelFile("Datafilepath//testdata.xlsx", "SheetName");

		sTestCaseName = this.toString();

		// From above method we get long test case name including package and class name
		// etc.

		// The below method will refine your test case name, exactly the name use have
		// used

		sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
		System.out.println("sTestCaseName" + sTestCaseName);

		// Fetching the Test Case row number from the Test Data Sheet

		// Getting the Test Case name to get the TestCase row from the Test Data Excel
		// sheet

		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);
		System.out.println("iTestCaseRow" + iTestCaseRow);
		Object[][] testObjArray = ExcelUtils.getTableArray("Datafilepath//testdata.xlsx", "SheetName", iTestCaseRow);

		return (testObjArray);

	}

	@Test(dataProvider = "Name of provider")
	// In methods parameter declare same number of parameter
	// ex. From excel sheet program need 2 values as an input, declare two
	// parameters during method
	public void PMC_Electrical_7to9(String datainput1, String datainput2) throws Exception {

		ExtentTestManager.getTest().log(Status.INFO, "Open PMC Application.");

		driver.get("URL");

		ExtentTestManager.getTest().log(Status.INFO, "First input printed in consol");

		System.out.println(datainput1);

		ExtentTestManager.getTest().log(Status.INFO, "second input printed in consol");

		System.out.println(datainput2);
	}
}
