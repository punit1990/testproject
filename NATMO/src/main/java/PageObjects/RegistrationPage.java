package PageObjects;

public class RegistrationPage {

	public static String registrationLink ="//a[contains(text(),'Register')]";
	public static String salutation ="//select[@id='edit-field-salutation-title-und']";
	public static String firstName = "//input[@id='edit-field-first-name-und-0-value']";
	public static String lastName = "//input[@id='edit-field-last-name-und-0-value']";
	public static String Country = "//select[@id='edit-field-country-name-und']";
	public static String mobileNo = "//input[@id='edit-field-mobile-no-und-0-phonenumber']";
	public static String userName = "//input[@id='edit-name']";
	public static String emailAddress = "//input[@id='edit-mail']";
	public static String about = "//textarea[@id='edit-field-about-und-0-value']";
	public static String residenceCheckbox = "//input[@id='edit-field-residence-within-india-und']";
	public static String captchaQuestion = "//span[@class='field-prefix']";
	public static String captcha = "//input[@id='edit-captcha-response']";
	public static String btnCreateAccount = "//input[@id='edit-submit']";
	public static String registrationSuccessMsg ="//div[@class='alert alert-success alert-dismissable']";
	public static String registrationErrorMsg = "//div[text()='The username contains an illegal character.']";
	public static String registrationError ="//div[@class='alert alert-danger alert-dismissable']";
	
	public static String forgetPassword = "//a[contains(text(),'Forget Password')]";
	public static String forgetUsername = "//a[contains(text(),'Forget Username')]";
	public static String signIn = "//a[contains(text(),'Sign In')]";
}
//a