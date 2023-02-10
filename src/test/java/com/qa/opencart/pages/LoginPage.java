package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.JavaScriptUtils;
import com.qa.opencart.utils.WebDriverUtils;

import io.qameta.allure.Step;

public class LoginPage extends WebDriverUtils {
	JavaScriptUtils jsUtils;
	private Logger log=LogManager.getLogger(LoginPage.class.getName());
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		jsUtils=new JavaScriptUtils(driver);
	}

	
@FindBy(xpath="//a[text()='Your Store']")
private WebElement yourStoreLink;

@FindBy(css="span[class='caret']")
private WebElement myAccountDropDown;

@FindBy(css="li.dropdown")
private WebElement myAccountMenu;

@FindBy(xpath="//*[text()='New Customer']")
private WebElement newCustomerHeaderText;

@FindBy(xpath="//*[text()='Continue']")
private WebElement newCustomerContinueBtn;

@FindBy(css="input#input-email")
private WebElement emailEditBox;

@FindBy(xpath="//input[@type='password'and@name='password']")
private WebElement passwordEditBox;

@FindBy(xpath="//input[@class='btn btn-primary'or@type='submit']")
private WebElement loginBtn;

@FindBy(xpath="//*[text()='Forgotten Password']")
private WebElement forgottenPwdLink;

@FindBy(xpath="//div[@class='list-group']/a[2]")
private WebElement registerLink;

@FindBy(linkText="Login")
private WebElement loginLink;

@FindBy(xpath="//*[@class='fa fa-home']")
private WebElement LoginPgHomeIcon;

@FindBy(css="ul.breadcrumb")
private WebElement LoginPgBreadCrumb;

@FindBy(xpath="//h2[text()='Returning Customer']")
private WebElement returningCustomerHeaderText;

@FindBy(xpath="//*[text()='Register Account']")
private WebElement registerAccountText;

@FindBy(xpath="//div[@class='list-group']/a[2]")
private WebElement loginPgRegisterLink;

@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a")
private WebElement loginPgLoginLink;

@FindBy(css="div[class='alert alert-success']")
private WebElement loginPgConformationSuccMsgFromForgotPg;

 
public void setEmail(String email) throws InterruptedException {
	log.info("entering  the email address");
	sendData(emailEditBox,email);
}
public String getloginPgConformationSuccMsgFromForgotPg() throws InterruptedException {
	log.info("loginPg Conformation SuccMsg From ForgotPg");
	return getText(loginPgConformationSuccMsgFromForgotPg);
}
public void setPwd(String pwd) throws InterruptedException {
	log.info("entering the pwd value");
	sendData(passwordEditBox,pwd);
}

@Step("login with username:{0} and password:{1}")
public void clickOnLogin(String email,String pwd) throws InterruptedException {
	sendData(emailEditBox,email);
	sendData(passwordEditBox,pwd);
	log.info("click on login button");
	click(loginBtn);
}
@Step("click on new customer continue btn")
public void clickOnContinue() throws InterruptedException {
	log.info("click on continue button");
	click(newCustomerContinueBtn);
	
}
@Step("click on BreadCrum home icon")
public void clickOnHomeIcon() {
	log.info("click on home icon");
	jsUtils.clickElementByJS(LoginPgHomeIcon);
}

@Step("Get Login Page current address bar url")
public String getLoginPageUrl() {
	return waitForUrlContains(Constants.LOGIN_PAGE_FRACTION_URL);
}

public void clickOnForgottenPassword() throws InterruptedException {
	log.info("click on ForgottenPassword link");
	click(forgottenPwdLink);
}

public boolean isNewCustomerHeaderTextAvailable() {
	return isDisplayed(newCustomerHeaderText);
}

public boolean isRegisterLinkAvailable() {
	return isDisplayed(registerLink);
}

public boolean isReturningCustomerHeaderTextAvailable() {
	return isDisplayed(returningCustomerHeaderText);
}

public boolean isRegisterAccountTextAvailable() {
	return isDisplayed(registerAccountText);
}

public void clickLoginPgRegisterLink() throws InterruptedException {
	log.info("click on login page register link");
	click(loginPgRegisterLink);
}
public boolean isForgotPswdExists() throws InterruptedException {
	log.info("verifying forgotpswd existsin login page");
	return isDisplayed(forgottenPwdLink);
}
}
