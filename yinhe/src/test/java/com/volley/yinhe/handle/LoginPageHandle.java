package com.volley.yinhe.handle;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.page.LoginPage;

/*
 * 对loginPage上的元素进行操作
 * 
 * */
public class LoginPageHandle {
	public DriverBase driver;
	public LoginPage lp;
	public LoginPageHandle(DriverBase driver) {
		this.driver = driver;
		lp = new LoginPage(driver);
	}
	
	/**
	 * 输入用户名
	 * */
	public void sendKeysUser(String userName){
		lp.sendkeys(lp.getUserElement(), userName);
	}
	
	/**
	 * 输入密码
	 * */
	public void sendKeysPassword(String password){
		lp.sendkeys(lp.getPasswordElement(), password);
	}
	/**
	 * 点击登陆
	 * */
	public void clickLoginButton(){
		lp.click(lp.getLoginButtonElement());
	}
	
	/**
	 * 判断是否是登陆页面
	 * */
	public boolean assertLoginPage(){
		return lp.assertElementIs(lp.getUserElement());
	}
	/**
	 * 点击自动登陆
	 * */
	public void clickAutoSignin(){
		lp.click(lp.getAutoSigninElement());
	}
	
}
