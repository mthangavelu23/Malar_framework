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

	}

	@Test(priority = 1)
	// Login into application
	public void loginTest() throws Exception {
		loginPOM.sendUserName("mthangavelu111");
		loginPOM.sendPassword("malar111");
		loginPOM.clickLoginBtn();
	}

	@Test(priority = 2)
	public void createNewProjectTest() throws Exception {
		coursedescPOM.mycoursetab();
		tc36reportsendpom.homepgcourseclk();
		tc40createprojectpom.clickprojecticon();
		tc40createprojectpom.createnewproject();
		tc40createprojectpom.addtitleblog("Selenium3");
		tc40createprojectpom.addsubtitleblog("Selenium11");
		tc40createprojectpom.saveblog();
		//tc40createprojectpom.projectlnkclik("Selenium3");
		tc40createprojectpom.projectlnkclik();

	}

	@Test(dependsOnMethods = { "createNewProjectTest" }, priority = 3)
	public void createNewTaskTest() throws Exception {

		tc40createprojectpom.newtask();
		tc40createprojectpom.addnewtasktitle("NewTask5");
		tc40createprojectpom.savenewtasktitle();

	}

	@Test(dependsOnMethods = { "createNewTaskTest" }, priority = 4)
	public void createNewRoleTest() throws Exception {

		tc40createprojectpom.rolemgmticon();
		tc40createprojectpom.addnewrole();
		tc40createprojectpom.enternewrole("QA Consultant");
		tc40createprojectpom.savenewrole();

	}

	@Test(dependsOnMethods = { "createNewRoleTest" }, priority = 5)
	public void assignNewRoleTest() throws Exception {

		tc40createprojectpom.assignroleicon();
		tc40createprojectpom.selectuser("Abishek karthi");
		//tc40createprojectpom.enteruser("Ashwin karthi");
		tc40createprojectpom.selecttask("Project manager");
		//tc40createprojectpom.entertask("QA Consultant");
		tc40createprojectpom.validateduserrole();

	}

	@Test(dependsOnMethods = { "assignNewRoleTest" }, priority = 6)
	public void registerProjectUserTest() throws Exception {

		tc40createprojectpom.usermgmticon();
		tc40createprojectpom.userchkbox();
		tc40createprojectpom.clkregister();

	}

	@Test(dependsOnMethods = { "registerProjectUserTest" }, priority = 7)
	public void AssertUserregisterTest() throws Exception {

		String expected = "The user has been registered";
		String actual = tc38creategroup.alerttext();
		assertEquals(actual, expected);

	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
