package com.broccolib.core;

public enum EScriptTest {
	SCROLL_TO("arguments[0].scrollIntoView(true);");

	private String m_sScript;

	EScriptTest(final String sScript) {
		this.m_sScript = sScript;
	}

	public String getID() {
		return this.m_sScript;
	}
}
