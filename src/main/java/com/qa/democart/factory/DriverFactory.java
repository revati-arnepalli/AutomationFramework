package com.qa.democart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Revati
 *
 */
public class DriverFactory {
  //initialize driver, initialize property method, get screenshot method
	public WebDriver driver;
	public WebDriver init_driver(Properties prop) {
		//initialize the driver on the bases of browser name, you give me the browser name and I will be launch
		
		/**
		 * @param browser name
		 * @return this returns webdriver reference on the basis of given browser
		 */
		
		String browserName=prop.getProperty("browser");
		System.out.println("Browser name is:" +browserName);
		
		// trim() method can eliminate any unwanted spaces are given at the config property values
		switch(browserName.trim()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
			
		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
			case "Safari":
				driver= new SafariDriver();	
			break;	
				default:
					System.out.println("Please pass the correct browser name: "+browserName);
					break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
		
	}
	
	/**
	 * this methods will initialize the properties from config.properties file
	 */
	
	public Properties init_prop() {
		// file call is actually responsible to interactive with the file(config.properties), and create object of the properties class
		Properties prop=null;
			
			try {
				FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			
			 prop=new Properties(); //all the key and values will be stored in the prop object
					prop.load(ip);
			}
				 
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
	
			
		return prop;
	}
}
