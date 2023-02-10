package com.qa.opencart.testcase;

import org.testng.annotations.Test;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.ForgotYourPasswordPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class LoginPageTest extends TestBase {
	private Logger log=LogManager.getLogger(LoginPageTest.class.getName());
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  log.info("initializing page class objects");
	  homePg=new HomePage(driver);
	  loginPg=new LoginPage(driver);
	  regPg=new RegistrationPage(driver);
	   logoutPg=new LogoutPage(driver);
	  forgotYourPswdPg=new ForgotYourPasswordPage(driver);
	   myaccountPg=new  MyAccountPage(driver);
	  homePg.goToLoginPage();
  }
  @BeforeMethod
  public void beforeMethod() {
	  loginPg.waitForPageLoad(2000);
  }
  @Severity(SeverityLevel.MINOR)
  @Test(description="TC_01_verifying LoginPg title",priority=1)
  public void verifyLoginPgTitleTest() {
	  log.info("verifying login page title");
	  Assert.assertEquals(loginPg.getTitle(), Constants.LOGIN_PAGE_TITLE);
  }
  @Severity(SeverityLevel.MINOR)
  @Test(description="TC_02_verifying LoginPage Url",priority=2)
  public void verifyLoginPgUrlTest() {
	  log.info("verifying login page Url");
	  Assert.assertTrue(loginPg.getLoginPageUrl().contains(Constants.LOGIN_PAGE_FRACTION_URL) );
	  
  }
  @Severity(SeverityLevel.MINOR)
  @Description("verifying NewCustomer Header Text Available Test")
  @Test(description="TC_03_verifying NewCustomer Header Text Available",priority=3)
  public void verifyingIsNewCustomerHeaderTextAvailableTest() {
	  log.info("verifying NewCustomer Header Text Available");
	  Assert.assertTrue(loginPg.isNewCustomerHeaderTextAvailable());
	  
  }
  @Severity(SeverityLevel.MINOR)
  @Test(description="TC_04_verifying Returning Customer HeaderText",priority=4)
  public void verifyingIsReturningCustomerHeaderTextTest() {
	  log.info("verifying Returning Customer HeaderText");
	  Assert.assertTrue(loginPg.isReturningCustomerHeaderTextAvailable());
  }
  @Severity(SeverityLevel.MINOR)
  @Test(description="TC_05_verifying ForgotPswdExists",priority=5)
  public void verifyForgotPswdExistsTest() throws InterruptedException {
	  log.info("verifying ForgotPswd link Exists or not");
	  Assert.assertTrue(loginPg.isForgotPswdExists());
  }
  @Severity(SeverityLevel.MINOR)
  @Test(description="TC_06_verifying RegisterAccountTextAvailable",priority=6)
  public void verifyingIsRegisterAccountTextAvailableTest() {
	  log.info("verifying isRegisterAccountTextAvailable");
	  Assert.assertTrue(loginPg.isRegisterAccountTextAvailable());
  }
  @Severity(SeverityLevel.CRITICAL)
  @Test(description="TC_07_validatingForgottenPswdLinkTest",priority=7)
  public void validatingForgottenPswdLinkTest() throws InterruptedException {
	 log.info("click on ForgottenPswdLinkTest"); 
	 loginPg.clickOnForgottenPassword();
	 forgotYourPswdPg.waitForPageLoad(2000);
	 Assert.assertEquals(forgotYourPswdPg.getTitle(), Constants.FORGOT_PWD_PAGE_TITLE);
	 forgotYourPswdPg.navigateBrowserBack();
	 loginPg.waitForPageLoad(2000);
  }
  @Severity(SeverityLevel.CRITICAL)
  @Test(description="TC_08_validatingForgottenPswdLinkTest",priority=8)
  public void validatingLoginPgContinueBtnTest() throws InterruptedException {
	  loginPg.clickOnContinue();
	  regPg.waitForPageLoad(2000);
	  Assert.assertEquals(regPg.getTitle(),Constants.REGISTRATION_PAGE_TITLE);
	  regPg.navigateBrowserBack();
	  loginPg.waitForPageLoad(2000);
  }
  @Severity(SeverityLevel.CRITICAL)
  @Test(description="TC_09_login to the open cart page",priority=9)
  public void loginTest() throws InterruptedException {
	  loginPg.clickOnLogin(rb.getString("username"),rb.getString("pwd"));
	  myaccountPg.waitForPageLoad(2000);
	  Assert.assertEquals(myaccountPg.getTitle(), Constants.MY_ACCOUNT_PAGE_TITLE);
	  
  }
  @AfterClass
  public void afterClass() throws InterruptedException {
	  myaccountPg.clickOnLogout();
	  logoutPg.waitForPageLoad(2000);
	  Assert.assertEquals(logoutPg.getTitle(), Constants.ACCOUNT_LOGOUT_PAGE_TITLE);
	  logoutPg.clickOnContinueBtn();
	  homePg.waitForPageLoad(2000);
	  Assert.assertEquals(homePg.getTitle(), Constants.HOME_PAGE_TITLE);
  }
}
