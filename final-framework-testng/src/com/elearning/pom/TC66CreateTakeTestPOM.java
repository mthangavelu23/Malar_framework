package com.elearning.pom;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.utility.Driver;

public class TC66CreateTakeTestPOM {

	private WebDriver driver;

	public TC66CreateTakeTestPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create a new test']")
	private WebElement createnewtesticon;
	@FindBy(xpath = "//a[@title='1Selenium14']")
	private WebElement specificcourse;

	@FindBy(xpath = "//input[@name='exerciseTitle']")
	private WebElement entertesttitle;

	// @FindBy(xpath = "//button[@id='advanced_params']")
	// private WebElement advanceds;
	// @FindBy(xpath =
	// "//div[@id='cke_1_contents']//child::iframe[@class='cke_wysiwyg_frame
	// cke_reset']")
	// rivate WebElement inframetestcontext;

	@FindBy(xpath = "//input[@id='exerciseType_0']")
	private WebElement feedbackrb;

	// chk how to click on specific group member icon( handling href )
	@FindBy(xpath = "//input[@name='activate_start_date_check']")
	private WebElement enablesttimecb;

	@FindBy(xpath = "//img[@class='ui-datepicker-trigger']//preceding-sibling::input[@id='start_time']")
	private WebElement timeicon;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement timeselectmonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement timeselectyear;

	// select day - how to select uniquely for single digit
	@FindBy(xpath = "//td[@data-handler='selectDay']//a[@class='ui-state-default'][contains(text(),'19')]")
	private WebElement dayselect;

	@FindBy(xpath = "//input[@name='pass_percentage']")
	private WebElement passpercent;
	@FindBy(xpath = "//button[@name='submitExercise']")
	private WebElement proceedquestion;
	@FindBy(xpath = "//img[@title='Multiple choice']")
	private WebElement multiplechoiceicon;
	@FindBy(xpath = "//input[@name='questionName']")
	private WebElement questionname;
	// @FindBy(xpath =
	// "//div[@id='cke_2_contents']//child::iframe[@class='cke_wysiwyg_frame
	// cke_reset']")
	@FindBy(xpath = "//iframe[@aria-describedby='cke_111']")
	private WebElement qfirstchoice;

	// do second . thrid and fourth choice after wroking on first choice
	@FindBy(xpath = "//input[@class='checkbox'][@value='1']")
	private WebElement firstchoiceradio;
	@FindBy(xpath = "//button[@id='submit-question']")
	private WebElement addquestion;
	// 1 questions, for a total score (all questions) of 0(Expected)- alert info
	@FindBy(xpath = "//input[@class='checkbox'][@value='2']")
	private WebElement secondchoiceradio;

	@FindBy(xpath = "//img[@title='Preview']")
	private WebElement previewicon;

	@FindBy(xpath = "//a[@class='btn btn-success btn-large']")
	private WebElement Starttestbutton;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement Logouticon;
	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement Logoutlnk;

	@FindBy(xpath = "//a[contains(text(),'Course catalog')]")
	private WebElement coursecat;
	@FindBy(xpath = "//input[@name='search_term']")
	private WebElement searchcourse;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchbutton;
	@FindBy(xpath = "//select[@name='category_code']")
	private WebElement coursecategorylist;

	@FindBy(xpath = "//a[@title='Subscribe']")
	private WebElement coursesubscribe;
	@FindBy(xpath = "//a[@title='My courses']")
	private WebElement hmpgcourselnk;
	@FindBy(xpath = "//a[contains(text(),'1Selenium16')]")
	private WebElement mycourselink;
	@FindBy(xpath = "//a[contains(@href,'exerciseId=66')]")
	private WebElement testlink;

	@FindBy(xpath = "//div[@class='question_options']//child::input[@name='choice[73]']")
	private WebElement firstchoice;
	@FindBy(xpath = "//button[@name='save_now']")
	private WebElement nextquestion;
	@FindBy(xpath = "//input[@id='choice-74-2']")
	private WebElement secondchoice;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement returncoursehomepagebtn;

