package com.volley.yinhe.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * 获取driver
 * **/
public class DriverBase {
	public WebDriver driver;
	
	public DriverBase(String browser) {
		SelectDriver selectDriver = new SelectDriver();
		this.driver = selectDriver.driverName(browser);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public void maximize() {
		driver.manage().window().maximize();
	}
	public void stop() {
		System.out.println("stop webdriver");
		driver.close();
	}
	public void get(String url) {
		 driver.get(url);
	}

    /**
     * 获取title
     * */
    public String getTitle(){
    	return driver.getTitle();
    }
	
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}
	public void back() {
		driver.navigate().back();
	}
	
	/**
     * 获取当前系统窗口list
     * */
    public List<String> getWindowsHandles(){
    	Set<String> winHandels = driver.getWindowHandles();
    	List<String> handles = new ArrayList<String>(winHandels);
    	return handles;
    }
    
    /*
     * 获取当前窗口
     * **/
    public String getWindowHandle(){
    	return driver.getWindowHandle();
    }
	
    
    /**
     * 切换windows窗口
     * */
    public void switchWindows(String name){
    	driver.switchTo().window(name);
    }
    
    /**
     * 切换alert窗口
     * */
    public void switchAlert(){
    	driver.switchTo().alert();
    }
	  /**
     * 模态框切换
     * */
    public void switchToMode(){
    	driver.switchTo().activeElement();
    }
    /**
     * action封装
     * */
    public void actionMoveToElement(WebElement webElement) {
    	Actions action = new Actions(driver);
    	action.moveToElement(webElement).perform();
    }

    /**
	 * 自动截图
	 * */
    public void takeScreenShot() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
        takeScreenShot((TakesScreenshot) this.getDriver(), path);
        //takeScreenShot((TakesScreenshot) driver, path);
    }
    
    /**
     * 传入参数截图
     * */
    public void takeScreenShot(TakesScreenshot drivername, String path) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	System.out.println("截图成功");
        }
    }

	public void setCookie(Cookie cookie) {
		driver.manage().addCookie(cookie);
	}

	public Set<Cookie> getCookie() {
		// TODO Auto-generated method stub
		return null;
	}  
	
	
	
}
