package com.volley.yinhe.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件
 * */

public class ProUtil {
	private String filePath;
	private Properties prop;
	public ProUtil(String filePath) {
		this.filePath = filePath;
		this.prop = readProperties();
	}
	/**
	 * 读取文件
	 * */
	private Properties readProperties(){
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(filePath);
			BufferedInputStream in = new BufferedInputStream(inputStream);
			properties.load(in);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	/*
	 * 根据key查询值
	 * */
	public String getPro(String key) {
		if(prop.containsKey(key)){
			String username = prop.getProperty(key);
			return username;
		}else{
			System.out.println("你获取key值不对");
			return "";
		}	
	}
	/**
	 * 写入内容
	 * */
	public void writePro(String key,String value){
		Properties pro = new Properties();
			try {
				FileOutputStream file = new FileOutputStream(filePath);
				pro.setProperty(key, value);
				pro.store(file, key);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}
