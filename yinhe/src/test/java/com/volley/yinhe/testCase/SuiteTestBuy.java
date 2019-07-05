package com.volley.yinhe.testCase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.volley.yinhe.base.DriverBase;
import com.volley.yinhe.bussiness.BuyPagePro;
import com.volley.yinhe.util.HandleCookie;


public class SuiteTestBuy extends CaseBase{
	public DriverBase driver;
	public BuyPagePro buyPagePro;
	public HandleCookie handleCookie;
	
  @BeforeClass
  public void beforeClass() {
	    this.driver = InitDriver("fireFox");
	    driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    buyPagePro = new BuyPagePro(driver);
	    handleCookie = new HandleCookie(driver);
	    driver.get("https://coding.imooc.com/class/197.html");
	    handleCookie.setCookie();
	    driver.get("https://coding.imooc.com/class/197.html");
  }
  @Test
  public void SuiteTestBuy() {
	  buyPagePro.clickBuyButton();
  }
  @AfterClass
  public void afterClass() {
	   driver.stop();
  }

}
