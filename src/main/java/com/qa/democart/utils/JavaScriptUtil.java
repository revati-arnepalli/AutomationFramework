package com.qa.democart.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	WebDriver driver;

	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void flash(WebElement element) {
		//JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 20; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	private void changeColor(String color, WebElement element) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public void drawBorder(WebElement element) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public void generateAlert(String message) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("alert('" + message + "')");
	}

	public void clickElementByjse(WebElement element) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();", element);

	}

	public void refreshBrowserByjse() {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("history.go(0)");
	}

	public String getTitleByjse() {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String title = jse.executeScript("return document.title;").toString();
		return title;
	}

	public String getPageInnerText() {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String pageText = jse.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	public void scrollPageDown() {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollPageUp() {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getBrowserInfo() {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String uAgent = jse.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}

	public void sendKeysUsingjseWithId(String id, String value) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	public void sendKeysUsingjseWithName(String name, String value) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("document.getElementByName('" + name + "').value='" + value + "'");
	}

	public void checkPageIsReady() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Initially bellow given if condition will check ready state of page.
		if (jse.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}

		// This loop will rotate for 25 times to check If page Is ready after
		// every 1 second.
		// You can replace your value with 25 If you wants to Increase or
		// decrease wait time.
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (jse.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

}