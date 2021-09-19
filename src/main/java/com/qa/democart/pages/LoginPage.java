package com.qa.democart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.democart.utils.Constant;
import com.qa.democart.utils.ElementUtil;

public class LoginPage {
  private WebDriver driver;
   private ElementUtil elementUtil;
   
   // page locators : By locators : OR
   private By emailID= By.id("input-email");
   private By passwordBy = By.id("input-password");
   //private By login= By.xpath("//*[@id=\"content\"]//form/input[@type='submit']");
   private By loginSubmit=By.xpath("//*[@id=\"content\"]//form/input[@type='submit']");
  private By forgotpasswords= By.linkText("Forgotten Password");
  private By forgotEmail=By.id("input-email");
  private By Continue=By.xpath("//input[@class='btn btn-primary']");
  private By registerLink=By.linkText("Register");
   
   //page constructor
   public LoginPage(WebDriver driver) {
	   this.driver=driver;
	   elementUtil=new ElementUtil(driver);
   }
   
  //page actions
   
   public String getPageTitle() {
	  return elementUtil.waitForTitleToBe(Constant.Login_Page_Title, 5);
   }
   
//   public boolean getForgotPasswordLinks() {
//	   if(driver.findElements(forgotpassword).size()==2)
//		   return true;
//	   return false;
//	   
//   }
   
//   public void isForgotPasswordLinks() {
//	   
//		 elementUtil.clickElement(forgotpasswords, "Forgotten Password");
//		 elementUtil.doClick(Continue);
//		 		   
//		   
//   }
//   
//   public void forgotPasswordEmail(String username) {
//	   elementUtil.doSendKeys(forgotEmail, username);
//   }
   public RegisterPage navigateToRegisterPage() {
	   elementUtil.doClick(registerLink); //it returns next landing page object
	   return new RegisterPage(driver);
   }
   
   public AccountsPage doLogin(String username, String password) {
	   System.out.println("login with username:"+username+"and Password"+password);
	   elementUtil.doSendKeys(emailID, username);
	   elementUtil.doSendKeys(passwordBy, password);
	   elementUtil.doClick(loginSubmit);
	   
	   return new AccountsPage(driver);
   }
   
  public AccountsPage doNotLogin(String username, String password) {
	  System.out.println("Invalid login with username:"+username+"or/and Password"+password);
	   elementUtil.doSendKeys(emailID, username);
	   elementUtil.doSendKeys(passwordBy, password);
	   elementUtil.doClick(loginSubmit);
	   
	   return new AccountsPage(driver);
  }
   
}
