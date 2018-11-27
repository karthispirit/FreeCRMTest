package com.crm.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// Pagefactoy
	@FindBy(name ="username")
     WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div/input")
	WebElement loginbutton;
	
	@FindBy(linkText = "Sign Up")
	WebElement signup;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/a/img")
	WebElement crmlogo;
	

    //Initialize objects
	public LoginPage() {
		
	PageFactory.initElements(driver,this);
	
	}
	
	//Actions:
	public String  validateLoginPage() {
	     return driver.getTitle();
	}
	
	
	public boolean validatecrmImage() {
		return crmlogo.isDisplayed();
	}
	
	public  HomePage login (String un, String pwd) throws Exception    {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginbutton.click();
		return new HomePage();
	}
}
