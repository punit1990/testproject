package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver","D:\\Project\\Test\\Lucknow\\src\\main\\java\\com\\lucknow\\qa\\setup\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver","D:\\Project\\Test\\Lucknow\\src\\main\\java\\com\\lucknow\\qa\\setup\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.guru99.com/first-webdriver-script.html");

	}

}
