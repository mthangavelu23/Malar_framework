package com.elearning.functional;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.elearning.pom.AddCoursePOM;
import com.elearning.pom.CourseDescPOM;
import com.elearning.pom.ELoginPOM;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CourseDesc {
	private WebDriver driver;
	private String baseUrl;
	private CourseDescPOM coursedescPOM;
	private ELoginPOM loginpom;
	private GenericMethods gen;
	private static Properties properties;
	private ScreenShot screenShot;
	
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
		
	  properties = new Properties();
	  FileInputStream inStream = new FileInputStream("./resources/others.properties");
	  properties.load(inStream);
  }
  
  @AfterClass
  public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
  
  
  @Test(priority = 0)
  public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		coursedescPOM = new CourseDescPOM(driver); 
		loginpom = new ELoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
  

  @Test (priority = 1)
	public void validLoginTest() 
	{
	  loginpom.sendUserName("mthangavelu123");
	  loginpom.sendPassword("malar123");
	  loginpom.clickLoginBtn(); 
		
	}
  
  @Test (priority = 2)
  public void createCourseDescTest() throws InterruptedException
  {
	  coursedescPOM.clickCoursetitle();
	  coursedescPOM.clickcoursedescicon();
	  coursedescPOM.clickdescicon();
	  coursedescPOM.sendtitle("Felenium10");
	  coursedescPOM.senddesc("Felenium10 Introduction");
	  coursedescPOM.clicksavebutton();
	  screenShot.captureScreenShot("Course_updated");
	  Thread.sleep(1000);
	  //String expected1 = coursedescPOM.handleAlert();
	  String expected1 = "The description has been updated";
	  String actual1 = coursedescPOM.getcoursetext();
	  assertEquals(actual1, expected1);
	  //System.out.println(driver.switchTo().alert().getText()); 
	  Thread.sleep(3000);
	  
  }
	  
   

}
