package com.volley.yinhe.testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.bussiness.BuyPagePro;
import com.volley.yinhe.bussiness.CarPagePro;
import com.volley.yinhe.bussiness.LoginPro;
import com.volley.yinhe.bussiness.OrderPagePro;
import com.volley.yinhe.bussiness.PayPagePro;
import com.volley.yinhe.util.TestNGListenerScreen;


@Listeners({TestNGListenerScreen.class})
public class CheckBuyCourse extends CaseBase {
	public DriverBase driver;
	public LoginPro loginPro;
	public BuyPagePro buyPagePro;
	public OrderPagePro orderPagePro;
	public PayPagePro payPagePro;
	public CarPagePro carPagePro;
	static Logger logger = Logger.getLogger(Login.class);
	
	@BeforeClass
	public void CheckBuyCourseTest() {
		this.driver = InitDriver("fireFox");
		driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPro = new LoginPro(driver);
		buyPagePro = new BuyPagePro(driver);
		orderPagePro = new OrderPagePro(driver);
		payPagePro = new PayPagePro(driver);
		carPagePro = new CarPagePro(driver);
		
	}
	/**
	 * 到网站里
	 * */
	@Test
	public void getLoginHome() {
		driver.get("https://www.imooc.com");
		driver.maximize();
		driver.findElement(By.id("js-signin-btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 登陆账号
	 * */
	@Test(dependsOnMethods={"getLoginHome"})
	@Parameters({"usrname","psw"})
	public void testLogin(String usrname,String psw) {
		logger.debug("第一次使用哈哈哈");
		loginPro.login(usrname,psw);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*
	@Test(dependsOnMethods={"testLogin"})
	public void buyCourse() throws InterruptedException {
		//321 320 207 322 302 324 197 136 316
		driver.get("https://coding.imooc.com/class/302.html");
		String nameBefore = buyPagePro.getCourseNameBefore();
		buyPagePro.clickBuyButton();
		orderPagePro.clickOrderButton();
		Thread.sleep(2000);
		String nameAfter = payPagePro.getCourseNameAfter();
		Assert.assertEquals(nameAfter, nameBefore,"不是同一门课程");
	}*/
	
	
	/**
	 * 选择一个课程，添加购物车
	 * 跳转到购物车页面
	 * */
	@Test(dependsOnMethods={"testLogin"})
	public void addCart() {
		driver.get("https://coding.imooc.com/class/320.html");
		
		buyPagePro.addCart();
	}
	
	/**
	 * 购物车确认订单
	 * 跳转到确认订单页面
	 * */
	@Test(dependsOnMethods={"addCart"})
	public void goToCheck() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		carPagePro.switchToWindow_Now();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		carPagePro.clickGoToCheck();
		System.out.println("点击去结算");
	}
	
	/**
	 * 订单确认
	 * 跳转到支付页面
	 * */
	@Test(dependsOnMethods={"goToCheck"})
	public void submitOrder() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		orderPagePro.clickOrderButton();
	}
	
	/**
	 * 支付页面要校对信息，在进行支付
	 * 校对成功，点击支付后，跳到支付宝页面
	 * */
	@Test(dependsOnMethods={"submitOrder"})
	public void payOrder() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		payPagePro.clickPayButton();
	}
	
	@AfterClass
	public void close(){
		driver.back();
	}
	
}
