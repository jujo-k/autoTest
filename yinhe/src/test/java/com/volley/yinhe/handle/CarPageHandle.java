package com.volley.yinhe.handle;

import java.util.List;
import java.util.Set;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.page.CarPage;
import com.volley.yinhe.page.OrderPage;

public class CarPageHandle {
	public DriverBase driver;
	public CarPage cp;
	public CarPageHandle(DriverBase driver) {
		this.driver = driver;
		cp = new CarPage(driver);
	}
	 /**
     * 切换至当前窗口
     * */
    public void switchToWindow_Now() {
    	cp.switchToWindow_Title(cp.getTitle());
    }
	
	/**
	 * 点击确认订单按钮
	 * */
	public void clickCheckButton() {
		cp.GoToCheckButton().click();
	}
	
}
