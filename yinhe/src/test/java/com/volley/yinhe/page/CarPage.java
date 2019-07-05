package com.volley.yinhe.page;

import org.openqa.selenium.WebElement;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.util.GetByLocator;

public class CarPage extends BasePage{
	public CarPage(DriverBase driver){
		super(driver);
	}
	
	/**
	 * 获取去结算按钮
	 * */
	public WebElement GoToCheckButton() {
		return element(GetByLocator.getLocator("goToCheckButton"));
	}
	
	
	
}
