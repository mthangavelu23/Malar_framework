package com.elearning.functional;

import org.testng.annotations.Test;
import java.util.*;
import java.lang.annotation.*;
import com.elearning.generics.screenShots;
import com.elearning.pom.AddCoursePOM;
import com.elearning.pom.ELoginPOM;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
//import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class LoginTest<screenShot> {
	private WebDriver driver;
	private String baseUrl;
	private ELoginPOM loginPOM;
	private AddCoursePOM addcoursePOM;
	private GenericMethods gen;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}

	@Test (priority = 0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new ELoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	
	@Test (priority = 1)
	public void validLoginTest() 
	{
		loginPOM.sendUserName("mthangavelu456");
		loginPOM.sendPassword("malar456");
		loginPOM.clickLoginBtn(); 
		//WebElement ele = gen.getElement("//div[@class='normal-message']//p[1]\","css");
	}
				
	
	@Test(priority = 2)
	public void CheckpageTest() {
			
				String expected = "Hello Malar Thangavelu and welcome,";
				//WebElement ele = gen.getElement(locator, type);
				String actual = loginPOM.getpagecontent();
				System.out.println(actual);
				assertEquals(actual, expected);
				screenShot.captureScreenShot("ELogin");
			}
	
			
	}
