package com.lucknow.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.lucknow.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name="LoginName")
	WebElement username;

	@FindBy(name="Password")
	WebElement password;

	@FindBy(id="btnLogin")
	WebElement signIn;

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public void loginUserName(String userName){
		username.sendKeys(userName);	
	}
	
	public void loginPassword(String Password) {
	password.sendKeys(Password);
	}
	
	public HomePage clickOnSignInButton() {
	signIn.click();
	return new HomePage();
	}
	
}
