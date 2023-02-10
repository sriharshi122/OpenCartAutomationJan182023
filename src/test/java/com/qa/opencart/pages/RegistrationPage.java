package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.JavaScriptUtils;
import com.qa.opencart.utils.WebDriverUtils;

public class RegistrationPage extends WebDriverUtils {
	JavaScriptUtils jsUtils;
	private Logger log=LogManager.getLogger(RegistrationPage.class.getName());
	private WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		jsUtils=new JavaScriptUtils(driver);
	}
@FindBy (xpath="//h1[text()='Register Account']")
private WebElement registerAccHeader;
@FindBy(css="div#content>p")
private WebElement registerAccStaticText;
@FindBy(css="div#content>p>a")
private WebElement registerAccLoginPageLink;
@FindBy(css="fieldset#account>legend")
private WebElement registerAccYourPersnlDetails;
@FindBy(css="input#input-firstname")
private WebElement firstNameEditBox;
@FindBy(css="input#input-lastname")
private WebElement lastNameEditBox;
@FindBy(css="input#input-email")
private WebElement emailEditBox;
@FindBy(css="input#input-telephone")
private WebElement telephoneEditBox;
@FindBy(css="input#input-fax")
private WebElement faxEditBox;
@FindBy(xpath="//div[@class='col-sm-10']/label[1]")
private WebElement yesLabel;
@FindBy(xpath="//div[@class='pull-right']")
private WebElement iHaveReadStaticText;

@FindBy(xpath="//ul[@class='breadcrumb']/li/a/i")
private WebElement regHomeIcon;
@FindBy(css="div[class='alert alert-danger']")
private WebElement alreadyRegAccErrMsg;
@FindBy(xpath="//h1[contains(text(),'Your Account')]")
private WebElement accntCreatedHeader;
@FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
private WebElement accntCreatedSuccMsg;
@FindBy(css="a.btn.btn-primary")
private WebElement accntCreatedContinueBtn;

//Your Address Section Fields
@FindBy(xpath="//legend[text()='Your Address']")
private WebElement yourAddressText;
@FindBy(css="input#input-company")
private WebElement companyEditBox;
@FindBy(css="input[name='address_1']")
private WebElement address1EditBox;
@FindBy(css="input[name='address_2']")
private WebElement address2EditBox;
@FindBy(css="input#input-postcode")
private WebElement postCodeEditBox;
@FindBy(css="select#input-country")
private WebElement countryDropdown;
@FindBy(css="input#input-city")
private WebElement cityEditBox;
@FindBy(css="select#input-zone")
private WebElement stateDropdown;

//Your Password Text
@FindBy(xpath="//legend[text()='Your Password']")
private WebElement yourPswdText;
@FindBy(css="input#input-password")
private WebElement passwordEditBox;
@FindBy(css="input#input-confirm")
private WebElement passwordConfirmEditBox;
@FindBy(xpath="//input[@name='newsletter'and @value='1']")
private WebElement subscribeYesRadioBtn;
@FindBy(xpath="//input[@name='newsletter'and@value='0']")
private WebElement subscribeNoRadioBtn;
@FindBy(xpath="//div[@class='pull-right']/a")
private WebElement privacyPolicyLink;
@FindBy(css="button[class='close']")
private WebElement privacyPolicyLinkPopup;
@FindBy(xpath="//input[@type='checkbox'  and @name='agree']")
private WebElement policyCheckBox;
@FindBy(css="input.btn.btn-primary")
private WebElement continueButton;
@FindBy(xpath="//div[@class='list-group']/a[2]")
private WebElement regPgRegisterLink;
@FindBy(xpath="//div[@class='list-group']/a[3]")
private WebElement regPgForgotPswdLink;

public String getAccountCreatedHeader() throws InterruptedException {
	return getText(accntCreatedHeader);
}

public String getAccntCreatedSuccMsg() throws InterruptedException {
	return getText(accntCreatedSuccMsg);
}

public void clickRegPgLoginLink() throws InterruptedException {
	click(registerAccLoginPageLink);
}

