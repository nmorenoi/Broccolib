package com.broccolib.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wta.broccolib.common.TestEnvironment.Locators;

public class WebElementManager {

	private WebDriver m_aWebDriver = null;

	public WebElementManager(WebDriver aWebDriver) {
		this.m_aWebDriver = aWebDriver;
	}

	public WebElement getWebElement(Locators aLocator, String sElement) throws Exception {
		By aByElement = null;
		switch (aLocator) {
		case xpath: {
			aByElement = By.xpath(sElement);
			break;
		}
		case id: {
			aByElement = By.id(sElement);
			break;
		}
		case name: {
			aByElement = By.name(sElement);
			break;
		}
		case classname: {
			aByElement = By.className(sElement);
			break;
		}
		case linktext: {
			aByElement = By.linkText(sElement);
			break;
		}
		case paritallinktext: {
			aByElement = By.partialLinkText(sElement);
			break;
		}
		case tagname: {
			aByElement = By.tagName(sElement);
			break;
		}
		default: {
			throw new Exception();
		}
		}
		return this.m_aWebDriver.findElement(aByElement);
	}
}
