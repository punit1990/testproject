package Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	
	  public static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance();
	        return extent;
	    }
	
	
	
	
	
	
	public static ExtentReports createInstance(){
	reporter = new ExtentHtmlReporter("./Reports/Extentreport" + System.currentTimeMillis() + ".html");
	reporter.config().setCSS(".r-img { width: 30%; }");
	//rreporter.loadXMLConfig("./extent-config.xml");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	return extent;
	}
}
