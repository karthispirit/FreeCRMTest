package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TaskPage taskPage;
	
	public  HomePageTest() {
		super();
	}

	
	@BeforeMethod
	public void Logincrmpage() throws Exception {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=0)
	public void verifyHomePageTest()  {
		
		String hpTitle = homePage.validateHomeTitle();
		Assert.assertEquals(hpTitle, "CRMPRO" );
	}
	
	@Test(priority=1)
	public void verifyLoginnameTest() {
		
		testUtil.switchToFrame();
		boolean hp_lgn = homePage.verifyCorrectUsername();
		Assert.assertTrue(hp_lgn);
		
	}
	
	@Test (priority=2)
	  public void verifyContatsLinktest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContatsLink();
	}

	@Test (priority=3)
	  public void verifyDealsLinktest() {
		testUtil.switchToFrame();
		dealsPage = homePage.clinkOnDealsLink();
	}
	
	@Test (priority=4)
	  public void verifyTaskLinktest() {
		testUtil.switchToFrame();
		taskPage = homePage.clickOnTaskPage();
	}
		
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
}
