package com.sktelecom.jse.domain;

import java.util.Random;

public class PhoneBean {
	protected String name;
	private String number;
	private String customNum;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	public void setCustomNum(String customnum) {
		this.customNum = customnum;
	}
	public String getCustomNum() {
		return customNum;
	}
}
