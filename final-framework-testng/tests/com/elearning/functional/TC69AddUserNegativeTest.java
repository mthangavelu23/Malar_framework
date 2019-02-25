package com.elearning.functional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
import com.elearning.pom.TC69AddUserNegativePOM;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC69AddUserNegativeTest {

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
	private TC69AddUserNegativePOM tc69addusernegativepom;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}

	@Test(priority = 0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// declare objects of POM classes
		loginPOM = new ELoginPOM(driver);
		tc67adduserpom = new TC67AddUserPOM(driver);
		coursedescPOM = new CourseDescPOM(driver);
		tc69addusernegativepom = new TC69AddUserNegativePOM(driver);

	}

	@Test(priority = 1)
	// Login into application
	public void loginTest() throws Exception {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
	}

	@Test(priority = 2, dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void addNewUserTest(String firstname, String lastname, String email, String phone, String loginname,
			String password) throws Exception {
		tc67adduserpom.clickadmintab();
		tc67adduserpom.adduserlink();
		tc67adduserpom.enterfirstname(firstname);
		tc67adduserpom.enterlastname(lastname);
		tc67adduserpom.enteremail(email);
		tc67adduserpom.enterphone(phone);
		tc67adduserpom.enterloginname(loginname);
		tc67adduserpom.selectpasswordoption();
		tc67adduserpom.enterpassword(password);
		Thread.sleep(3000);
		tc67adduserpom.chooseprofile("Invitee");
		tc67adduserpom.adduserbtn();
		String expected = "The user has been added:" + " " + firstname + " " + lastname;
		String actual = tc69addusernegativepom.getalerttext();
		assertNotEquals(actual, expected);
		

		
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
