package PageObjects;

public class LoginPage {

	public static String signIn = "//a[text()=\" Sign  In\"]";
	public static String email = "//input[@placeholder='Your e-mail address']";
	public static String password = "//input[@placeholder='Your password']";
	public static String captcha = "captcha_response";
	public static String btnLogin ="//input[@value='Log in']";
	public static String captchaQuestion = "//span[@class='field-prefix']";
	
	public static String createNewAccount ="//a[contains(text(),'Create new account')]";
	public static String forgetPassword = "//a[contains(text(),'Forget Password')]";
	public static String forgetUsername = "//a[contains(text(),'Forget Username')]";
	public static String errorBox = "//div[@class='main container']//div[@class='alert alert-danger alert-dismissable']";
}
//a