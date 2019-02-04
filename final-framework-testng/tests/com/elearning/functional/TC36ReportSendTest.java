package com.elearning.functional;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.elearning.pom.AddCoursePOM;
import com.elearning.pom.CourseDescPOM;
import com.elearning.pom.ELoginPOM;
import com.elearning.pom.TC37ReviewPOM;
import com.elearning.pom.TC39GenerateReportPOM;
import com.elearning.pom.TC36ReportSendPOM;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC36ReportSendTest {
  
	private WebDriver driver;
	private String baseUrl;
	private ELoginPOM loginPOM;
	private CourseDescPOM coursedescPOM;
	private AddCoursePOM addcoursePOM;
	private TC37ReviewPOM reviewpom;
	private TC36ReportSendPOM tc36reportsendpom;
	private TC39GenerateReportPOM tc39generatereportpom;
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
		coursedescPOM = new CourseDescPOM(driver);
		loginPOM = new ELoginPOM(driver);
		reviewpom = new TC37ReviewPOM(driver);
		tc36reportsendpom = new TC36ReportSendPOM(driver);
		tc39generatereportpom = new TC39GenerateReportPOM(driver);
		
	}
	
	@Test (priority = 1)
	public void ReportCorrectTest() throws Exception 
	{
		loginPOM.sendUserName("mthangavelu111");
		loginPOM.sendPassword("malar111");
		loginPOM.clickLoginBtn(); 
		coursedescPOM.mycoursetab();
		tc36reportsendpom.homepgcourseclk();
		tc36reportsendpom.testiconclk();
		
	}
	@Test (priority = 2)
	public void ProcessTest() throws Exception 
	{
		tc36reportsendpom.resultfeedbackclk();
		Thread.sleep(2000);
		tc36reportsendpom.gradeact();
		
	}
	
	@Test (dependsOnMethods= {"ProcessTest"},priority = 3)
	public void SendEmailTest() throws Exception
	{
		
		reviewpom.sendemailchkbox();
		reviewpom.correcttestclk();
		
	}
	
	@Test (dependsOnMethods= {"SendEmailTest"},priority = 4)
	public void AssertTest() throws Exception
	{
		
		String expected = "Message Sent";
		String actual = coursedescPOM.getcoursetext();
		assertEquals(actual, expected);
		
	}
	
	@Test (dependsOnMethods= {"AssertTest"},priority = 5)
	public void Clickcourselink() throws Exception
	{			
		tc36reportsendpom.courseclk();
	}
	
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
		
	
	
	
	
}
