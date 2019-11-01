package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class LoginPage extends TestBase {

	//Page factory--OR:
public	LoginPage() {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a")
	 WebElement signUp;
	
	
	 @FindBy(name = "email")
	WebElement username;
	 
	 @FindBy(name = "password")
	 WebElement password;
	 
	 @FindBy(xpath = "//*[@id='ui']/div/div/form/div/div[3]")
	 WebElement loginBtn;
	 
	@FindBy(xpath = "/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a")
	WebElement logo;
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return logo.isDisplayed();
	}

	public HomePage login(String un , String pwd){
		signUp.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
//    	JavascriptExecutor js = (JavascriptExecutor)driver;
//    	js.executeScript("arguments[0].click();", loginBtn);
//		//loginBtn.click();
		return new HomePage();
	}
}
