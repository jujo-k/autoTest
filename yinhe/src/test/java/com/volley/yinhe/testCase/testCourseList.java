package com.volley.yinhe.testCase;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.volley.yinhe.base.DriverBase;
/**
 * * 有多层div的时候定位容易定位到外面，我们往往用div里更具体的元素进行定位
 * 这个例子用的是  介绍p   xpath  contains  ...
 * 用了list，定位到介绍，点击介绍，然后返回  返回有一个刷新
 * 报错误说，这个element 是stale  要么不在这个frame里要么就是刷新了，刷新了之后要获取下一个，刷新在获取元素的循环外，所以每次都只能拿到第一个
 * 先把所有的p里的内容拿到，然后进行循环，把返回刷新的操作放在循环里，不是放在循环外
 * 抓到p的时候，发现外面的a 使之模糊，无法点击。selenium模拟用户单击元素时，JS有一个操作鼠标悬浮的时候会对元素进行修改
 * 用js控制
 * 遍历的时候有一个抓不到，以为使时间的问题，后来看了一下就这个标题里有空格，就截取了一段进行find
 *
 * */
public class testCourseList extends CaseBase{
	public DriverBase driver;
	public testCourseList() {
		this.driver = InitDriver("fireFox");
	}
	
	@Test
	public void CourseList() {
		driver.get("https://coding.imooc.com/");
		driver.maximize();
		List<String> listString = this.listElement();
		for(int i=0;i<listString.size();i++) {
//			driver.findElement(By.xpath("//p[contains(text(),'"+listString.get(i)+"')]")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i).substring(0, 8)+"')]")));
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            driver.back();
		}
		driver.stop();
	}
	
	//获取所有课程简介
	public List<String> listElement(){
		List<String> listString = new ArrayList<String>();
		WebElement element = driver.findElement(By.className("shizhan-course-list"));
		List<WebElement> listElement = element.findElements(By.className("shizhan-course-box"));
		for(WebElement el :listElement) {
			listString.add(el.findElement(By.className("shizan-desc")).getText());
		}
		
		return listString;
	}
}
