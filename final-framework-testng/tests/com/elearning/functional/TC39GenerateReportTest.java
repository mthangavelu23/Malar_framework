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

public class TC39GenerateReportTest {

	private WebDriver driver;
	private String baseUrl;
	private ELoginPOM loginPOM;
	private CourseDescPOM coursedescPOM;
	private AddCoursePOM addcoursePOM;
	private TC37ReviewPOM reportsendpom;
	private TC36ReportSendPOM tc36reviewpom;
	private GenericMethods gen;
	private static Properties properties;
	private ScreenShot screenShot;
	private TC39GenerateReportPOM tc39generatereport;
	private TC38CreateGroupPOM tc38creategroup;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}

	@Test(priority = 0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new ELoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		//declare objects of POM classes
		coursedescPOM = new CourseDescPOM(driver);
		loginPOM = new ELoginPOM(driver);
		reportsendpom = new TC37ReviewPOM(driver);
		tc36reviewpom = new TC36ReportSendPOM(driver);
		tc38creategroup = new TC38CreateGroupPOM(driver);
		tc39generatereport = new TC39GenerateReportPOM(driver);

	}

	@Test(priority = 1)
	//Login into application
	public void loginTest() throws Exception {
		loginPOM.sendUserName("mthangavelu111");
		loginPOM.sendPassword("malar111");
		loginPOM.clickLoginBtn();
	}

	@Test(priority = 2)
	//Click on report tab
	public void ReporttabTest() throws Exception {
		tc39generatereport.reporttabclk();
		tc39generatereport.followedstudentclk();
		tc39generatereport.enterkeyword("Ashwin");
		tc39generatereport.searchsubmitclk();

	}

	@Test(dependsOnMethods= {"ReporttabTest"},priority = 3)
	public void RtclkStudentTest() throws Exception {
		tc39generatereport.selectstudentrowclk();
		tc39generatereport.rtarrowclkstudent();
		
		
		}
	@Test(dependsOnMethods= {"RtclkStudentTest"},priority = 4)
	public void RtclkDetailsTest() throws Exception {
	
		tc39generatereport.selecttestrowclk();
		//rt arrow click not working 
		//Thread.sleep(3000);
		//tc39generatereport.selecttestrowclk();
		tc39generatereport.rtarrowclkdetails();
		//Thread.sleep(3000);
		tc39generatereport.quiziconclk();

	}

	@Test(dependsOnMethods= {"RtclkDetailsTest"},priority = 5)
	public void SendEmailTest() throws Exception {

		reportsendpom.sendemailchkbox();
		reportsendpom.correcttestclk();

	}

	@Test(dependsOnMethods= {"SendEmailTest"},priority = 6)
	public void AssertTest() throws Exception {

		String expected = "Message Sent";
		String actual = coursedescPOM.getcoursetext();
		assertEquals(actual, expected);

	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
