package com.qa.opencart.testcase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MyAccountPageTest extends TestBase {

	private Logger log = LogManager.getLogger(MyAccountPageTest.class.getName());

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		log.info("to intialize the page class objects");
		homePg = new HomePage(driver);
		loginPg=new LoginPage(driver);
		myaccountPg = new MyAccountPage(driver);
		resultsPg = new ResultsPage(driver);
		logoutPg=new LogoutPage(driver);
		homePg.goToLoginPage();
		loginPg.waitForPageLoad(2000);
		loginPg.clickOnLogin(rb.getString("username"), rb.getString("pwd"));
	}

	@BeforeMethod
	public void beforeMethod() {
		//myaccountPg.waitForPageLoad(2000);
	}

	@Severity(SeverityLevel.MINOR)
	@Test(description = "TC_03_Verifying search box exists or not", priority = 3)
	public void verifyingSearchBoxExistsTest() {
		log.info("verifying is SearchBox Exists or not");
		Assert.assertTrue(myaccountPg.isSearchExists());
	}

	@Severity(SeverityLevel.MINOR)
	@Test(description = "TC_04_verifying Logout link Exists or not", priority = 4)
	public void verifyingLogoutExistsTest() throws InterruptedException {
		log.info("verifying is Logout Exists or not");
		Assert.assertTrue(myaccountPg.isLogoutExists());
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(description = "TC_01_verifying MyAccount Page Url", priority = 1)
	public void verifyingMyAccountPgUrl() {
		myaccountPg.waitForPageLoad(2000);
		log.info("verifying my account pg Url");
		Assert.assertTrue(myaccountPg.getMyAccountPageUrl().contains(Constants.MY_ACC_PAGE_FRACTION_URL));
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(description = "TC_02_verifying my account page title", priority = 2)
	public void verifyingMyAccountPgTitle() {
		log.info("verifying my account pg title");
		Assert.assertEquals(myaccountPg.getTitle(), Constants.MY_ACCOUNT_PAGE_TITLE);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(description = "TC_05_Verifying MyAccMenuOptionList", priority = 5)
	public void verifyingMyAccMenuOptionList() throws InterruptedException {
		log.info("verifying MyAccMenuOptionList");
		Assert.assertEquals(myaccountPg.getMyAccMenuOptionList(), Constants.EXP_MY_ACC_MENU_OPTION_LIST);
		myaccountPg.clickOnMyAccntMenu();
	}

	@Test(description = "TC_06_Verifying MyAccHeaderList", priority = 6)
	public void verifyingMyAccHeaderList() {
		log.info("verifying MyAccHeaderList");
		Assert.assertEquals(myaccountPg.getMyAccHeaderList(), Constants.EXP_MY_ACC_HEADERTXT_LIST);
	}

	@DataProvider(name = "products")
	public Object[][] productTest() {
		// Object[][] data=new Object[3][1];
		//Object[][] data;

		return new Object[][] {
			{ "iMac" },
			{ "Samsung" },
			{ "MacBook" }
			};
	}

	@Test(description = "TC_07_validating product search", priority = 7, dataProvider = "products")
	public void productSearchTest(String productName) throws InterruptedException {
		resultsPg = myaccountPg.doProductSearch(productName);
		resultsPg.waitForPageLoad(2000);
		String actualresultTitle = resultsPg.getTitle();
		//resultsPg.waitForPageLoad(2000);
		new SoftAssert().assertEquals(actualresultTitle, "Search -" + productName);
		Assert.assertTrue(resultsPg.getSearchProductsSize() > 0);
		resultsPg.clickOnMyAccOption();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		myaccountPg.waitForPageLoad(2000);
		myaccountPg.clickOnLogout();
		logoutPg.waitForPageLoad(2000);
		Assert.assertEquals(logoutPg.getTitle(), Constants.ACCOUNT_LOGOUT_PAGE_TITLE);
		logoutPg.clickOnContinueBtn();
		homePg.waitForPageLoad(2000);
		Assert.assertEquals(homePg.getTitle(), Constants.HOME_PAGE_TITLE);
	}
}
