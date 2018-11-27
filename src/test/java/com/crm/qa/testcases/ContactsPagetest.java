package com.crm.qa.testcases;

 
 
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPagetest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public   ContactsPagetest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));		  
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContatsLink();
	}
	
	@Test(priority=0)
	public void verifyContactslabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	
	@Test(priority=1)	
	public void verifyContactsName() {
		contactsPage.verifyContactsName(prop.getProperty("tablename"));
	}
	
	@Test(priority=2)
	public void verifyMultiContactsName() throws Exception {
		contactsPage.verifyContactsName(prop.getProperty("tablename"));
		contactsPage.verifyContactsName("111 222");
		Thread.sleep(5000);
	} 
	
	@DataProvider
	public Object[][] getTestdataTest( ) {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority =4, dataProvider="getTestdataTest")
	public void validateNewContactCreate(String title, String fn, String ln,String comp) {
		homePage.clickOnNewContact();
		contactsPage.newContactCreate(title, fn, ln, comp);
		 
	}
	
	 
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
}
