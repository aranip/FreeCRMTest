package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.Base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]")
	WebElement contactsLabel;
	
	
	
	@FindBy(name="first_name")
	WebElement firstName;

	@FindBy(name="last_name")
	WebElement lastName;

	@FindBy(xpath ="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[4]/div/div/div/div/div[1]/input")
	WebElement email;
	//input[@name = 'value' and placeholder = 'Email address']

	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[2]/div/button[2]")
	WebElement saveBtn;



	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[2]")).click();
	}
	//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[2]
	//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[4]/td[2]

	public void createNewContact( String ftName, String ltName, String mail){
//		Select select = new Select(driver.findElement(By.name("title")));
//		select.selectByVisibleText(title);

		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		email.sendKeys(mail);
		saveBtn.click();
//public void createNewContact(){
//		driver.findElement(By.name("first_name")).sendKeys("tom");
//        driver.findElement(By.name("last_name")).sendKeys("peter");
//        driver.findElement(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[4]/div/div/div/div/div[1]/input")).sendKeys("petertom@gmail.com");
//        driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/button[2]")).click();


	}


}
