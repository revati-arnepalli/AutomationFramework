package com.qa.democart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.democart.factory.DriverFactory;
import com.qa.democart.pages.AccountsPage;
import com.qa.democart.pages.ForgotPasswordPage;
import com.qa.democart.pages.LoginPage;
import com.qa.democart.pages.RegisterPage;

//Behaviour of the BaseTest and behaviour of the driverFactory are totally independent

public class BaseTest {
  WebDriver driver;
  DriverFactory df;
  public Properties prop;
  public LoginPage loginPage;
  public RegisterPage registerPage;
  public ForgotPasswordPage forgotPasswordPage; 
  public AccountsPage accountPage;
  @BeforeTest
  public void setUp() {
	  // this setup method will launch the browser, to launch the browser it needs to get config properties
	  
	  df=new DriverFactory();
	  prop =df.init_prop(); // browser is mentioned at the config.properties file
	  driver=df.init_driver(prop); //initialize the driver
	  
	  driver.get(prop.getProperty("url")); //open the url
	 	  
	  
	  loginPage=new LoginPage(driver);
	  registerPage=new RegisterPage(driver);
	 //launch the driver
	  forgotPasswordPage =new ForgotPasswordPage(driver);
	  //accountPage=new AccountsPage(driver); Page chaining concept: this line of code is mainitained by LoginPage, because immediate after user login to the 
	  //account he is landed on the "Account Page"
  }
  
  @AfterTest
  public void tearDown() {
	 // driver.quit();
  }
}
