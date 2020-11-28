package PageObjects;

public class UserProfilePage {
	
	public static String signIn = "//a[text()=\" Sign  In\"]";
	public static String email = "//input[@placeholder='Your e-mail address']";
	public static String password = "//input[@placeholder='Your password']";
	public static String captcha = "captcha_response";
	public static String btnLogin ="//input[@value='Log in']";
	public static String captchaQuestion = "//span[@class='field-prefix']";
	
	public static String adminDropdown = "//a[@id='UserProfile']";
	public static String profileLink = "//a[text()=' Profile']";
	public static String cartSummary = "//a[text()=' Cart Summary']";
	public static String orderHistory = "//a[text()='  Order History']";
	public static String logOut = "//span[text()=' Log Out']";
	
	public static String profilePage="//h2[contains(text(),\"admin's content\")]";

}
//a