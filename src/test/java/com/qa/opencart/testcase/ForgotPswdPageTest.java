package com.qa.opencart.testcase;

import org.testng.annotations.Test;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.factory.WebDriverFactory;
import com.qa.opencart.pages.ForgotYourPasswordPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.Constants;

import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ForgotPswdPageTest extends TestBase{
private static Logger log=LogManager.getLogger(ForgotPswdPageTest.class.getName());
	//String email;
@BeforeClass
public void beforeClass() throws InterruptedException {
	  log.info("initialising the page class objects");
	  homePg=new HomePage(driver);
	  loginPg=new LoginPage(driver);
	  forgotYourPswdPg=new ForgotYourPasswordPage(driver);
	  homePg.goToLoginPage();
}
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  
	  loginPg.waitForPageLoad(2000);
	  loginPg.clickOnForgottenPassword();
	  
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	 
  }

  
  @Test(description="TC_03_positive case",priority=3)
  public void setRandomEmailTest() throws InterruptedException {
	 	  
	  forgotYourPswdPg.waitForPageLoad(2000);
	
	  String email=WebDriverFactory.randomAlphaNumeric();
	  forgotYourPswdPg.setEmailAddress(email);
	  forgotYourPswdPg.clickOnContinue();
	 
	  Assert.assertEquals(forgotYourPswdPg.emailAddrNotFoundWarning(), Constants.EMAIL_ADDRESS_NOT_FOUND_MSG);
	  forgotYourPswdPg.clickOnBack();
  }
  
  @Test(description="TC_04_Validating continue button",priority=4)
  public void withoutFillingEmailTest() throws InterruptedException {
	
	  forgotYourPswdPg.waitForPageLoad(2000);
	  Assert.assertEquals(forgotYourPswdPg.getTitle(), Constants.FORGOT_PWD_PAGE_TITLE);
	  log.info("click on continue btn from forgotPwd page");
	  forgotYourPswdPg.clickOnContinue();
	  
	 Assert.assertEquals(forgotYourPswdPg.emailAddrNotFoundWarning(), Constants.EMAIL_ADDRESS_NOT_FOUND_MSG);
	 forgotYourPswdPg.clickOnBack();
  }
  @Test(description="TC_05_validating back link",priority=5)
  public void validatingBackLinkTest() throws InterruptedException {
	 	  
	  forgotYourPswdPg.waitForPageLoad(2000);
	  Assert.assertTrue(forgotYourPswdPg.getURL().contains(Constants.FORGOT_PWD_PAGE_FRACTION_URL));
	  log.info("click on back link");
	  forgotYourPswdPg.clickOnBack();
	  
  }
  @Test(description="TC_06_click on forgotPswdLink from register page",priority=6)
  public void navigatingToForgotPswdPgFromRegPgTest() throws InterruptedException {
	   
	  forgotYourPswdPg.waitForPageLoad(2000);
	  forgotYourPswdPg.setEmailAddress("rameshqaonline@gmail.com");
	  forgotYourPswdPg.clickOnContinue();
	  loginPg.waitForPageLoad(2000);
	  Assert.assertEquals(loginPg.getloginPgConformationSuccMsgFromForgotPg(),Constants.EMAIL_CONFORMATION_LINK_MSG);
  }
  @Test(description="TC_02_verifying is Your EmailAddrTxtAvailable",priority=2)
  public void verifyIsYourEmailAddrTxtAvailableTest() throws InterruptedException {
	 
	  log.info("verifying IsYourEmailAddrTxtAvailable");
	 Assert.assertTrue(forgotYourPswdPg.isYourEmailAddrTxtAvailable()); 
	 
  }
  @Test(description="TC_01_verifying isForgotYourPswdHeaderTxtAvailable",priority=1)
  public void verifyIsForgotYourPswdHeaderTxtAvailableTest() throws InterruptedException {
	  
	  log.info("verifying isForgotYourPswdHeaderTxtAvailable");
	  Assert.assertTrue(forgotYourPswdPg.isForgotYourPswdHeaderTxtAvailable());
	 
  }
}
