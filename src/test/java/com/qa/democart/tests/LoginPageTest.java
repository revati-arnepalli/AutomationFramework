package com.qa.democart.tests;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.base.BaseTest;
import com.qa.democart.utils.Constant;
import com.qa.democart.utils.ExcelUtil;

public class LoginPageTest extends BaseTest{

	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title=loginPage.getPageTitle();
		Assert.assertEquals(title, Constant.Login_Page_Title);
		System.out.println(title);
	}
	
	@Test(priority=3)
	public void verifyUserIsAbleToLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("Password"));
		
	}
	
	
	
//	@Test(priority=2)
//		public void verifyForgottenPasswordLink() {
//		loginPage.isForgotPasswordLinks();
//	}
	
	@DataProvider
	public Object[][] getInvalidData() {
		Object data[][]= ExcelUtil.getTestData(Constant.INVALID_USERNAME_PASSWORD);
		return data;
	} 
	
	@Test(dataProvider="getInvalidData")
	public void VerifyUserIsAbleToRegisterForm(String username,String password) {
		loginPage.doNotLogin(username,password);
	}
}
