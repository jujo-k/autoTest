package com.volley.yinhe.bussiness;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.handle.HomePageHandle;

public class HomePagePro {
	public HomePageHandle hph;
	public DriverBase driver;
	public HomePagePro(DriverBase driver) {
		this.driver = driver;
		hph = new HomePageHandle(driver);
	}
	
	/**
	 * 打开网页，放大，点击登陆
	 * */
	public void clickLoginButtonHome() {
		hph.clickLoginButtonHome();
	}
	
	/**
	 * 判断是否相等
	 * */
	public boolean AssertLogin(String pro) {
		return hph.getNameInfo().equals(pro);
	}
}
