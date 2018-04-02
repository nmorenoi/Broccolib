package com.broccolib.core;

import java.io.IOException;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.cucumber.listener.Reporter;

public class ImageComparisonManager {

	private static final String IMG_PATH = "/resources/img/";
	private Screen m_aScreen = null;

	public ImageComparisonManager() {
		this.m_aScreen = new Screen();
	}

	public void validateUIState(final String sAssertImageName, final float nSimilarity, final int nTimeout,
			final boolean bMatch) throws ImageComparisonException, IOException {
		final String sPattern = IMG_PATH + sAssertImageName;
		final boolean bFound = this.m_aScreen.exists(new Pattern(sPattern).similar(nSimilarity), nTimeout) != null;
		final String sPath = System.getProperty("user.dir") + "//" + sPattern;
		if (bMatch == !bFound) {
			String sErrorMsg = "The image  was not found: " + sPattern;
			Reporter.addScreenCaptureFromPath(sPath, sErrorMsg);
			throw new ImageComparisonException(sPath, sErrorMsg);
		}
		if (!bMatch == bFound) {
			String sErrorMsg = "The image has been found: " + sPattern;
			Reporter.addScreenCaptureFromPath(sPath, sErrorMsg);
			throw new ImageComparisonException(sPath, sErrorMsg);
		}
	}

	public void validateUI(final String sImg) throws ImageComparisonException, IOException {
		if (sImg == null || sImg.isEmpty()) {
			throw new NullPointerException();
		}
		this.validateUIState(sImg, 0.95f, 10, true);
	}
}
