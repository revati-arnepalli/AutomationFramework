package com.qa.democart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.base.BaseTest;
import com.qa.democart.utils.Constant;
import com.qa.democart.utils.ExcelUtil;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void verifyUserIsAbleToLogin() {
		accountPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("Password"));
	}
  
	@Test(priority=1)
	public void verifyAccountPageTitle() {
		String title=accountPage.getAccountPageTitle();
		Assert.assertEquals(title, Constant.ACCOUNTS_PAGE_TITLE);
		System.out.println(title);
	}
	
	@Test(priority=2)
	public void verifyAcoountsHeaderTitle() {
		String title=accountPage.getHeaderValue();
		System.out.println("Header title is"+title);
		Assert.assertEquals(title, Constant.ACCOUNTS_PAGE_HEADER__TITLE);
	}
	
	@Test(priority=3)
	public void verifyAcoountsSectionTitleCount() {
		accountPage.getAccountSectionCount();
	}
	
	@Test(priority=4)
	public void verifyAcoountsSectionTitleList() {
		List<String> accountSectionList=accountPage.getAccountSectionHeadingList();
		Assert.assertEquals(accountSectionList, Constant.getExpectedAccountSectionsList());
	}
	
	// the below dataprovider is not (global) common for all the classes. only applicable for particular test
	// and should be maintain in the same test class(not in the baseTest/ page class)
	
	
//	@DataProvider
//	public Object[][] productSearchData() {
//		return new Object[][] {
//			{"imac"},
//			{"macbook"},
//			{"iphone"}
//		};
//		
//	}
	
	@DataProvider
	public Object[][] getProductSearchData() {
		Object data[][]=ExcelUtil.getTestData(Constant.SEARCH_SHEET_NAME);
		return data;
	}
	
	@Test(priority=5, dataProvider="getProductSearchData")
	public void verifyUserIsAbleToDoSearch(String productName) {
		Assert.assertTrue(accountPage.DoSearchAnItem(productName));
	}
	
	
}
