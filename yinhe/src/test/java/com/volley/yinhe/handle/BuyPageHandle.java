package com.volley.yinhe.handle;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.page.BuyPage;

public class BuyPageHandle {
	public DriverBase driver;
	public BuyPage bcp;
	public BuyPageHandle(DriverBase driver) {
		this.driver = driver;
		bcp = new BuyPage(driver);
	}
	
	/**
	 * 获取购买页课程信息
	 * */
	public String getCourseNameBefore(){
		return bcp.getCourseNameBefore().getText();
	}
	
	/**
	 * 点击购买按钮
	 * */
	public void clickBuyButton() {
		bcp.BuyButton().click();
	}
	
	/**
	 * 点击购物车按钮
	 * */
	public void cilckAddToCarButton() {
		bcp.AddToCarButton().click();
	}
	/**
	 * 获取购买页购物车中课程数
	 * */
	public String getCourseNumber(){
		return bcp.getCourseNumber().getText();
	}
	
	/**
	 * 购物车悬停封装
	 * */
	public void moveToCarElement(){
		bcp.moveToElement(bcp.CarHang());
	}

	/**
	 * 去购物车hang
	 * */
	public void GoToCar() {
		bcp.CarHang().click();
	}
	/**
	 * 去购物车按钮
	 * */
	public void GoToCarButton() {
		bcp.GoToCarButton().click();
	}
	/**
	 * 刷新页面
	 * */
	public void freshPage() {
		bcp.freshPage();
	}
	/**
	 * 切换模态框
	 * */
	public void switchToMode() {
		bcp.switchToMode();
	}
	/**
	 * 去模态框确认按钮
	 * */
	public void alertConfirm() {
		bcp.alertConfirm().click();
	}
}
