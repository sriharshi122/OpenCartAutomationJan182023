package com.qa.opencart.testcase;

import org.testng.annotations.Test;

import com.qa.opencart.factory.TestBase;

import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;

import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class HomePageTest extends TestBase{
	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	  @BeforeClass
	  public void beforeClass() {
		  log.info("initialising the page class objects");
		  homePg=new HomePage(driver);
		  regPg=new RegistrationPage(driver);
		  loginPg= new LoginPage(driver);
		  
	  }
  @BeforeMethod
  public void beforeMethod() {
	  homePg.waitForPageLoad(2000);
  }

  @AfterMethod
  public void afterMethod() {
	  homePg.waitForPageLoad(2000);
	  Assert.assertEquals(homePg.getTitle(),Constants.HOME_PAGE_TITLE);
	  
  }

 
  @Test(description="TC_01_Verifying the opencartLogo", priority=1)
  public void verifyOpenCartLogoTest() throws InterruptedException {
	 
	  log.info("Verify the home page logo text");
	  Assert.assertTrue(homePg.isOpenCartLogoExist() );
  }
  
  @Test(description="TC_02_Verifying the opencart Title", priority=2)
  public void verifyOpenCartTitleTest() throws InterruptedException {
	  
	  log.info("Verify the opencart title");
	 	  Assert.assertEquals(homePg.getTitle(),Constants.HOME_PAGE_TITLE);
	  
  }

  @Test(description="TC_03_navigate to registration page", priority=3)
  public void navigateToRegistrationPageTest() throws InterruptedException {
	  
	  log.info("TC_03_navigate to registration page");
	  log.info("Click on my Account menu");
	  homePg.navigateToRegisterPage();
	  log.info("wait for regPg title");
	  regPg.waitForPageLoad(2000);
	  log.info("Assert the Registration page title");
	  Assert.assertEquals(regPg.getTitle(),Constants.REGISTRATION_PAGE_TITLE);
	  log.info("Click on Home icon in Registration page");
	  regPg.clickHomeIcon();
	 
	  
  }
  @Test(description="TC_04_navigate to login page", priority=4)
  public void navigateToLoginPageTest() throws InterruptedException {
	  
	  log.info("TC_04_navigate to login page");
	  homePg.goToLoginPage();
	  loginPg.waitForPageLoad(2000);
	  log.info("Assert the login page title");
	  Assert.assertEquals(loginPg.getTitle(), Constants.LOGIN_PAGE_TITLE);
	  log.info("Click on Home icon in Login page");
	  loginPg.clickOnHomeIcon();
	  
  }

}
