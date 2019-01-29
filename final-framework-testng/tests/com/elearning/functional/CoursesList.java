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
import com.elearning.pom.CoursesListPOM;
import com.elearning.pom.ELoginPOM;
import com.elearning.pom.UnsubscribePOM;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CoursesList{
	private WebDriver driver;
	private String baseUrl;
	private CourseDescPOM coursedescPOM;
	private CoursesListPOM courselistPOM;
	private ELoginPOM loginpom;
	private UnsubscribePOM unsubspom;
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
		courselistPOM = new CoursesListPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		loginpom = new ELoginPOM(driver);
		unsubspom = new UnsubscribePOM(driver);
		coursedescPOM = new CourseDescPOM(driver);
		
	}
  

  @Test (priority = 1)
 	public void validLoginTest() 
 	{
	  System.out.println("Enter Login Details");
 	  loginpom.sendUserName("mthangavelu123");
 	  loginpom.sendPassword("malar123");
 	  loginpom.clickLoginBtn(); 
 		
 	}
  
  @Test (priority = 2)
  public void createCourseListTest() throws InterruptedException
  {
	  
	  coursedescPOM.mycoursetab();
	  courselistPOM.clickoncoursecat();
	  courselistPOM.sendsearchtxt("aelenium6");
	  courselistPOM.clickonsearch();
	  courselistPOM.getcoursetext();
	  
	  
	  screenShot.captureScreenShot("CourseListed");
	  Thread.sleep(1000);
	  //String expected1 = coursedescPOM.handleAlert();
	  String expected1 = "aelenium6";
	  String actual1 = courselistPOM.getcoursetext();
	  assertEquals(actual1, expected1);
	  Thread.sleep(3000);
	  
  }
	  
   

}
