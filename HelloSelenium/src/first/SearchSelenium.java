package first;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchSelenium {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.gecko.driver", "D:\\安装文件夹\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		//创建FirefoxDriver实例,驱动firefox
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		//使用driver打开网页
		driver.get("https://www.baidu.com");
		
		
		WebElement search_setting = driver.findElement(By.linkText("设置"));
	    Actions action = new Actions(driver);
	    action.clickAndHold(search_setting).perform();
	    
	    WebElement aim = driver.findElement(By.className("setpref"));
	    aim.click();
	    Thread.sleep(8000);

		
		
		/*
		WebElement element = driver.findElement(By.id("kw"));
		
		element.sendKeys("Selenium");
		
		element.submit();
		*/
		//关闭浏览器
		driver.quit();
	}
}
