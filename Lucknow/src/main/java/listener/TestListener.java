package listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.lucknow.qa.base.TestBase;
import com.lucknow.qa.utilities.TestUtil;
import com.qa.lucknow.ExtentReport.ExtentManager;
import com.qa.lucknow.ExtentReport.ExtentTestManager;

public class TestListener extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		
	}

	public void onTestFailure(ITestResult result) {
	
		try {
			ExtentTestManager.getTest().log(Status.FAIL, "Failed Case is: " + result.getName());
			ExtentTestManager.getTest().log(Status.FAIL, "Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.takeScreenShot(result.getName())).build());
			ExtentTestManager.getTest().log(Status.FAIL, result.getName()+" FAIL with error " + result.getThrowable());
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
		
	}

}
