package com.volley.yinhe.page;

import org.openqa.selenium.WebElement;
import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.util.GetByLocator;

public class BuyPage extends BasePage {
	public BuyPage(DriverBase driver){
		super(driver);
	} 
	/**
	 * 获取购买页课程信息
	 * */
	public WebElement getCourseNameBefore(){
		return element(GetByLocator.getLocator("courseNameBefore"));
	}
	
	/**
	 * 获取购买按钮
	 * */
	public WebElement BuyButton() {
		return element(GetByLocator.getLocator("buyButton"));
	}
	/**
	 * 获取加入购物车按钮
	 * */
	public WebElement AddToCarButton() {
		return element(GetByLocator.getLocator("addCarButton"));
	}
	/**
	 * 获取购买页购物车中课程数量
	 * */
	public WebElement getCourseNumber(){
		return element(GetByLocator.getLocator("courseNum"));
	}
	/**
	 * 去购物车按钮
	 * */
	public WebElement GoToCarButton() {
		return element(GetByLocator.getLocator("goToCar"));
	}
	/**
	 * 购物车悬停按钮
	 * */
	public WebElement CarHang() {
		return element(GetByLocator.getLocator("carHang"));
	}
	
	/**
	 * 获得模态框确认按钮
	 * */
	public WebElement alertConfirm() {
		return element(GetByLocator.getLocator("alertConfirm"));
	}

}
