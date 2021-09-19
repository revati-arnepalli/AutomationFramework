package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.ElementUtil;

public class ForgotPasswordPage {
      ElementUtil elementUtil;
	  private By forgotpasswords= By.linkText("Forgotten Password");
	  private By forgotEmail=By.id("input-email");
	  private By Continue=By.xpath("//input[@class='btn btn-primary']");
	  
	  public  ForgotPasswordPage(WebDriver driver) {
		  elementUtil=new ElementUtil(driver);
	  }
	  
	  public void forgotPasswordEmail(String value) {
		   elementUtil.doSendKeys(forgotEmail, value);
	   }
	  
	  public void isForgotPasswordLinks() {
		   
			 elementUtil.clickElement(forgotpasswords, "Forgotten Password");
			 elementUtil.doClick(Continue);
			 		   
			   
	   }
	  
}
