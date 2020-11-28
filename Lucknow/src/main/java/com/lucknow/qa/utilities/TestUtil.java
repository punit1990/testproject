package com.lucknow.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.lucknow.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 10;

	public static String takeScreenShot(String screenShotName) throws IOException {

		String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + screenShotName + df + ".png";
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
		return path;

	}
}

