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
import com.elearning.pom.ReportSendPOM;
import com.elearning.pom.TC37ReviewPOM;
import com.elearning.pom.TC38CreateGroupPOM;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC38CreateGroupTest {
  
	private WebDriver driver;
	private String baseUrl;
	private ELoginPOM loginPOM;
	private CourseDescPOM coursedescPOM;
	private AddCoursePOM addcoursePOM;
	private ReportSendPOM reportsendpom;
	private TC37ReviewPOM tc36reviewpom;
	private TC38CreateGroupPOM tc38creategrouppom;
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
		reportsendpom = new ReportSendPOM(driver);
		tc36reviewpom = new TC37ReviewPOM(driver);
		tc38creategrouppom = new TC38CreateGroupPOM(driver);
		
	}
	
	@Test (priority = 1)
	public void CreateGroupTest() throws Exception 
	{
		loginPOM.sendUserName("mthangavelu111");
		loginPOM.sendPassword("malar111");
		loginPOM.clickLoginBtn(); 
		reportsendpom.mycoursetab();
		reportsendpom.courselink();
		tc38creategrouppom.clickgroupicon();
		tc38creategrouppom.createnewgroup();
		tc38creategrouppom.groupcount("1");
		tc38creategrouppom.proceedgroup();
		
		}
	
	@Test (priority = 2)
	public void CreateNewGroupTest() throws Exception 
	{
		tc38creategrouppom.entergrouptext("Felenium");
		tc38creategrouppom.submitnewgroup();
		
			}
	@Test (priority = 3)
	public void SelectGroupmemberTest() throws Exception 
	{
		tc38creategrouppom.clickaddgroupmember();
		tc38creategrouppom.selectgroupmember("Ashwin karthi (Ashwin111) - ASHWIN111");
		tc38creategrouppom.savesettings();
		
	}
	@Test (priority = 4)
	public void GroupAssertTest() throws Exception 
	{
		String expected = "Group settings modified";
		String actual = tc38creategrouppom.alerttext();
		assertEquals(actual, expected);
		
	}
		
		
		@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
		
	
}