	@FindBy(xpath = "//img[@title='Results and feedback']//parent::a[contains(@href,'1Selenium16')]")
	private WebElement cresultsfeedback;

	@FindBy(xpath = "//img[@title='Grade activity']//parent::a[contains(@href,'1Selenium16')]")
	private WebElement cgradeactivity;

	public void createnewtest() {
		this.createnewtesticon.click();

	}

	public void testname(String test) {
		this.entertesttitle.clear();
		this.entertesttitle.sendKeys(test);
	}

	public void atendoftest() {

		this.feedbackrb.click();
	}

	public void enabletest() {
		this.enablesttimecb.click();
	}

	public void timeiconclk() {
		this.timeicon.click();
	}

//select time credentials
	public void selectmonth(String month) {
		// this.userlistbox.click();
		System.out.println("Selecting month");
		Select sel = new Select(this.timeselectmonth);
		sel.selectByVisibleText(month);

	}

	public void selectyear(String year) {
		// this.userlistbox.click();
		System.out.println("Selecting year");
		Select sel = new Select(this.timeselectyear);
		sel.selectByVisibleText(year);

	}

	public void passpercent(String passpercent) {
		this.passpercent.clear();
		this.passpercent.sendKeys(passpercent);
	}

	public void proceedquestions() {
		this.proceedquestion.click();

	}

	public void multiplechoiceiconclk() {
		this.multiplechoiceicon.click();

	}

	public void enterquestion(String question) {
		this.questionname.clear();
		this.questionname.sendKeys(question);
	}

//need to add all 3 choices question 
	public void setfocus(String valuetobody) {
		driver.switchTo().frame(qfirstchoice);
		WebElement body = driver.switchTo().activeElement();
		body.sendKeys(valuetobody);
		driver.switchTo().defaultContent();

	}

	public void firstchoicetxt(String firstchoice) {
		// this.se.clear();
		this.qfirstchoice.sendKeys(firstchoice);
	}

	// first option radio button
	public void firstchoicerbclk() {
		this.firstchoiceradio.click();

	}

	public void addquestionclk() {
		this.addquestion.click();

	}

	public void secondchoicerbclk() {
		this.secondchoiceradio.click();

	}

	public void previewclk() {
		this.previewicon.click();

	}

	public void coursecatclk() {
		this.coursecat.click();

	}

	public void logouticon() {
		this.Logouticon.click();

	}

	public void logoutlnk() {
		this.Logoutlnk.click();

	}

	public void searchcourse(String course) {
		this.searchcourse.clear();
		this.searchcourse.sendKeys(course);

	}

	public void searchclk() {
		this.searchbutton.click();
	}

	public void selectcoursecat(String coursecat) {
		// this.userlistbox.click();
		System.out.println("Selecting coursecat");
		Select sel = new Select(this.coursecategorylist);
		sel.selectByVisibleText(coursecat);

	}

	public void subscribecourse(String i) {
		this.coursesubscribe.click();
	}

	public void hmpgcourselink() {

		this.hmpgcourselnk.click();
	}

	public void mycourselink() {
		this.mycourselink.click();

	}

	public void specificcourseclk() {

		this.specificcourse.click();
	}

	public void testlnkclk() {

		this.testlink.click();
	}

	public void Starttestclk() {

		this.Starttestbutton.click();
	}

	public void answerchoiceclk() {
		this.firstchoice.click();
	}

	public void clicknextquestion() {
		this.nextquestion.click();

	}

	public void returnhmpgclk() {
		this.returncoursehomepagebtn.click();

	}

	public void resultsfeedbackclk() {
		this.cresultsfeedback.click();
	}

	public void gradeactivity() {
		this.cgradeactivity.click();

	}

	public void senddesc(String valuetobody) {
		// driver.switchTo().frame(coursedesctxt);
		WebElement body = driver.switchTo().activeElement();
		body.clear();
		body.sendKeys(valuetobody);
		driver.switchTo().defaultContent();

	}

}
