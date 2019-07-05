package com.volley.yinhe.page;

import org.openqa.selenium.WebElement;
import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.util.GetByLocator;



public class LoginPage extends BasePage{
	public LoginPage(DriverBase driver){
		super(driver);
	}
	
	/**
	 * 获取用户名输入框
	 * */
	public WebElement getUserElement(){
		return element(GetByLocator.getLocator("username"));
	}
	
	/**
	 * 获取密码输入框Element
	 * */
	public WebElement getPasswordElement(){
		return element(GetByLocator.getLocator("psw"));
	}
	/**
	 * 获取自动登陆element
	 * */
	public WebElement getAutoSigninElement(){
		return element(GetByLocator.getLocator("autoSignin"));
	}
	/**
	 * 获取登陆按钮element
	 * */
	public WebElement getLoginButtonElement(){
		return element(GetByLocator.getLocator("loginButton"));
	}
	/**
	 * 获取订单
	 * */
	public WebElement orderTextElement(){
		return element(GetByLocator.getLocator("orderText"));
	}

	
	
}
