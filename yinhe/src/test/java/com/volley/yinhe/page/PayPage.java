package com.volley.yinhe.page;

import org.openqa.selenium.WebElement;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.util.GetByLocator;

public class PayPage extends BasePage {
	public PayPage(DriverBase driver){
		super(driver);
	}
	/**
	 * 获取支付页课程信息
	 * */
	public WebElement getCourseNameAfter() {
		return element(GetByLocator.getLocator("courseNameAfter"));
	}
	/**
	 * 获取订单
	 * */
	public WebElement getOrderText() {
		return element(GetByLocator.getLocator("orderText"));
	}
	/**
	 * 获取支付宝付款方式
	 * */
	public WebElement getAliPay() {
		return element(GetByLocator.getLocator("aliPay"));
	}
	/**
	 * 获取支付按钮
	 * */
	public WebElement payButton() {
		return element(GetByLocator.getLocator("payButton"));
	}
}
