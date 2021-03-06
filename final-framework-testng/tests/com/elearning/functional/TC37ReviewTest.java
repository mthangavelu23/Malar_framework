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
import com.elearning.pom.TC36ReportSendPOM;
import com.elearning.pom.TC38CreateGroupPOM;
import com.elearning.pom.TC39GenerateReportPOM;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC37ReviewTest<screenShot> {
	private WebDriver driver;
	private String baseUrl;
	private ELoginPOM loginPOM;
	private CourseDescPOM coursedescPOM;
	private AddCoursePOM addcoursePOM;
	private TC37ReviewPOM reportsendpom;
	
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
		reportsendpom = new TC37ReviewPOM(driver);
	}
	
	@Test (priority = 1)
	public void ReportCorrectTest() throws Exception 
	{
		loginPOM.sendUserName("mthangavelu111");
		loginPOM.sendPassword("malar111");
		loginPOM.clickLoginBtn(); 
		reportsendpom.mycoursetab();
		reportsendpom.courselink();
		reportsendpom.reporticonclk();
		reportsendpom.studentclk();
		reportsendpom.rtarrowclk();
		reportsendpom.quizoicon();
		
	}
	
	@Test (dependsOnMethods= {"ReportCorrectTest"},priority = 2)
	public void SendEmailTest() throws Exception 
	{
		reportsendpom.sendemailchkbox();
		reportsendpom.correcttestclk();
		
	}
	
	@Test (dependsOnMethods= {"SendEmailTest"},priority = 3)
	public void AssertTest() throws Exception 
	{
		String expected = "Message Sent";
		screenShot.captureScreenShot("Emailsent");
		Thread.sleep(1000);
		String actual = coursedescPOM.getcoursetext();
		assertEquals(actual, expected);
		
	}

	@Test (dependsOnMethods= {"AssertTest"},priority = 4)
	public void courseclk() {
		reportsendpom.courselink();
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
		
	
	
	
}



	