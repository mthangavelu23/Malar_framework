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
import com.elearning.pom.ELoginPOM;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCourse {
	private WebDriver driver;
	private String baseUrl;
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
  
  @AfterClass
  public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
  
  
  @Test(priority = 0)
  public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addcoursePOM = new AddCoursePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
  

  @Test (priority = 1)
	public void validLoginTest() 
	{
	  addcoursePOM.sendUserName("mthangavelu123");
	  addcoursePOM.sendPassword("malar123");
	  addcoursePOM.clickLoginBtn(); 
		
	}
  
  @Test (priority = 2)
  public void createCourseTest() throws InterruptedException
  {
	  addcoursePOM.clickCourselink();
	  addcoursePOM.sendcourse("felenium4");
	  addcoursePOM.advanceds();
	  addcoursePOM.sendcategory();//how to choose values from list box
	  Thread.sleep(3000);
	  addcoursePOM.sendcoursecategory("(PROJ) Projects");
	  addcoursePOM.sendcoursecode("fele4");
	 addcoursePOM.sendlanguage("English");
	  addcoursePOM.clickcoursesubmit();
	  //String expected = "melenium8";
	  
	  //Check course is created - how to handle this object as it is dynamic
	 //String actual = addcoursePOM.getcoursepagecontent();
	  //System.out.println(actual);
	  //assertEquals(actual, expected);
	  screenShot.captureScreenShot("Course_created");
	  
	  //Add Course Intro text
	  Thread.sleep(3000);
	  addcoursePOM.clickAddIntrotext();
	  //chk of intro text window appears..? 
	  addcoursePOM.setfocus("this is an selenium course");
	  //addcoursePOM.sendframetext("this is an selenium course");
	  addcoursePOM.clicksaveintro();
	  //addcoursePOM.isexists();
	  
	  String expected1 = "this is an selenium course";
	  String actual1 = addcoursePOM.getcoursetext();
	  assertEquals(actual1, expected1);
	  //System.out.println(driver.switchTo().alert().getText()); 
	  Thread.sleep(3000);
	  
  }
	  
   

}
