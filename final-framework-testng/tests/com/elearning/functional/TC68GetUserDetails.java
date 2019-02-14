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
import com.elearning.pom.TC40CreateProjectPOM;
import com.elearning.pom.TC67AddUserPOM;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC68GetUserDetails {

	private WebDriver driver;
	private String baseUrl;
	private ELoginPOM loginPOM;
	private CourseDescPOM coursedescPOM;
	private AddCoursePOM addcoursePOM;
	private TC37ReviewPOM reviewpom;
	private TC36ReportSendPOM tc36reportsendpom;
	private GenericMethods gen;
	private static Properties properties;
	private ScreenShot screenShot;
	private TC39GenerateReportPOM tc39generatereport;
	private TC38CreateGroupPOM tc38creategroup;
	private TC40CreateProjectPOM tc40createprojectpom;
	private TC67AddUserPOM tc67adduserpom;

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
		// declare objects of POM classes
		coursedescPOM = new CourseDescPOM(driver);
		loginPOM = new ELoginPOM(driver);
		reviewpom = new TC37ReviewPOM(driver);
		tc36reportsendpom = new TC36ReportSendPOM(driver);
		tc38creategroup = new TC38CreateGroupPOM(driver);
		tc39generatereport = new TC39GenerateReportPOM(driver);
		tc40createprojectpom = new TC40CreateProjectPOM(driver);
		tc67adduserpom = new TC67AddUserPOM(driver);
		
	}
	
	@Test (priority = 1)
	public void validLoginTest() 
	{
	  loginPOM.sendUserName("admin");
	  loginPOM.sendPassword("admin@123");
	  loginPOM.clickLoginBtn(); 
		
	}
	@Test(priority = 2, dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void adduserDBTest(String fname, String lname,String email,String phone,String userlogin,String password) {
				
		tc67adduserpom.clickadmintab();
		tc67adduserpom.adduserlink();
		tc67adduserpom.enterfirstname(fname);
		tc67adduserpom.enterlastname(lname);
		tc67adduserpom.enteremail(email);
		tc67adduserpom.enterphone(phone);
		tc67adduserpom.enterloginname(userlogin);
		//tc67adduserpom.selectpasswordoption();
		tc67adduserpom.enterpassword(password);
		tc67adduserpom.adduserbtn();
		screenShot.captureScreenShot("user_Created");
		
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
