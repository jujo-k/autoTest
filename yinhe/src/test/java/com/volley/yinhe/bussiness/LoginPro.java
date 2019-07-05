package com.volley.yinhe.bussiness;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.handle.LoginPageHandle;

public class LoginPro {
	public LoginPageHandle lph;
	public DriverBase driver;
	
	public LoginPro(DriverBase driver) {
		this.driver = driver;
		lph = new LoginPageHandle(driver);
	}
	public void login(String userName,String password){
		if(lph.assertLoginPage()){
			lph.sendKeysUser(userName);
			lph.sendKeysPassword(password);
			lph.clickAutoSignin();
			lph.clickLoginButton();
		}else{
			System.out.println("页面不存在或者状态不正确。");
		}
	}
}
