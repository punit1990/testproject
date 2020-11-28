package PageObjects;

public class ChangePasswordPage {

	public static String signIn = "//a[text()=\" Sign  In\"]";
	public static String email = "//input[@placeholder='Your e-mail address']";
	public static String password = "//input[@placeholder='Your password']";
	public static String captcha = "captcha_response";
	public static String btnLogin ="//input[@value='Log in']";
	public static String captchaQuestion = "//span[@class='field-prefix']";
	public static String clkAdmin = "//a[@id='UserProfile']";
	public static String changePassword = "//a[@class='dropdown-item'][contains(text(),'Change Password')]";
	
	public static String currentPassword = "//input[@id='edit-current-pass']";
	public static String newPassword = "//input[@id='edit-pass-pass1']";
	public static String confirmPassword = "//input[@id='edit-pass-pass2']";
	public static String submit = "//input[@id='edit-submit']";
}
//a