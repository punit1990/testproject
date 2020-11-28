package Listener;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Listener implements ITestListener {
	private static String fileSeperator = System.getProperty("file.separator");
	WebDriver driver = null;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generrated method stub
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		ITestContext context = result.getTestContext();
		
		driver = (WebDriver) context.getAttribute("WebDriver");
		
		String testClassName = getTestClassName(result.getInstanceName()).trim();

		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName +System.currentTimeMillis() + ".png";

		if (driver != null) {
		
			String imagePath = System.getProperty("user.dir") + fileSeperator + "Screenshots" + fileSeperator
					+ "Results" + fileSeperator + testClassName + fileSeperator
					+ takeScreenShot(driver, screenShotName, testClassName);
			System.out.println("Screenshot can be found : " + imagePath);
			try {
				ExtentTestManager.getTest().fail("Screenshot",
						MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ExtentTestManager.getTest().log(Status.INFO, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("*** Test Suite " + context.getName() + " started ***");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
		driver = (WebDriver) context.getAttribute("WebDriver");

	}

	public static String takeScreenShot(WebDriver driver, String screenShotName, String testName) {
		try {
			File file = new File("Screenshots" + fileSeperator + "Results");
			if (!file.exists()) {
				System.out.println("File created " + file);
				file.mkdir();
			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File("Screenshots" + fileSeperator + "Results" + fileSeperator + testName,
					screenShotName);
			FileUtils.copyFile(screenshotFile, targetFile);

			return screenShotName;
		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
			return null;
		}
	}

	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}

}
