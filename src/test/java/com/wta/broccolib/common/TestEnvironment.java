package com.wta.broccolib.common;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.broccolib.core.ActionElementManager;
import com.broccolib.core.CheckElementManager;
import com.broccolib.core.ImageComparisonManager;
import com.broccolib.core.WaitElementManager;
import com.broccolib.core.WebElementManager;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

public class TestEnvironment {
	public enum Browsers {
		Firefox, Chrome
	};

	public enum Locators {
		xpath, id, name, classname, paritallinktext, linktext, tagname
	};

	private WebDriver m_aDriver = null;
	private ImageComparisonManager m_aImageComparisonManager = null;
	private WaitElementManager m_aWaitElementManager = null;
	private WebElementManager m_aWebElementManager = null;
	private CheckElementManager m_aCheckElementManager = null;
	private ActionElementManager m_aActionElementManager = null;

	public TestEnvironment() throws Exception {
		this.m_aDriver = new FirefoxDriver();
		this.m_aWaitElementManager = new WaitElementManager(this.m_aDriver);
		this.m_aWebElementManager = new WebElementManager(this.m_aDriver);
		this.m_aCheckElementManager = new CheckElementManager(this.m_aDriver);
		this.m_aActionElementManager = new ActionElementManager(this.m_aDriver);
		this.m_aImageComparisonManager = new ImageComparisonManager();
	}

	public WebDriver getDriver ()
	{
		return this.m_aDriver;
	}
	
	public void maximize() {
		this.m_aDriver.manage().window().maximize();
	}

	public void loadURL(final String sURL) {
		this.m_aDriver.get(sURL);
	}

	public void tearDown() {
		this.m_aDriver.quit();
	}

	public WaitElementManager getWaitElementManager() {
		return this.m_aWaitElementManager;
	}

	public WebElementManager getWebElementManager() {
		return this.m_aWebElementManager;
	}

	public CheckElementManager getCheckElementManager() {
		return this.m_aCheckElementManager;
	}

	public ActionElementManager getActionElementManager() {
		return this.m_aActionElementManager;
	}

	public ImageComparisonManager getImageComparisonManager() {
		return this.m_aImageComparisonManager;
	}

	public void captureScreenshot(final String sScreenshotName) {
		try {
			File aSourcePath = ((TakesScreenshot) this.m_aDriver).getScreenshotAs(OutputType.FILE);
			File aDestinationPath = new File(
					System.getProperty("user.dir") + "/target/screenshots/" + sScreenshotName + ".png");
			Files.copy(aSourcePath, aDestinationPath);
			Reporter.addScreenCaptureFromPath(aDestinationPath.toString());
		} catch (IOException e) {
			// TODO NMO log error
		}
	}
}
