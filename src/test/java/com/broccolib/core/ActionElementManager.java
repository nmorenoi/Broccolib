package com.broccolib.core;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.wta.broccolib.common.TestEnvironment.Locators;

public class ActionElementManager {

	private WebDriver m_aWebDriver = null;
	private WebElementManager m_aWebDOMElement = null;

	public ActionElementManager(WebDriver aWebDriver) {
		this.m_aWebDriver = aWebDriver;
		this.m_aWebDOMElement = new WebElementManager(aWebDriver);
	}

	public void click(Locators aLocator, String sElement) throws Exception {
		this.click(this.m_aWebDOMElement.getWebElement(aLocator, sElement));
	}

	public void click(WebElement aElement) {
		Actions aSelAction = new Actions(this.m_aWebDriver);
		aSelAction.click(aElement).perform();
	}

	public void hover(Locators aLocator, String aElement) throws Exception {
		hover(this.m_aWebDOMElement.getWebElement(aLocator, aElement));
	}

	public void hover(WebElement aElement) throws Exception {
		Actions aSelAction = new Actions(this.m_aWebDriver);
		aSelAction.moveToElement(aElement).perform();
	}

	public void type(Locators aLocator, String sElement, String sText) throws Exception {
		type(this.m_aWebDOMElement.getWebElement(aLocator, sElement), sText);
	}

	public void type(WebElement aElement, String sText) {
		Actions selAction = new Actions(this.m_aWebDriver);
		selAction.sendKeys(aElement, sText).perform();
	}

	public void scrollTo(final WebElement aElement) {
		if (aElement == null) {
			throw new NullPointerException();
		}
		((JavascriptExecutor) this.m_aWebDriver).executeScript(EScriptTest.SCROLL_TO.getID(), aElement);
		Assert.assertTrue("The element: " + aElement.getText() + " is not displayed!", aElement.isDisplayed());
	}
}
