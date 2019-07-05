package com.volley.yinhe.bussiness;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.handle.BuyPageHandle;

public class BuyPagePro {
	public BuyPageHandle bph;
	public DriverBase driver;
	
	public BuyPagePro(DriverBase driver) {
		this.driver = driver;
		bph = new BuyPageHandle(driver);
	}
	/**
	 * 添加购物车
	 * 页面刷新之后要重新获取元素
	 * */
	public void addCart() {
		int beforeNum;
		int afterNum;
		bph.freshPage();
		bph.moveToCarElement();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String courseNum = bph.getCourseNumber();
		try {
			beforeNum = Integer.valueOf(courseNum);
		} catch (Exception e) {
			beforeNum = 0;
		}
		System.out.println("beforeNum:"+beforeNum);
		
		bph.freshPage();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		bph.cilckAddToCarButton();
		
		//如果已经加入购物车就直接去购买
		try {
			bph.switchToMode();
			bph.alertConfirm();
		} catch (Exception e) {
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		bph.GoToCar();
		
		
//		bph.freshPage();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		WebElement carHang2 = driver.findElement(By.id("shop-cart"));
//		Actions a2 = new Actions(driver.getDriver());
//		a2.moveToElement(carHang2).perform();
//		
//		System.out.println("afer hang success");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		courseNum = bph.getCourseNumber();
//		try {
//			afterNum = Integer.valueOf(courseNum);
//			System.out.println("afterNum:"+afterNum);
//		} catch (Exception e) {
//			afterNum = beforeNum;
//		}
//		
//		if(afterNum == beforeNum+1) {
//			System.out.println("添加购物车成功");
//			bph.GoToCarButton();
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//		}else if(afterNum>0) {
//			System.out.println("添加失败，课程已经存在");
//			bph.GoToCarButton();
//		}
	}
	/**
	 * 点击购买按钮
	 * */
	public void clickBuyButton() {
		bph.clickBuyButton();
	}
	
	
	
	
	
	

}
