package com.qa.opencart.testcase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.ProductsDetailsPage;
import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.utils.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ProductsDetailsPageTest extends TestBase {
	private Logger log=LogManager.getLogger(ProductsDetailsPageTest.class.getName());
 

  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  log.info("intializing the page class objects");
	  homePg=new HomePage(driver);
	  resultsPg=new ResultsPage(driver);
	  productsdetailsPg=new ProductsDetailsPage(driver);
	  loginPg=new LoginPage(driver);
	  myaccountPg = new MyAccountPage(driver);
	  logoutPg=new LogoutPage(driver);
	  homePg.goToLoginPage();
	  loginPg.waitForPageLoad(2000);
	  loginPg.clickOnLogin(rb.getString("username"), rb.getString("pwd"));
  }

 
  @BeforeMethod
  public void beforeMethod() {
	  myaccountPg.waitForPageLoad(2000); 
  }
  
@DataProvider
public Object[][] getProductsSearchData(){
	return new Object[][] {
		{"Macbook","MacBook Pro"},
		{"Macbook","MacBook Air"},
		{"imac","iMac"},
		{"samsung","Samsung SyncMaster 941BW"},
		{"Apple","Apple Cinema 30\""}
	};
	}

  @Test(dataProvider="getProductsSearchData")
  public void productHeaderTest(String key,String productName) throws InterruptedException {
	  resultsPg= myaccountPg.doProductSearch(key);
	 resultsPg.waitForPageLoad(2000);
	  productsdetailsPg= resultsPg.selectSearchProduct(productName);
	  productsdetailsPg.waitForPageLoad(2000);
	 String productHeaderName= productsdetailsPg.getProductHeader();
	 Assert.assertEquals(productHeaderName, productName);
  }
 
  @DataProvider
  public Object[][] getProductsImageData(){
	  return new Object[][] {
		  {"Macbook","MacBook Pro",4},
			{"Macbook","MacBook Air",4},
			{"imac","iMac",3},
			{"samsung","Samsung SyncMaster 941BW",1},
			{"Apple","Apple Cinema 30\"",6}
		};
	  }
  @Test(dataProvider="getProductsImageData")
  public void productImagesTest(String key,String productName,int imgCount) throws InterruptedException {
	  resultsPg=myaccountPg.doProductSearch(key);
	  resultsPg.waitForPageLoad(2000);
	  productsdetailsPg =resultsPg.selectSearchProduct(productName);
	  productsdetailsPg.waitForPageLoad(2000);
	 int actualImagCount= productsdetailsPg.getProductImgCount();
	 Assert.assertEquals(actualImagCount, imgCount);
  }
  @Test
  public void productMetaDataTest() throws InterruptedException {
	  resultsPg=myaccountPg.doProductSearch("Macbook");
	  resultsPg.waitForPageLoad(2000);
	  productsdetailsPg =resultsPg.selectSearchProduct("MacBook Pro"); 
	  productsdetailsPg.waitForPageLoad(2000);
	  Map<String,String>actualProductInfoMap=productsdetailsPg.getProductInformation();
	  SoftAssert softAssert=new SoftAssert();
	  softAssert.assertEquals(actualProductInfoMap.get("Brand"), "Apple");
	  softAssert.assertEquals(actualProductInfoMap.get("Product Code"), "Product 18");
	  softAssert.assertEquals(actualProductInfoMap.get("Reward Points"), "800");
	  softAssert.assertEquals(actualProductInfoMap.get("Availability"), "In Stock");
	  softAssert.assertEquals(actualProductInfoMap.get("actualPrice"), "$2,000.00");
	  softAssert.assertAll(); 
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

