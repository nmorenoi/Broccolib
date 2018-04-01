package com.broccolib.core;

public class ImageComparisonException extends Exception {
	private static final long serialVersionUID = -4395987641142777754L;

	private String m_sComparedImg = null;
	private String m_sDetails = null;

	public ImageComparisonException(final String sComparedImg, final String sDetails) {
		this.m_sComparedImg = sComparedImg;
		this.m_sDetails = sDetails;
	}

	public String getComparedImage() {
		return this.m_sComparedImg;
	}

	public String getDetails() {
		return this.m_sDetails;
	}
}
