package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.WebDriverUtils;

public class HomePage extends WebDriverUtils {

	private static Logger log=LogManager.getLogger(HomePage.class);
	private WebDriver driver;
	//create a constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="//input[@type='text']")  //tagname[@attributename='value']
private WebElement searchEditBox;

@FindBy(css="button[class='btn btn-default btn-lg']") //tagname[attributename='value']
private WebElement searchIconButton;

@FindBy(css="div.col-sm-4")  //tagname.classValue
private WebElement openCartStaticText;

@FindBy(xpath="//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[3]/a")
private WebElement componentsLink;

@FindBy(xpath="//a[text()='Tablets']")  //tagname[text()='basenodetext']
private WebElement tabletsLink;

@FindBy(xpath="//a[text()='Tablets']/following::li")  //tagname[text()='basenodetext']/following::targettag
private WebElement softwareLink;

@FindBy(css="img[title='MacBook']")  //tagname[attribute='value']
private WebElement mackBookImage;

@FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md']")
private WebElement currencyStaticText;

@FindBy(xpath="//button[@type='button' and @class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
private WebElement itemsButton;   //tagname[@attribute1='value1' and @attribute2='value2']

@FindBy(xpath="//*[text()='My Account']")
private WebElement myAccountMenu;

@FindBy(linkText="Login")
private WebElement loginLink;

@FindBy(linkText="Register")
private WebElement registerLink;

public void openMyAccountMenu() throws InterruptedException {
	log.info("opening the myAccount menu");
	click(myAccountMenu);
}
public void navigateToRegisterPage() throws InterruptedException {
	openMyAccountMenu();
	log.info("click on register link");
	click(registerLink);
	
}

public void goToLoginPage() throws InterruptedException {
	openMyAccountMenu();
	log.info("click on Login link");
	click(loginLink);
	
}

public boolean isOpenCartLogoExist() throws InterruptedException {
	return openCartStaticText.isDisplayed();
}
}
