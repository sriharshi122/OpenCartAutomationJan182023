package com.qa.opencart.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.JavaScriptUtils;
import com.qa.opencart.utils.WebDriverUtils;

public class ResultsPage extends WebDriverUtils{
	private WebDriver driver;
	JavaScriptUtils jsUtils;
	private Logger log=LogManager.getLogger(ResultsPage.class.getName());
	public ResultsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		jsUtils=new JavaScriptUtils(driver);
		}
@FindBy(xpath="//span[text()='My Account']")
private WebElement resultsPgMyAccMenu;
@FindBy(css="div[class*='product-layout product-grid']")
private List<WebElement> searchProducts;
@FindBy(xpath="//a[text()='Search']")
private WebElement searchBreadCrumb;
@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[1]/a")
private WebElement resultsPgMyAccOption;
public void clickOnMyAccMenu() throws InterruptedException {
	log.info("click on my account menu");
	click(resultsPgMyAccMenu);
}
public void clickOnMyAccOption() throws InterruptedException {
	clickOnMyAccMenu();
	log.info("click on results page my account option in my account menu");
	click(resultsPgMyAccOption);
}
public String getSearchResultsPgTitle(String productName) {
	return waitForTitleContains(productName);
}

public int getSearchProductsSize() {
	return searchProducts.size();
}

public ProductsDetailsPage selectSearchProduct(String productName) {
	
		log.info("select product name:"+productName);
		driver.findElement(By.linkText(productName)).click();
	
	
	return new ProductsDetailsPage(driver);
}

}
