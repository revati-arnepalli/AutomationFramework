package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constant;
import com.qa.democart.utils.ElementUtil;

public class AccountsPage {
	/**  finding the locaters
	 *   call a construcor
	 *   write page Actions/methods (start from page title, and so on)
	 */
	private ElementUtil elementUtil;
	//private By yourStoreText=By.xpath("//*[@id=\"logo\"]/h1/a[contains(text(),'Your Store')]");
	
	//verify main header
	private By mainHeader=By.cssSelector("div#logo a");
	//verify all section headers
	private By accountSectionHeaders=By.cssSelector("div#content h2");
	private By searchText=By.cssSelector("div#search input");
	private By searchButton=By.cssSelector("div#search button");
	private By searchItemResult=By.cssSelector("div.product-layout .product-thumb");
	
	public AccountsPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
	}
	
	public String getAccountPageTitle() {
		return elementUtil.waitForTitleToBe(Constant.ACCOUNTS_PAGE_TITLE, 5);
	}
	
	public String getHeaderValue() {
		if(elementUtil.doIsDisplayed(mainHeader)) {
		return elementUtil.doGetText(mainHeader);
	}
	return null;
}
	public int getAccountSectionCount() {
		return elementUtil.getElements(accountSectionHeaders).size();
		
	}
	
	public List<String> getAccountSectionHeadingList() {
		List<String> sectionTextList=new ArrayList<String>();
		List<WebElement> accountList=elementUtil.getElements(accountSectionHeaders);
		for(WebElement e:accountList) {
			String sectionText=e.getText();
			sectionTextList.add(sectionText);
		}
		return sectionTextList;
	}
	
	public boolean DoSearchAnItem(String productName) {
		elementUtil.doSendKeys(searchText, productName);
		elementUtil.doClick(searchButton);
		if(elementUtil.getElements(searchItemResult).size()>0) {
			return true;
		}
		return false;
	}
	
}
