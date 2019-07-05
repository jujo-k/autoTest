package com.volley.yinhe.bussiness;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.handle.CarPageHandle;
import com.volley.yinhe.handle.PayPageHandle;

public class CarPagePro {
	public CarPageHandle cph;
	public DriverBase driver;
	
	public CarPagePro(DriverBase driver) {
		this.driver = driver;
		cph = new CarPageHandle(driver);
	}
	 /**
     * 切换至当前窗口
     * */
    public void switchToWindow_Now() {
    	cph.switchToWindow_Now();
    }
	
	/**
	 * 点击去结算
	 * */
	public void clickGoToCheck(){
		cph.clickCheckButton();
	}

	
}
