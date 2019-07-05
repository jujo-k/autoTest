package com.volley.yinhe.handle;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.page.HomePage;

public class HomePageHandle {
	public DriverBase driver;
	public HomePage hp;
	public HomePageHandle(DriverBase driver) {
		this.driver = driver;
		hp = new HomePage(driver);
	}
	
	/**
	 * 点击登陆按钮
	 * */
	public void clickLoginButtonHome() {
		hp.loginButton().click();
	}
	
	/**
	 * 获取姓名
	 * */
	public String getNameInfo() {
		return hp.UserNameElement().getText();
	}
}
