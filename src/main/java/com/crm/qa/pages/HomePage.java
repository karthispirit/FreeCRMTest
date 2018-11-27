package com.crm.qa.pages;

 

 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

 

public class HomePage extends TestBase{
	
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement loginNameLabel;
	
	@FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[4]/a")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[5]/a")
	WebElement dealsLink;
	
	@FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[6]/a")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	//Initizlise
	public  HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String validateHomeTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername() {
		
		return loginNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContatsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clinkOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
				
	}
	
	public TaskPage clickOnTaskPage() {
		tasksLink.click();
		return new TaskPage();
	
	}
	
	public void clickOnNewContact() {
		
		Actions act = new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
		}
	
	

}
