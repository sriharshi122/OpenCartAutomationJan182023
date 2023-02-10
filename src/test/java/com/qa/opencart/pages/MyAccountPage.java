package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.JavaScriptUtils;
import com.qa.opencart.utils.WebDriverUtils;

import io.qameta.allure.Step;

public class MyAccountPage extends WebDriverUtils{
	private Logger log=LogManager.getLogger(MyAccountPage.class.getName());
	JavaScriptUtils jsUtils;
	private WebDriver driver;
	
public MyAccountPage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	jsUtils=new JavaScriptUtils(driver);
			  
	}
@FindBy(css="input[name='search']")
private WebElement myAccSearchEditBox;
@FindBy(css="button.btn.btn-default.btn-lg")
private WebElement myAccSearchIcon;
@FindBy(xpath="//ul[@class='breadcrumb']/li[2]/a[text()='Account']")
private WebElement myAccntBreadCrumb;
@FindBy(xpath="//ul[@class='breadcrumb']/li/a")
private WebElement myAccntHomeIcon;
@FindBy(xpath="//a[text()='Your Store']")
private WebElement myAccntYourStoreLink;
@FindBy(css="div#content>h2")
private WebElement myAccntHeaderText;
@FindBy(xpath="//ul[@class='list-unstyled']/li[1]/a[text()='Edit your account information']")
private WebElement editYourAccntLink;
@FindBy(xpath="//ul[@class='list-unstyled']/li[2]/a[text()='Change your password']")
private WebElement changeYourPswdLink;
@FindBy(xpath="//ul[@class='list-unstyled']/li[3]/a[text()='Modify your address book entries']")
private WebElement modifyYourAddLink;
@FindBy(xpath="//ul[@class='list-unstyled']/li[4]/a[text()='Modify your wish list']")
private WebElement modifyYourWishLink;
@FindBy(xpath="//h2[text()='My Orders']")
private WebElement myOrdersHeaderText;
@FindBy(xpath="//ul[@class='list-unstyled']/li[1]/a[text()='View your order history']")
private WebElement viewYourOrderLink;
@FindBy(xpath="//ul[@class='list-unstyled']/li[2]/a[text()='Downloads']")
private WebElement myOrderdownloadsLink;
@FindBy(xpath="//ul[@class='list-unstyled']/li[3]/a[text()='Your Reward Points']")
private WebElement yourRewardPointsLink;
@FindBy(xpath="//ul[@class='list-unstyled']/li[4]/a[text()='View your return requests']")
private WebElement viewYourReturnRequestsLink;
@FindBy(xpath="//ul[@class='list-unstyled']/li[5]/a[text()='Your Transactions']")
private WebElement yourTransactionsLink;
@FindBy(xpath="//ul[@class='list-unstyled']/li[6]/a[text()='Recurring payments']")
private WebElement myOrderrecurringPaymentsLink;
@FindBy(xpath="//h2[text()='My Affiliate Account']")
private WebElement myAffiliateAccntHeaderText;
@FindBy(xpath="//ul[@class='list-unstyled']/li[1]/a[text()='Register for an affiliate account']")
private WebElement registerForAnAffiliateLink;
@FindBy(xpath="//h2[text()='Newsletter']")
private WebElement newsLetterHeaderText;
@FindBy(xpath="//a[contains(text(),'Subscribe')]")
private WebElement subscribeLink;
@FindBy(xpath="//div[@class='list-group']/a")
private WebElement myAccountLink;
@FindBy(xpath="//div[@class='list-group']/a[2]")
private WebElement editAccountLink;
@FindBy(xpath="//div[@class='list-group']/a[3]")
private WebElement passwordLink;
@FindBy(xpath="//div[@class='list-group']/a[4]")
private WebElement addressBookLink;
@FindBy(xpath="//div[@class='list-group']/a[5]")
private WebElement wishListLink;
@FindBy(xpath="//div[@class='list-group']/a[6]")
private WebElement orderHistoryLink;
@FindBy(xpath="//div[@class='list-group']/a[7]")
private WebElement downloadsLink;
@FindBy(xpath="//div[@class='list-group']/a[8]")
private WebElement recurringPaymentsLink;
@FindBy(xpath="//div[@class='list-group']/a[9]")
private WebElement rewardPointsLink;
@FindBy(xpath="//div[@class='list-group']/a[10]")
private WebElement returnsLink;
@FindBy(xpath="//div[@class='list-group']/a[11]")
private WebElement transactionsLink;
@FindBy(xpath="//div[@class='list-group']/a[12]")
private WebElement newsLetterLink;
@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[5]/a")
private WebElement logoutLink;
@FindBy(xpath="//span[text()='My Account']")
private WebElement myAccntMenu;
//List collection
@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li/a")
private List<WebElement>myAccMenuOptionList;
@FindBy(css="div[id='content']>h2")
private List<WebElement>myAccHeaderLists;
@FindBy(linkText="Logout")
private WebElement myAccMenuLogoutLink;

@Step("click on my account menu")
public void clickOnMyAccntMenu() throws InterruptedException {
	click(myAccntMenu);
}


@Step("click on Logout link")
public void clickOnLogout() throws InterruptedException {
	clickOnMyAccntMenu();
	waitForElementVisible(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[5]/a"));
	click(logoutLink);
}

@Step("Get My Account page url")
public String getMyAccountPageUrl() {
	return waitForUrlContains(Constants.MY_ACC_PAGE_FRACTION_URL);
}

public boolean isSearchExists() {
	return waitForElementVisible(By.cssSelector("input[name='search']")).isDisplayed();
}

public boolean isLogoutExists() throws InterruptedException {
	clickOnMyAccntMenu();
	return waitForElementVisible(By.linkText("Logout")).isDisplayed();
}

public List<String> getMyAccMenuOptionList(){
	//generic form
	List<String>myAccountMenuOptionList=new ArrayList<>();
	//iterate the collection
	for(WebElement el: myAccMenuOptionList) {
		String elTxt=el.getText();
		//add options to myAccountMenuOptionList using add()
		myAccountMenuOptionList.add(elTxt);
	}
	return myAccountMenuOptionList;
}

public List<String> getMyAccHeaderList(){
	List<String>MyAccountHeaderList=new ArrayList<>();
	//iterate the collection
	for(WebElement el:myAccHeaderLists) {
		String elTxt=el.getText();
		//add the elements to MyAccountHeaderList collection
		MyAccountHeaderList.add(elTxt);
	}
	return MyAccountHeaderList;
}

public ResultsPage doProductSearch(String productName) throws InterruptedException {
	log.info("search product name in search edit box:"+productName);
	try {
		if(isSearchExists()) {
			sendData(myAccSearchEditBox, productName);
			jsUtils.clickElementByJS(myAccSearchIcon);
			return new ResultsPage(driver);
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
}
