package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
 

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
 public static WebDriver driver;
 public static  Properties prop;
 public static EventFiringWebDriver e_driver;
 public static WebEventListener eventListener;


public TestBase() {
	// TODO Auto-generated constructor stub
	
	try {
		
	prop = new Properties();
	FileInputStream input = new FileInputStream("C:\\Users\\kartsub4\\eclipse-workspace\\FreeCRMtest\\"
			+ "src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	prop.load(input);
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch (IOException e) {
		e.printStackTrace();
	}
}


	public static void initialization() {
		
		
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kartsub4\\Desktop\\Personal\\Selenium software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		} else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C://Users//kartsub4//Desktop//geckodriver-v0.23.0-win64/geckodriver.exe");
		driver = new ChromeDriver();
		}
		 
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}	

}
