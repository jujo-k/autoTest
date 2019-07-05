package com.volley.yinhe.handle;

import org.openqa.selenium.WebElement;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.page.PayPage;
import com.volley.yinhe.util.GetByLocator;

public class PayPageHandle {
	public DriverBase driver;
	public PayPage pp;
	public PayPageHandle(DriverBase driver) {
		this.driver = driver;
		pp = new PayPage(driver);
	}
	
	/**
	 * 获取支付页课程信息
	 * */
	public String getCourseNameAfter() {
		return pp.getCourseNameAfter().getText();
	}
	/**
	 * 获取订单
	 * */
	public String getOrderText() {
		return pp.getOrderText().getText();
	}
	/**
	 * 获取支付宝付款方式
	 * */
	public void clickAliPay() {
		pp.getAliPay().click();
	}
	/**
	 * 点击支付按钮
	 * */
	public void clickPayButton() {
		pp.payButton().click();
	}

}
