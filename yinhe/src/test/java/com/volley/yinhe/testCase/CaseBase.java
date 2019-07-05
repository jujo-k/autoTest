package com.volley.yinhe.testCase;

import com.volley.yinhe.base.DriverBase;

public class CaseBase {
	public DriverBase InitDriver(String browser){
		return new DriverBase(browser);
	}

}
