package com.broccolib.core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wta.broccolib.common.TestEnvironment.Locators;

public class WaitElementManager {

	private WebDriver m_aWebDriver = null;
	private WebElementManager m_aWebDOMElement = null;

	public WaitElementManager(WebDriver aWebDriver) {
		this.m_aWebDriver = aWebDriver;
		this.m_aWebDOMElement = new WebElementManager(aWebDriver);
	}

	public static void wait(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}

	public static void wait(double seconds) throws InterruptedException {
		Thread.sleep(Double.doubleToLongBits(seconds * 1000));
	}

	public void waitForElementDisplayed(Locators aLocator, String aElement) throws Exception {
		waitForElementDisplayed(this.m_aWebDOMElement.getWebElement(aLocator, aElement), 5);
	}

	public void waitForElementDisplayed(Locators aLocator, String aElement, int nSeconds) throws Exception {
		waitForElementDisplayed(this.m_aWebDOMElement.getWebElement(aLocator, aElement), nSeconds);
	}

	public static void waitForElementDisplayed(WebElement aElement) throws Exception {
		waitForElementDisplayed(aElement, 5);
	}

	public void waitForElementClickable(final String sClassName, final String sText, int nAttempts)
			throws InterruptedException {
		if (sClassName == null || sClassName.isEmpty()) {
			throw new NullPointerException();
		}
		if (sText == null || sText.isEmpty()) {
			throw new NullPointerException();
		}
		boolean bFound = false;
		for (int i = 0; i < nAttempts; i++) {
			WebElement aLoginElement = (new WebDriverWait(this.m_aWebDriver, 10))
					.until(ExpectedConditions.elementToBeClickable(By.className(sClassName)));
			if (aLoginElement.getText().equals(sText)) {
				bFound = true;
				break;
			}
			WaitElementManager.wait(3000);
		}
		Assert.assertTrue("The text " + sText + " could not be found", bFound);
	}

	public static void waitForElementDisplayed(WebElement aElement, int aSeconds) throws Exception {
		long nEnd = System.currentTimeMillis() + (aSeconds * 1000);
		while (System.currentTimeMillis() < nEnd) {
			if (aElement.isDisplayed()) {
				break;
			}
		}
	}
}
