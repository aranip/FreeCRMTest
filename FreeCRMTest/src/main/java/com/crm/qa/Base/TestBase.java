package com.crm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;


import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

import org.openqa.selenium.WebDriver;

public class TestBase {
 public static WebDriver driver;
 public static Properties prop;
 public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/amruthapenigalapati/eclipse-workspace/corejava/src/Basic_java/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties"
					);
		prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/amruthapenigalapati/Downloads/chromedriver");
		 driver = new ChromeDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();  //maximize window
        driver.manage().deleteAllCookies();  //delete all cookies
       driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        
	}
}

