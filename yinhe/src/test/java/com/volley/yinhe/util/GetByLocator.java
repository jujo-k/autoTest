package com.volley.yinhe.util;

import org.openqa.selenium.By;

public class GetByLocator {
	public static By getLocator(String key){
		ProUtil pro = new ProUtil("element.properties");
		String locator = pro.getPro(key);
		String locatorType = locator.split(">")[1];
		String locatorValue = locator.split(">")[0];
		if(locatorType.equals("id")){
			return By.id(locatorValue);
		}else if(locatorType.equals("name")){
			return By.name(locatorValue);
		}else if(locatorType.equals("tagName")){
			return By.tagName(locatorValue);
		}else if(locatorType.equals("linkText")){
			return By.linkText(locatorValue);
		}else if(locatorType.equals("className")){
			return By.className(locatorValue);
		}else{
			return By.xpath(locatorValue);
		}
	}
}
