package Listener;


import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//a
public class ExtentManager {

	public static ExtentReporter reporter;
	public static ExtentReports extent;

	public static ExtentReports getInstance() { 
		   if (extent ==null)  {
			   createInstance(); 
		   }
			   return extent;  
			   } 
		   
public static ExtentReports createInstance(){  
	reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/ExtentReport" + System.currentTimeMillis() + ".html"); 
  ((ExtentHtmlReporter) reporter).config().setCSS(".r-img { width: 30%; }"); 
	  //reporter.loadXMLConfig("./extent-config.xml"); 
	  extent = new ExtentReports();
	    extent.attachReporter(reporter);  
	    return extent; 
	  }
	 	
}
