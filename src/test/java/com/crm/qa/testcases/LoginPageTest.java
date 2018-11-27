package com.crm.qa.testcases;

 

 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	
	 
	LoginPage loginpage;
	HomePage homePage;
	
	 public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=0)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPage();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=1)
	public void crmlogotest() {
		
		boolean logo = loginpage.validatecrmImage();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=2)
	public void LoginTest()  throws Exception {
		  homePage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		//homePage = loginpage.login("karthispirit", "karthispirit");
	}
	
	
    @AfterMethod
    public void closebrowser() {
    	driver.quit();
    }
}
