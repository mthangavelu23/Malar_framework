package com.elearning.functional;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import com.elearning.pom.TC66CreateTakeTestPOM;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC66CreateTakeTestTest {

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
	private TC66CreateTakeTestPOM tc66createtaketestpom;

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
		addcoursePOM = new AddCoursePOM(driver);
		loginPOM = new ELoginPOM(driver);
		reviewpom = new TC37ReviewPOM(driver);
		tc36reportsendpom = new TC36ReportSendPOM(driver);
		tc38creategroup = new TC38CreateGroupPOM(driver);
		tc39generatereport = new TC39GenerateReportPOM(driver);
		tc40createprojectpom = new TC40CreateProjectPOM(driver);
		tc66createtaketestpom = new TC66CreateTakeTestPOM(driver);
	}

	@Test(priority = 1)
	// Login into application
	public void loginTest() throws Exception {
		loginPOM.sendUserName("mthangavelu111");
		loginPOM.sendPassword("malar111");
		loginPOM.clickLoginBtn();
	}

	@Test(priority = 2)
	public void createNewTest() throws Exception {
		addcoursePOM.clickCourselink();
		addcoursePOM.sendcourse("1Selenium9");
		addcoursePOM.clickcoursesubmit();
		//coursedescPOM.mycoursetab();
		//tc36reportsendpom.homepgcourseclk();
		tc36reportsendpom.testiconclk();
		tc66createtaketestpom.createnewtest();
		tc66createtaketestpom.testname("1em");
		addcoursePOM.advanceds();
		addcoursePOM.setfocus("This is new Selenium Test6");
		tc66createtaketestpom.atendoftest();
		tc66createtaketestpom.enabletest();
		//WebDriver wait = new WebDriver()
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//tc66createtaketestpom.timeiconclk();
		//tc66createtaketestpom.selectmonth("Feb");
		//tc66createtaketestpom.selectyear("2019");
		// choose select day
		tc66createtaketestpom.passpercent("60");
		tc66createtaketestpom.proceedquestions();

	}

	@Test(priority = 3, dependsOnMethods = { "createNewTest" }, enabled = true)
	public void addQuestionTest() throws Exception {
		tc66createtaketestpom.multiplechoiceiconclk();
		tc66createtaketestpom.enterquestion("What is TestNG?");
		tc66createtaketestpom.setfocus("Open Source framework");
		// include to enter all 3 choices
		tc66createtaketestpom.firstchoicerbclk();
		tc66createtaketestpom.addquestionclk();
		tc66createtaketestpom.multiplechoiceiconclk();
		tc66createtaketestpom.enterquestion("What are the Selenium IDE");
		tc66createtaketestpom.setfocus("Webdriver Webdriver IDE");
		// include to enter all 3 choices
		tc66createtaketestpom.secondchoicerbclk();
		tc66createtaketestpom.addquestionclk();
		//insert assertion
		tc66createtaketestpom.previewclk();
	}

	@Test(priority = 4, dependsOnMethods = { "addQuestionTest" }, enabled = true)
	public void addsecondQuestionTest() throws Exception {
		tc66createtaketestpom.multiplechoiceiconclk();
		tc66createtaketestpom.enterquestion("What is TestNG?");
		tc66createtaketestpom.setfocus("Open Source framework");
		// include to enter all 3 choices
		tc66createtaketestpom.firstchoicerbclk();
		tc66createtaketestpom.addquestionclk();
		tc66createtaketestpom.multiplechoiceiconclk();
		tc66createtaketestpom.enterquestion("What are the Selenium IDE");
		tc66createtaketestpom.setfocus("Webdriver Webdriver IDE");
		// include to enter all 3 choices
		tc66createtaketestpom.secondchoicerbclk();
		tc66createtaketestpom.addquestionclk();
		tc66createtaketestpom.previewclk();
		//insert assertion - TO SEE IF start button dsplayed
	}

	@Test(priority = 5, dependsOnMethods = { "addQuestionTest" }, enabled = true)
	public void logoutTest() throws Exception {
	
		tc66createtaketestpom.logouticon();
		tc66createtaketestpom.logoutlnk();
	
	}
	@Test(priority = 6, dependsOnMethods = { "logoutTest" }, enabled = true)	
	public void studentloginTest() throws Exception {
		loginPOM.sendUserName("Ashwin111");
		loginPOM.sendPassword("ashwin111");
		loginPOM.clickLoginBtn();
	}
	
	@Test(priority = 7, dependsOnMethods = { "addQuestionTest" }, enabled = true)
	public void studentsubscribecourseTest() throws Exception {
		tc66createtaketestpom.coursecatclk();
		tc66createtaketestpom.searchcourse("1Selenium9");
		tc66createtaketestpom.searchclk();
		tc66createtaketestpom.subscribecourse("1Selenium9");
		
	}
	@Test(priority = 8, dependsOnMethods = { "studentsubscribecourseTest" }, enabled = true)
	public void studenttaketestTest() throws Exception {
		tc66createtaketestpom.
		tc66createtaketestpom.searchcourse("1Selenium9");
		tc66createtaketestpom.searchclk();
		tc66createtaketestpom.subscribecourse("1Selenium9");
		
	}
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
