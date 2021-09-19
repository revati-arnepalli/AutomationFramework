package com.qa.democart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.base.BaseTest;
import com.qa.democart.utils.Constant;

public class ForgotPasswordTestPage extends BaseTest{
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title=loginPage.getPageTitle();
		Assert.assertEquals(title, Constant.Login_Page_Title);
		System.out.println(title);
	}
	@Test(priority=2)
	public void clickForgotPasswordLinks() {
		forgotPasswordPage.isForgotPasswordLinks();
	}
	@Test(priority=3)
	public void forgotPasswordTest() {
		forgotPasswordPage.forgotPasswordEmail(prop.getProperty("Email"));
	}

}
