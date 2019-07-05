package com.volley.yinhe.handle;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.page.OrderPage;


public class OrderPageHandle {
	public DriverBase driver;
	public OrderPage op;
	public OrderPageHandle(DriverBase driver) {
		this.driver = driver;
		op = new OrderPage(driver);
	}
	
	
	/**
	 * 点击确认订单按钮
	 * */
	public void clickOrderButton() {
		op.orderButton().click();
	}
	


}
