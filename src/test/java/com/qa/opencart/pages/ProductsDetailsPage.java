package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.WebDriverUtils;

public class ProductsDetailsPage extends WebDriverUtils{
	private WebDriver driver;
	private Logger log=LogManager.getLogger(ProductsDetailsPage.class.getName());
	public ProductsDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
@FindBy(xpath="//div[@class='col-sm-4']/h1")
private WebElement productHeader;
@FindBy(xpath="//ul[@class='thumbnails']/li/a")
private List<WebElement> productImageList;
@FindBy(xpath="//div[contains(text(),'Just when you thought iMac had everything')]")
private WebElement productStaticTxt;
@FindBy(xpath="(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li")
private List<WebElement> productMetaDataList;
@FindBy(xpath="(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li")
private List<WebElement> productPriceList;
@FindBy(css="button#button-cart")
private WebElement productAddToCartBtn;
private Map<String,String> productMap;

public String getProductHeader() {
	return productHeader.getText();
}

public int getProductImgCount() {
	return productImageList.size();
}

public void getproductMetaDataList(){
	productMap=new HashMap<String,String>();
	//productMap=new LinkedHashMap<String,String>();
	//productMap=new TreeMap<String,String>();
	//iterate the collection
	log.info("productMetaDataList size is:");
	productMetaDataList.size();
	for(WebElement pmd:productMetaDataList) {
		String metaTxt=pmd.getText();//Brand: Apple
		String[] metaDataArr=metaTxt.split(":");//["Brand","Apple"]
		String metaKey=metaDataArr[0].trim();//"Brand"
		String metaValue=metaDataArr[1].trim();//"Apple"
		//how to insert key and value in map
		productMap.put(metaKey, metaValue);
	
	}
	
}
public void getProductPriceList() {
	log.info("ProductPriceList size is:"+productPriceList.size());
	
	String price=productPriceList.get(0).getText().trim();
	String exTaxPrice=productPriceList.get(1).getText().trim();
	productMap.put("actualPrice", price);
	productMap.put("actualTaxPrice", exTaxPrice);
}

public Map<String,String> getProductInformation(){
	productMap=new HashMap<String,String>();
	getproductMetaDataList();
	getProductPriceList();
	return productMap;
}


}
