package com.volley.yinhe.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.volley.yinhe.base.DriverBase;

/**
 * BasePage 获得driver 封装element
 * 封装element 的方法
 * */
public class BasePage {
	DriverBase driver;
	public BasePage(DriverBase driver) {
		this.driver = driver;
	}
	
	public WebElement element(By by) {
		return driver.findElement(by);
	}
	
	public List<WebElement> elements(By by){
		return driver.findElements(by);
	}
	
	/**
	 * 封装点击
	 * */
	public void click(WebElement element){
		if(element !=null){
			element.click();
		}else{
			System.out.println("元素没有定位到，点击失败。");
		}
	}
	
	/**
	 * 封装输入
	 * */
	public void sendkeys(WebElement element,String value){
		if(element !=null){
			element.sendKeys(value);
		}else{
			System.out.println(element+"元素没有定位到，输入失败"+value);
		}
	}
	
	/**
	 * 判断元素是否显示
	 * */
	public boolean assertElementIs(WebElement element){
		return element.isDisplayed();
	}
	/**
	 * 获取文本信息
	 */
	public String getText(WebElement element) {
		return element.getText();
	}
	/**
	 * 获取title信息
	 */
	public String getTitle() {
		return driver.getTitle();
	}
	/**
	 * 悬停封装
	 * */
	public void moveToElement(WebElement elementHang){
		Actions a = new Actions(driver.getDriver());
		a.moveToElement(elementHang).perform();
	}
	
	/**
	 * 刷新页面
	 * */
	public void freshPage() {
		driver.getDriver().navigate().refresh();
	}
	/**
	 * 切换模态框
	 * */
	public void switchToMode() {
		driver.switchToMode();
	}
	
	/**
	 * 获取当前窗口所有的windows
	 * */
    public String getWindowsHandle(){
    	String handle = driver.getWindowHandle();
    	return handle;
    }
    
	
	/**
	 * 获取当前窗口所有的windows
	 * */
    public List<String> getWindowsHandles(){
    	List<String> handles = driver.getWindowsHandles();
    	return handles;
    }
 
    
    /**
     * 根据title切换新窗口
     * */
    public boolean switchToWindow_Title(String windowTitle) {
        boolean flag = false;
        try {
            String currentHandle = driver.getWindowHandle();
            List<String> handles = driver.getWindowsHandles();
            for (String s : handles) {
                if (s.equals(currentHandle))
                    continue;
                else {
                    driver.switchWindows(s);
                    if (driver.getTitle().contains(windowTitle)) {
                        flag = true;
                        System.out.println("切换windows成功: " + windowTitle);
                        break;
                    } else
                        continue;
                }
            }
        } catch (NoSuchWindowException e) {
            System.out.println("Window: " + windowTitle + " 没找到!!!"
                    + e.fillInStackTrace());
            flag = false;
        }
        return flag;
    }
	
	
}
