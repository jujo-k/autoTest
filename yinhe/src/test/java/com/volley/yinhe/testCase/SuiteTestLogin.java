package com.volley.yinhe.testCase;

import com.volley.yinhe.base.DriverBase;

import com.volley.yinhe.bussiness.HomePagePro;
import com.volley.yinhe.bussiness.LoginPro;
import com.volley.yinhe.util.HandleCookie;
import com.volley.yinhe.util.ProUtil;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;

public class SuiteTestLogin extends CaseBase {
	public DriverBase driver;
	public LoginPro loginPro;
	public HomePagePro homePagePro;
	public ProUtil pro;
	static Logger logger = Logger.getLogger(Login.class);
	public HandleCookie handleCookie;

  
  @BeforeClass
  public void beforeClass() {
	    this.driver = InitDriver("fireFox");
	    driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    pro = new ProUtil("loginTest.properties");
		loginPro = new LoginPro(driver);
		homePagePro = new HomePagePro(driver);
		handleCookie = new HandleCookie(driver);
  }
  @Test
  public void SuiteTestLogin() {
	    driver.get(pro.getPro("url"));
		driver.maximize();
		
		homePagePro.clickLoginButtonHome();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String username = pro.getPro("username");
		String psw = pro.getPro("passwd");
	    loginPro.login(username, psw);
	    
	    
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println(pro.getPro("except"));
	    
//	    Actions action = new Actions((WebDriver) driver);
//		action.moveToElement(driver.findElement(GetByLocator.getLocator("header"))).perform();
//		String name = driver.findElement(GetByLocator.getLocator("nameInfo")).getText();
//		System.out.println(name);
	    
	    
		 if(homePagePro.AssertLogin(pro.getPro("except"))){
				System.out.println("登陆成功"+username);
				handleCookie.setCookie();
			}
  }
  @AfterClass
  public void afterClass() {
//	   driver.stop();
  }

}
