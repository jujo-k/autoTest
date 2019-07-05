package com.volley.yinhe.bussiness;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.handle.OrderPageHandle;

public class OrderPagePro {
	public OrderPageHandle oph;
	public DriverBase driver;
	
	public OrderPagePro(DriverBase driver) {
		this.driver = driver;
		oph = new OrderPageHandle(driver);
	}
	
	/**
	 * 点击确认订单按钮
	 * */
	public void clickOrderButton() {
		oph.clickOrderButton();
	}

}
