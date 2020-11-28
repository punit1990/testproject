package PageObjects;

public class ForgotPasswordPage {
	
	public static String signIn = "//a[text()=\" Sign  In\"]";
	public static String forgotPassword = "//a[contains(text(),'Forget Password')]";
	public static String usernameOrEmail = "//input[@id='edit-name']";
	public static String enterCaptcha ="//input[@id='edit-captcha-response']";
	public static String errorMessage ="//div[@class='alert alert-danger alert-dismissable']";
	public static String emailNewPassword = "//input[@id='edit-submit']";
	
	public static String captchaQuestion = "//span[@class='field-prefix']";
	public static String captcha = "captcha_response";
	
}
//a