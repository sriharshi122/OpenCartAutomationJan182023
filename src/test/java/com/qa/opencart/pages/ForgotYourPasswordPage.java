package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.WebDriverUtils;

public class ForgotYourPasswordPage extends WebDriverUtils{
	private WebDriver driver;
	private Logger log=LogManager.getLogger(ForgotYourPasswordPage.class);
	public ForgotYourPasswordPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
@FindBy(xpath="//h1[text()='Forgot Your Password?']")
private WebElement forgotYourPswdHeaderTxt;

@FindBy(xpath="//legend[text()='Your E-Mail Address']")
private WebElement yourEmailAddrTxt;

@FindBy(xpath="//input[@id='input-email'and@name='email']")
private WebElement emailAddrEditBox;

@FindBy(css="a[class='btn btn-default']")
private WebElement backLink;

@FindBy(css="input[type='submit'][class='btn btn-primary']")
private WebElement continueBtn;

@FindBy(xpath="//a[text()='Forgotten Password']")
private WebElement forgottenPswdLink;

@FindBy(css="#account-forgotten > ul > li:nth-child(1) > a")
private WebElement homeIconLink;

@FindBy(xpath="//div[@class='list-group']/a[2]")
private WebElement registerLink;

@FindBy(xpath="//div[@class='list-group']/a")
private WebElement loginLink;

@FindBy(xpath="//div[@class='list-group']/a[3]")
private WebElement loginPgForgotPswdLink;

@FindBy(xpath="//span[text()='My Account']")
private WebElement loginPgMyAccMenu;

@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a")
private WebElement loginPgMyAccMenuLoginLink;

@FindBy(css="div[class='alert alert-danger']")
private WebElement emailAddrNotFoundWarning;

public String emailAddrNotFoundWarning() throws InterruptedException {
	log.info("emailAddrNotFoundWarning");
	return getText(emailAddrNotFoundWarning);
}
public void setEmailAddress(String email) throws InterruptedException {
	log.info("enter the email address value");
	sendData(emailAddrEditBox,email);
}

public void clickOnContinue() throws InterruptedException {
	log.info("click on continue button");
	click(continueBtn);
}	
public void clickOnBack() throws InterruptedException {
	log.info("click on back link");
	click(backLink);
}

public boolean isYourEmailAddrTxtAvailable() {
	return isDisplayed(yourEmailAddrTxt);
}

public boolean isForgotYourPswdHeaderTxtAvailable() {
	log.info("ForgotYourPswdHeaderTxt is displayed on page");
	return isDisplayed(forgotYourPswdHeaderTxt);
}

public void clickOnHome() throws InterruptedException {
	log.info("click on home icon link");
	click(homeIconLink);
}

public void clickOnRegister() throws InterruptedException {
	log.info("click on register link");
	click(registerLink);
}

public void clickOnLoginPgForgotPswd() throws InterruptedException {
	log.info("click on Login page Forgot pswd link");
	click(loginPgForgotPswdLink);
}

public void clickOnMyAccMenu() throws InterruptedException {
	log.info("click on my account menu");
	click(loginPgMyAccMenu);
}

public void clickOnLoginPgLogin() throws InterruptedException {
	clickOnMyAccMenu();
	log.info("click on loginPgMyAccMenuLoginLink");
	click(loginPgMyAccMenuLoginLink);
}


/*
 * public void emailNotFoundWarning() { log.
 * info("emailNotFoundWarning is displayed after clicking on continue button");
 * 
 * }
 */
}


