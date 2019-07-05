package com.volley.yinhe.page;

import org.openqa.selenium.WebElement;
import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.util.GetByLocator;

public class OrderPage extends BasePage {
	public OrderPage(DriverBase driver){
		super(driver);
	}
	
	
	/**
	 * 获取确认订单按钮
	 * */
	public WebElement orderButton() {
		return element(GetByLocator.getLocator("orderButton"));
	}
	
	
	

}
