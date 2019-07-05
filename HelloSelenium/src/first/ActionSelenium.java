package first;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionSelenium {
	public WebDriver driver;
	
	//加载驱动，打开登陆网址
	public void InitDriver() {
		System.setProperty("webdriver.gecko.driver", "D:\\安装文件夹\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.imooc.com");
	}
	
	/*
	 * 点击登陆
	 * 输入账号密码，去掉自动登陆，再clear掉内容
	 * 点击登陆，获得placeholder的内容
	 * 再登陆
	 * 就是完成了登陆
	 * */
	public void inputBox() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * 点击登陆,发现是个超链接，用抓不到，就用linkText，发现linkText也抓不到
		 * 用xpath,还是空指针抓不到，真是奇了怪了
		 * 
		 * 后来发现在另一个iframe里是无法调用的，如果target="testIframeName" 的话，然而并不是！
		 * 
		 * 最终原因：初始化的时候又重新声明了webdriver driver 只在init方法里有效，这里用的这个driver就是类变量，没有对象，所有什么都抓不到
		 * */
		driver.findElement(By.id("js-signin-btn")).click();;
		
//		driver.findElement(By.linkText("登录")).click();
//		driver.findElement(By.xpath("//a[@href='//www.imooc.com/user/newlogin']")).click();
		
		//跳出一个promt
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.name("email")).sendKeys("xxxxx");
		driver.findElement(By.name("password")).sendKeys("xxxxx");
		//这一步要勾，定位错误，定位到一整个label上去了
//		driver.findElement(By.className("rlf-autoin l")).click();
		driver.findElement(By.id("auto-signin")).click();
		
		/*
		driver.findElement(By.name("email")).clear();
		
		String s = driver.findElement(By.name("email")).getAttribute("placeholder");
		System.out.println(s);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.name("email")).sendKeys("15757390200");
		*/
		//我把登陆按钮一连串的东西都拉过来了，然后登陆不了，直接就一部分就可以了！
		driver.findElement(By.className("moco-btn")).click();

	}
	
	/**
	 * 单选框的选择，加一个判断，已经选了默认了就不选了，没默认再选
	 * radio加一个判断，如果已经是默认了就不点击了，选择下一个
	 * 下载了一个xpath helper很好用，写的时候把label写成lable 导致错误，所以尽量直接copy过来
	 */
	public void raido() {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.get("https://www.imooc.com/user/setprofile");
		driver.findElement(By.className("pull-right")).click();
		List<WebElement> es = driver.findElements(By.xpath("//*[@id='profile']/div[4]/div//label//input"));
		System.out.println(es.size());
		for(WebElement e:es) {
			boolean flag = e.isSelected();
			if(flag == false) {
				e.click();
				break;
			}else {
				System.out.println("选中了");
			}
		}
		driver.findElement(By.id("profile-submit")).click();
	}
	/*
	 * 上传文件，换头像
	 * 控制js代码，因为要点击的那个是botton -30px,执行的时候会看不见就改变让它上来，再点击就没有问题，其中就是要控制js代码
	 * 留一个问题刚开始上传失败，然后写了alert的代码，后来上传成功了,alert报错。
	 * */
	public void upHeader() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.get("https://www.imooc.com/user/setprofile");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//这一步直接在浏览器上调试
		String jsString = "document.getElementsByClassName('update-avator')[0].style.bottom='0'";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jsString);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.className("js-avator-link")).click();
		driver.findElement(By.id("upload")).sendKeys("C:\\Users\\孔姐\\Desktop\\test.jpg");
		driver.findElement(By.linkText("确定")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	/*
	 * 一个页面中有多个下拉框的时候，神奇的发现，通过id定位不行，
	 * 解决方式是通过层级定位，通过父节点再往下定位
	 * 
	 * 有些下拉框可以多选，通过isMultiple判断，多选了之后可以通过deselectAll等操作删除选中的。
	 * 
	 * 这个例子中是一个单选，就算是getAllSelectedOptions  方法也是只有一个
	 * 
	 * 一个骚操作就是，多选了之后getAll，然后进行删除。
	 * 
	 * */
	public void selectDown() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.get("https://www.imooc.com/user/setprofile");
		driver.findElement(By.className("pull-right")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement father = driver.findElement(By.id("profile"));
		
		WebElement job = father.findElement(By.id("job"));
		Select downList = new Select(job);
//		downList.selectByIndex(2);
//		downList.selectByValue("3");
		List<WebElement> list = downList.getAllSelectedOptions();
		downList.deselectAll();
		downList.isMultiple();
		for(WebElement l:list) {
			System.out.println(l.getText());
		}
 
	}
	
	/*
	 * 主要是action悬停操作，一定要perform
	 * 停了之后就可点击出现的内容
	 * */
	public void hang() {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement father = driver.findElement(By.className("menuContent"));
		List<WebElement> items = father.findElements(By.className("item"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(items.get(0)).perform();
		
		driver.findElement(By.linkText("微服务")).click();
	}
	
	
	/*
	 * 等待三种，强制等待，一种显示等待，隐式等待，
	 * 强制等待，死等，线程等待
	 * 隐式等待就是每一个都再后面等，例如如果找不到就等设定时间后再找，不会一下子就报错。10s之内用的比较少,每个页面都会去找，全局性的
	 * 显示等待，如果等不到，10钟过去了如果找不到就报错。如果1s找到了就继续下去
	 * 感觉显示隐式等待是一样的
	 * 
	 * */
	public void waitTest() {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//在这个页面里找这个，时间是10s.找不到报错
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test")));
	}
	
	public void exit() {
		driver.quit();
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		ActionSelenium as = new ActionSelenium();
		as.InitDriver();
//		as.waitTest();
		as.inputBox();
//		as.raido();
//		as.upHeader();
//		as.selectDown();
//		as.hang();
//		as.exit();
	}

}
