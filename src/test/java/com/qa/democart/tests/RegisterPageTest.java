package com.qa.democart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.base.BaseTest;
//import com.qa.democart.pages.LoginPage;
import com.qa.democart.utils.Constant;
import com.qa.democart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	
	@BeforeClass
	public void regPageSetUp() {
		registerPage=loginPage.navigateToRegisterPage();
	}
	
//	@Test(priority=1)
//	public void verifyLoginPageTitleTest() {
//		String title=loginPage.getPageTitle();
//		Assert.assertEquals(title, Constant.Login_Page_Title);
//		System.out.println(title);
//	}
//	@Test (priority=2)
//	public void verifyRegisterLinksTest() {
//		registerPage.registrationLinks();
//	}
	
	@DataProvider
	public Object[][] geRegisterData() {
		Object data[][]= ExcelUtil.getTestData(Constant.REGISTER_SHEET_NAME);
		return data;
	} 
	
	@Test(dataProvider="geRegisterData")
	public void VerifyUserIsAbleToRegisterForm(String firstname,String lastName, String email, String telephoneNumber, String password, String subscribe) {
		//registerPage.registerAccountForm("aaa", "zzz", "uuuuu4@gmail.com", "9999", "password", "yes");
		registerPage.registerAccountForm(firstname, lastName, email, telephoneNumber, password, subscribe);
	}
	
	
}
