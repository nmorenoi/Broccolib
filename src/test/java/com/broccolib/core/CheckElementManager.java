package com.broccolib.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.wta.broccolib.common.TestEnvironment.Locators;

public class CheckElementManager {

	private WebElementManager m_aWebDOMElement = null;

	public CheckElementManager(WebDriver aWebDriver) {
		this.m_aWebDOMElement = new WebElementManager(aWebDriver);
	}

	public void checkElementDisplayed(Locators aLocator, String aElement) throws Exception {
		checkElementDisplayed(this.m_aWebDOMElement.getWebElement(aLocator, aElement));
	}

	public void checkElementDisplayed(WebElement aElement) throws Exception {
		Assert.assertTrue(aElement.isDisplayed());
	}
}
