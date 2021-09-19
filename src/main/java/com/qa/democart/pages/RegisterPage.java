package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.democart.utils.Constant;
import com.qa.democart.utils.ElementUtil;

public class RegisterPage {
	//This registration link is available in the Login page class, so we need to maintain one private By locator for our registration 
	//page, and write one navigate method in the LoginPage class
	
   ElementUtil elementUtil;
   
  private WebDriver driver;
  private By registerLinks=By.linkText("Register");
  private By registerAccountText=By.xpath("//*[@id=\"content\"]/h1[contains(text(),'Register Account')]");
  private By firstName=By.id("input-firstname");
  private By lasttName=By.id("input-lastname");
  private By emailBy=By.id("input-email");
  private By telephoneBy=By.id("input-telephone");
  private By yourPasswordText=By.xpath("/*[@id=\"content\"]/form/fieldset[2]/legend[contains(text(),'Your Password')]");
  private By passwordBy=By.id("input-password");
  private By confirmPasswordBy=By.id("input-confirm");
  //private By SubscribeNo=By.xpath("//*[@id=\"content\"]//div/label[2]/input[@name='newsletter']");
  private By subscribeYes=By.xpath("//label[@class='radio-inline'][position()=1]/input");
  private By subscribeNo =By.xpath("//label[@class='radio-inline'][position()=2]/input");
  
  private By privacyPolicyBy=By.name("agree");
  private By continueButton=By.xpath("//input[@type='submit'and @value='Continue']");
  private By accountCreationContinue=By.linkText("Continue");
  private By accountSuccessMess=By.cssSelector("#content h1");
  private By logoutLink=By.linkText("Logout");
  private By registerLink=By.linkText("Register");
  
 public RegisterPage(WebDriver driver) {
 this.driver=driver;
 elementUtil=new ElementUtil(driver);
 }

  
  public boolean registerAccountForm(String firstname,String lastName, String email, String telephoneNumber, String password, String subscribe) {
	  elementUtil.doSendKeys(firstName, firstname);
	  elementUtil.doSendKeys(lasttName, lastName);
	  elementUtil.doSendKeys(emailBy, email);
	  elementUtil.doSendKeys(telephoneBy, telephoneNumber);
	 //elementUtil.doSendKeys(yourPasswordText, FirstName);
	  //elementUtil.doIsDisplayed(yourPasswordText);
	  elementUtil.doSendKeys(passwordBy, password);
	  elementUtil.doSendKeys(confirmPasswordBy, password);
	  
	  if(subscribe.equals("yes")) {
		  elementUtil.doClick(subscribeYes);
	  }
	  else {
		  elementUtil.doClick(subscribeNo);
	  }
	  
	  elementUtil.doClick(privacyPolicyBy);
	  elementUtil.doClick(continueButton);
	  String text=elementUtil.doGetText(accountSuccessMess);
	  if(text.equals(Constant.ACCOUNTS_CREATION_SUCESS_MSG)) {
		  elementUtil.doClick(logoutLink);
		  elementUtil.doClick(registerLink);
		  return true;
	  }
	 return false;
  }
   
}
