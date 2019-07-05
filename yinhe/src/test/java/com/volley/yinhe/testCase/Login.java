package com.volley.yinhe.testCase;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.log4testng.Logger;
import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.bussiness.LoginPro;

public class Login extends CaseBase{
	public DriverBase driver;
	public LoginPro loginPro;
	static Logger logger = Logger.getLogger(Login.class);
	
	public Login() {
		this.driver = InitDriver("fireFox");
		loginPro = new LoginPro(driver);
	}
	
	@Test
	public void getLoginHome() {
		driver.get("https://www.imooc.com");
		driver.findElement(By.id("js-signin-btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods={"getLoginHome"})
	public void testLogin() {
		logger.debug("第一次使用哈哈哈");
		System.out.println("第一次使用哈");
		loginPro.login("15757390200", "jes199619.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 下单流程
	
	@Test(dependsOnMethods={"testLogin"})
	public void buyCourse() {
		//321 320 207 322 302 324 197 136 316
		driver.get("https://coding.imooc.com/class/197.html");
		String before = driver.findElement(By.xpath("//div[@class='path']/span")).getText();
		
		driver.findElement(By.id("buy-trigger")).click();
		
		driver.findElement(By.linkText("提交订单")).click();
	
		
		String order = driver.findElement(By.className("order")).getText();
		
		if(order!=null) {
			String after = driver.findElement(By.xpath("//li//dt")).getText();
			Assert.assertEquals(before, after,"不是同一个订单");
		}
		
	} 
	 * @throws InterruptedException */

	
	@Test(dependsOnMethods={"testLogin"})
	public void AddCar() throws InterruptedException {
		int numBefore ;
		int numAfter;
		driver.get("https://coding.imooc.com/class/320.html");
		driver.getDriver().navigate().refresh();
		Thread.sleep(5000);
//		//悬浮
		WebElement carHang = driver.findElement(By.id("shop-cart"));
		Actions a1 = new Actions(driver.getDriver());
		a1.moveToElement(carHang).perform();
		Thread.sleep(2000);
		//获取课程数量
		String s1 = driver.findElement(By.className("js-incart-num")).getText();
		
		try {
			numBefore = Integer.valueOf(s1);
		} catch (Exception e) {
			numBefore=0;
		}
		
		System.out.println("numBefore:"+numBefore);
		
		driver.getDriver().navigate().refresh();
		
		//点击加入购物车
		driver.findElement(By.linkText("加购物车")).click();
		
		//如果已经加入购物车就直接去购买
		try {
			driver.switchToMode();
			driver.findElement(By.className("moco-btn")).click();
		} catch (Exception e) {
			
		}
		
		driver.getDriver().navigate().refresh();
		
		//悬浮
		WebElement carHang1 = driver.findElement(By.id("shop-cart"));
		Actions a2 = new Actions(driver.getDriver());
		a2.moveToElement(carHang1).perform();
	
		Thread.sleep(2000);
//		//获取课程数量
		String s2 = driver.findElement(By.className("js-incart-num")).getText();
		try {
			numAfter = Integer.valueOf(s2);
		} catch (Exception e) {
			numAfter = numBefore;
		}
		System.out.println("numAfter:"+numAfter);
		
		//添加成功去购物车
		//添加失败去
		if(numBefore+1 == numAfter) {
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
		
		
		
	}
	

	
}

