package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.JavaScriptUtils;
import com.qa.opencart.utils.WebDriverUtils;

public class LogoutPage extends WebDriverUtils {
	private Logger log=LogManager.getLogger(LogoutPage.class.getName());
	private WebDriver driver;
	JavaScriptUtils jsUtils;
	public LogoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		jsUtils=new JavaScriptUtils(driver);
	}
@FindBy(xpath="//h1[text()='Account Logout']")
private WebElement accountLogoutHeader;

@FindBy(css="div#content>p")
private WebElement accountLoggedOffMsg;

@FindBy(css="a[class='btn btn-primary']")
private WebElement accountLogoutContinueBtn;


public boolean isAccountLogoutHeaderExist() {
	waitForPageLoad(2000);
	log.info("accountLogoutHeader exist");
	return accountLogoutHeader.isDisplayed();
}
public boolean isAccountLoggedOffMsgExist() {
	waitForPageLoad(2000);
	log.info("AccountLoggedOffMsg exist");
	return accountLoggedOffMsg.isDisplayed();
}

public String getLogoutPgTitle() {
	waitForPageLoad(2000);
	return getTitle();
}

public void clickOnContinueBtn() throws InterruptedException {
	click(accountLogoutContinueBtn);
}

}
