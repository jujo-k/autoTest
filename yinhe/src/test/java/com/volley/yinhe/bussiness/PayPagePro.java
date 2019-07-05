package com.volley.yinhe.bussiness;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.handle.PayPageHandle;

public class PayPagePro {
	public PayPageHandle pph;
	public DriverBase driver;
	
	public PayPagePro(DriverBase driver) {
		this.driver = driver;
		pph = new PayPageHandle(driver);
	}
	
	/**
	 * 获取购买页课程信息
	 * */
	public String getCourseNameAfter(){
		return pph.getCourseNameAfter();
	}
	/**
	 * 点击支付按钮
	 * */
	public void clickPayButton() {
		String orderText = pph.getOrderText();
		String courseName= pph.getCourseNameAfter();
		if(orderText !=null && courseName!=null) {
			pph.clickAliPay();
			pph.clickPayButton();
		}
		
	}

	
	

}