public void clickRegPgRegisterLink() throws InterruptedException {
	click(regPgRegisterLink);
}

public void setFirstName(String fName) throws InterruptedException {
	log.info("entering the fname value");
	sendData(firstNameEditBox, fName);
}

public void setLastName(String lastName) throws InterruptedException {
	log.info("entering lastName value");
	sendData(lastNameEditBox, lastName);
}

public void setEmail(String email) throws InterruptedException {
	log.info("entering email address value");
	sendData(emailEditBox, email);
}

public void setTelephone(String telephone) throws InterruptedException {
	log.info("entering telephone number");
	sendData(telephoneEditBox, telephone);
}

public void setPassword(String pwd) throws InterruptedException {
	log.info("entering password value");
	sendData(passwordEditBox, pwd);
}

public void setPasswordConfirm(String pwdc) throws InterruptedException {
	log.info("entering PasswordConfirm value");
	sendData(passwordConfirmEditBox, pwdc);
}

public void selectSubscribe(String subscribe) throws InterruptedException  {
	log.info("select Subscribe value");
	if(subscribe.equalsIgnoreCase("Yes")) {
		log.info("Select Yes radio button");
		click(subscribeYesRadioBtn);
	}else {
		log.info("Select No radio button");
		click(subscribeNoRadioBtn);
	}
}

public void selectPolicyCheckBox() throws InterruptedException {
	log.info("Select agree to privacy policy checkBox");
	click(policyCheckBox);
}

public void clickOnContinue() throws InterruptedException {
	log.info("click On Continue button");
	click(continueButton);
}

public void clickHomeIcon() {
	log.info("click on Home Icon");
	jsUtils.clickElementByJS(regHomeIcon);
}

public String getAlreadyRegAccErrMsg() throws InterruptedException {
	return getText(alreadyRegAccErrMsg);
}

public void clickOnAccntCreatedContinueBtn() throws InterruptedException {
	log.info("click on account created continue button");
	click(accntCreatedContinueBtn);
}

public void setFax(String fax) throws InterruptedException {
	log.info("enter the fax value in fax edit box");
	sendData(faxEditBox, fax);
}

public void setCompany(String company) throws InterruptedException {
	if(!company.isEmpty()) {
	log.info("enter the company name in company editbox");
	sendData(companyEditBox, company);
}
}
public void setAddress1(String address1) throws InterruptedException {
	log.info("enter the address in address editbox");
	sendData(address1EditBox, address1);
}

public void setAddress2(String address2) throws InterruptedException {
	log.info("enter the address in address editbox");
	sendData(address2EditBox, address2);
}

public void setCity(String city) throws InterruptedException {
	log.info("enter the city in city editbox");
	sendData(cityEditBox, city);
}

public void setPostCode(String postCode) throws InterruptedException {
	log.info("enter the postcode in postcode editbox");
	sendData(postCodeEditBox, postCode);
}

public void selectCountry(String optionTxt) {
	log.info("select option from country dropdown");
	selectOptionByVisibleText(countryDropdown, optionTxt);
}

public void selectState(String visibleText) {
	log.info("select option from state dropdown");
	waitForPageLoad(2000);
	selectOptionByVisibleText(stateDropdown, visibleText);
}

public void clickOnRegPgPrivacyPolicyLink() throws InterruptedException {
	log.info("click On RegPg Privacy Policy Link");
	click(privacyPolicyLink);
	
}
public void clickPolicyLinkPopupCrosslink() throws InterruptedException {
	log.info("click on policy popup cross link");
	click(privacyPolicyLinkPopup);
}

public void clickOnForgotPswdLink() throws InterruptedException {
	log.info("click on forgot password link");
	click(regPgForgotPswdLink);
}

public void fillAddressDetails(String company,String address1,String address2,String city,String postCode,String optionTxt,String attrVal) throws InterruptedException {
	try {
		setCompany(company);
		setAddress1(address1);
		setAddress2(address2);
		setCity(city);
		setPostCode(postCode);
		selectCountry(optionTxt);
		selectState(attrVal);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
