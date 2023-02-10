package com.qa.opencart.testcase;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.qa.opencart.factory.TestBase;
import com.qa.opencart.factory.WebDriverFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtils;

import java.io.IOException;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class RegistrationPageTest extends TestBase {
	private Logger log = LogManager.getLogger(RegistrationPageTest.class);
	String fName;
	String lName;
	String email;
	String telephone;
	String fax;
	String company;
	String address1;
	String address2;
	String city;
	String postCode;
	String country;
	String state;
	
	
	  @BeforeClass
	  
	  public void setupRegData() { 
		  Faker fkobj=new Faker(new Locale("en-US"));
	  fName=fkobj.address().firstName(); 
	  lName=fkobj.address().lastName();
	  email=fkobj.internet().emailAddress();
	  telephone=fkobj.phoneNumber().cellPhone();
	  fax=fkobj.phoneNumber().phoneNumber(); 
	  company=fkobj.company().name();
	  address1=fkobj.address().buildingNumber();
	  address2=fkobj.address().latitude(); 
	  city=fkobj.address().city();
	  postCode=fkobj.address().zipCode();
	  System.out.println("postCode is:"+postCode);
	  country="United States";
	  System.out.println("country is:"+country); 
	 // state=fkobj.address().state();
	  state="California";
	  System.out.println("state is:"+state); }
	 
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		log.info("intialising the page class objects");
		homePg = new HomePage(driver);
		regPg = new RegistrationPage(driver);
		logoutPg=new LogoutPage(driver);
		myaccountPg = new MyAccountPage(driver);
	}

	@BeforeMethod
	public void preCondition() throws InterruptedException {
		homePg.navigateToRegisterPage();
		log.info("verify the registration page title");
		regPg.waitForPageLoad(2000);
		Assert.assertEquals(regPg.getTitle(), Constants.REGISTRATION_PAGE_TITLE);
	}

	private String getRandomEmail() {
		return WebDriverFactory.randomeString()+ "@gmail.com";
	}

	
	  @Test public void registrationTest() throws InterruptedException { try {
	  log.info("navigate to registration page"); String fName =
	  WebDriverFactory.randomeString(); log.info("Set the firstName:" + fName);
	  regPg.setFirstName(fName); String lName = WebDriverFactory.randomeString();
	  log.info("Set the last Name:" + lName); regPg.setLastName(lName); String
	  email = getRandomEmail(); log.info("Set the email:" + email);
	  regPg.setEmail(email); String telephone = WebDriverFactory.randomeNumber();
	  log.info("Set the telephone nbr:" + telephone);
	  regPg.setTelephone(telephone); log.info("Entering Address details....");
	  regPg.fillAddressDetails(company,address1 , address2, city,postCode ,
	  country, state); String pwd = WebDriverFactory.randomAlphaNumeric();
	  log.info("Set the password:" + pwd); regPg.setPassword(pwd);
	  log.info("Set the confirm password:" + pwd); regPg.setPasswordConfirm(pwd);
	  log.info("Select the subscribe radio button:Yes");
	  regPg.selectSubscribe("Yes"); log.info("check the privacy checkBox");
	  regPg.selectPolicyCheckBox(); log.info("Click on continue button");
	  regPg.clickOnContinue(); regPg.waitForPageLoad(2000);
	  log.info("verify account created header and success msg");
	  Assert.assertEquals(regPg.getAccountCreatedHeader(),
	  Constants.YOUR_ACCOUNT_CREATED_HEADER);
	  Assert.assertEquals(regPg.getAccntCreatedSuccMsg(),
	  Constants.YOUR_ACCOUNT_CREATED_SUCC_MSG);
	  log.info("click on continue button"); regPg.clickOnAccntCreatedContinueBtn();
	  myaccountPg.waitForPageLoad(2000);
	  log.info("validate the my account page title");
	  Assert.assertEquals(myaccountPg.getTitle(), Constants.MY_ACCOUNT_PAGE_TITLE);
	  log.info("click on logout page"); myaccountPg.clickOnLogout();
	  log.info("validate the logout page title");
	  Assert.assertEquals(logoutPg.getLogoutPgTitle(),
	  Constants.ACCOUNT_LOGOUT_PAGE_TITLE);
	  log.info("click on logout page continue button");
	  logoutPg.clickOnContinueBtn();
	  
	  } catch (InterruptedException e) { log.info("Account creation failed");
	  e.printStackTrace(); } }
	 
	@Test(description="TC_02_Giving different pswds for pswd and confirm pswd", priority=2)
	public void registrationPgNegativeCases() throws InterruptedException {
		log.info("navigate to registration page");
		String fName = WebDriverFactory.randomeString();
		log.info("Set the firstName:" + fName);
		regPg.setFirstName(fName);
		String lName = WebDriverFactory.randomeString();
		log.info("Set the last Name:" + lName);
		regPg.setLastName(lName);
		//String email = getRandomEmail();
		//log.info("Set the email:" + email);
		regPg.setEmail("kiran73731@gmail.com");
		String telephone = WebDriverFactory.randomeNumber();
		log.info("Set the telephone nbr:" + telephone);
		regPg.setTelephone(telephone);
		String company=WebDriverFactory.randomeString();
		log.info("Setting the company name:"+company);
		regPg.setCompany(company);
		String address1=WebDriverFactory.randomeString();
		log.info("Setting the company name:"+address1);
		regPg.setAddress1(address1);
		String address2=WebDriverFactory.randomeString();
		log.info("Setting the company name:"+address2);
		regPg.setAddress2(address2);
		String city=WebDriverFactory.randomeString();
		log.info("Setting the company name:"+city);
		regPg.setCity(city);
		String postcode=WebDriverFactory.randomeString();
		log.info("Setting the company name:"+postcode);
		regPg.setPostCode(postcode);
		
		regPg.selectCountry(country);
		/*
		 * String state=WebDriverFactory.randomeString();
		 * log.info("Setting the company name:"+state);
		 */
		regPg.selectState(state);
		String pwd = WebDriverFactory.randomAlphaNumeric();
		log.info("Set the password");
		regPg.setPassword(pwd);
		String confirmPwd = WebDriverFactory.randomAlphaNumeric();
		log.info("Setting the confirm password editbox");
		regPg.setPasswordConfirm(confirmPwd);
		log.info("Select the subscribe radio button:Yes");
		regPg.selectSubscribe("Yes");
		log.info("check the privacy checkBox");
		regPg.selectPolicyCheckBox();
		log.info("Click on continue button");
		regPg.clickOnContinue();
	}
	@Test(description="TC_01_Validating Register page login link", priority=1)
	public void validatingLoginPgLink() throws InterruptedException {
		log.info("click on login page link from register page");
		regPg.clickRegPgLoginLink();
		
		/*
		 * loginPg.waitForPageLoad(2000); loginPg.clickLoginPgRegisterLink();
		 */
		
	}
	
	@Test(description="Tc_03_Validating privacy policy link", priority=3)
	public void validatingPrivacyPolicyLink() throws InterruptedException {
		log.info("click on register page privacy policy link");
		regPg.clickOnRegPgPrivacyPolicyLink();
		regPg.clickPolicyLinkPopupCrosslink();
	}
	
	@Test(description="TC_04_Click on register pg continue button", priority=4)
	public void registerPgContinueBtn() throws InterruptedException {
		log.info("click on continue btn without filling mandatory fields");
		regPg.clickOnContinue();
	}
	
	@Test(description="TC_05_Giving existing email",priority=5)
	public void existingEmailErrMsg() throws InterruptedException {
		log.info("navigate to registration page");
		String fName = WebDriverFactory.randomeString();
		log.info("Set the firstName:" + fName);
		regPg.setFirstName(fName);
		String lName = WebDriverFactory.randomeString();
		log.info("Set the last Name:" + lName);
		regPg.setLastName(lName);
		//log.info("Set the email:" + email);
		regPg.setEmail("kiran73731@gmail.com");
		String telephone = WebDriverFactory.randomeNumber();
		log.info("Set the telephone nbr:" + telephone);
		regPg.setTelephone(telephone);
		String company=WebDriverFactory.randomeString();
		log.info("Setting the company name:"+company);
		regPg.setCompany(company);
		String address1=WebDriverFactory.randomeString();
		log.info("Setting the company name:"+address1);
		regPg.setAddress1(address1);
		String address2=WebDriverFactory.randomeString();
		log.info("Setting the company name:"+address2);
		regPg.setAddress2(address2);
		String city=WebDriverFactory.randomeString();
		log.info("Setting the company name:"+city);
		regPg.setCity(city);
		String postcode=WebDriverFactory.randomeString();
		log.info("Setting the company name:"+postcode);
		regPg.setPostCode(postcode);
		regPg.selectCountry(country);
		regPg.selectState(state);
		String pwd = WebDriverFactory.randomAlphaNumeric();
		log.info("Set the password");
		regPg.setPassword(pwd);
		regPg.setPasswordConfirm(pwd);
		regPg.selectSubscribe("Yes");
		log.info("check the privacy checkBox");
		regPg.selectPolicyCheckBox();
		log.info("Click on continue button");
		regPg.clickOnContinue();
		Assert.assertEquals(regPg.getAlreadyRegAccErrMsg(),Constants.ALREADY_REG_ACC_ERR_MSG);
	}
	
	  @DataProvider public Object[][] regTestData() throws InvalidFormatException,
	  IOException{ Object[][] data=new
	  ExcelUtils().getTestData(Constants.TEST_DATA_FILE_PATH,Constants.
	  REGISTER_SHEET_NAME); return data; }
	  
	  @Test(dataProvider="regTestData") public void
	  registrationDataDrivenTest(String fName, String lName, String telephone,
	  String pwd, String subscribe) throws InterruptedException {
	  log.info("Set the firstName:" + fName); regPg.setFirstName(fName);
	  log.info("Set the last Name:" + lName); regPg.setLastName(lName); String
	  email = getRandomEmail(); log.info("setting the email:"+email);
	  regPg.setEmail(email); log.info("Set the telephone nbr:"+ telephone);
	  regPg.setTelephone(telephone); regPg.fillAddressDetails(company, address1,
	  address2, city, postCode, country, state); log.info("Set the password:" +
	  pwd); regPg.setPassword(pwd); log.info("Set the confirm password:" + pwd);
	  regPg.setPasswordConfirm(pwd);
	  log.info("Select the subscribe radio button:Yes");
	  regPg.selectSubscribe(subscribe); log.info("check the privacy checkBox");
	  regPg.selectPolicyCheckBox(); log.info("Click on continue button");
	  regPg.clickOnContinue(); regPg.waitForPageLoad(2000);
	  log.info("verify account created header and success msg");
	  Assert.assertEquals(regPg.getAccountCreatedHeader(),
	  Constants.YOUR_ACCOUNT_CREATED_HEADER);
	  Assert.assertEquals(regPg.getAccntCreatedSuccMsg(),
	  Constants.YOUR_ACCOUNT_CREATED_SUCC_MSG);
	  log.info("click on continue button"); regPg.clickOnAccntCreatedContinueBtn();
	  myaccountPg.waitForPageLoad(2000);
	  log.info("validate the my account page title");
	  Assert.assertEquals(myaccountPg.getTitle(), Constants.MY_ACCOUNT_PAGE_TITLE);
	  log.info("click on logout page"); myaccountPg.clickOnLogout();
	  log.info("validate the logout page title");
	  Assert.assertEquals(logoutPg.getLogoutPgTitle(),
	  Constants.ACCOUNT_LOGOUT_PAGE_TITLE);
	  log.info("click on logout page continue button");
	  logoutPg.clickOnContinueBtn();
	  
	  }
	 
	
		/*
		 * @AfterMethod public void tearDown() throws InterruptedException {
		 * log.info("validate the my account page title");
		 * Assert.assertEquals(myaccountPg.getTitle(), Constants.MY_ACCOUNT_PAGE_TITLE);
		 * log.info("click on logout page"); myaccountPg.clickOnLogout();
		 * log.info("validate the logout page title");
		 * Assert.assertEquals(logoutPg.getLogoutPgTitle(),
		 * Constants.ACCOUNT_LOGOUT_PAGE_TITLE);
		 * log.info("click on logout page continue button");
		 * logoutPg.clickOnContinueBtn(); }
		 */
	 
}
