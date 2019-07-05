package com.volley.yinhe.page;

import org.openqa.selenium.WebElement;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.util.GetByLocator;

public class HomePage extends BasePage{
	public DriverBase driver;

	public HomePage(DriverBase driver) {
		super(driver);
	}
	
	/**
	 * 点击登陆
	 * **/
	public WebElement loginButton() {
		return element(GetByLocator.getLocator("click"));	
	}
	
	/**
	 * 获取用户名信息
	 * **/
	public WebElement UserNameElement() {
		driver.actionMoveToElement(element(GetByLocator.getLocator("header")));
		return element(GetByLocator.getLocator("nameInfo"));	
	}
}
