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

	@FindBy(xpath = "//input[@name='exerciseTitle']")
	private WebElement entertesttitle;

	@FindBy(xpath = "//button[@id='advanced_params']")
	private WebElement advanceds;
	@FindBy(xpath = "//div[@id='cke_1_contents']//child::iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement inframetestcontext;

	
	@FindBy(xpath = "//input[@id='exerciseType_0']")
	private WebElement feedbackrb;

	// chk how to click on specific group member icon( handling href )
	@FindBy(xpath = "//input[@id='qf_048dda']")
	private WebElement enablesttimecb;

	@FindBy(xpath = "//img[@class='ui-datepicker-trigger']//preceding-sibling::input[@id='start_time']")
	private WebElement timeicon;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement timeselectmonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement timeselectyear;
	
	//select day - how to select uniquely for single digit
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
	@FindBy(xpath = "//div[@id='cke_2_contents']//child::iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement qfirstchoice;
	//do second . thrid and fourth choice after wroking on first choice
	@FindBy(xpath = "//input[@id='qf_8d9eff']")
	private WebElement firstchoiceradio;
	@FindBy(xpath = "//button[@id='submit-question']")
	private WebElement addquestion;
	//1 questions, for a total score (all questions) of 0(Expected)- alert info
	@FindBy(xpath = "//input[@id='qf_c1024e']")
	private WebElement secondchoiceradio;
	
	@FindBy(xpath = "//img[@title='Preview']")
	private WebElement previewicon;
	

	@FindBy(xpath = "//a[@class='btn btn-success btn-large']")
	private WebElement Starttestbutton;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement Logouticon;
	
	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement Logoutbutton;
	
	
	public void clickprojecticon() {
		this.projecticon.click();

	}

	public void createnewproject() {
		this.createnewproject.click();

	}

	public void addtitleblog(String i) {
		this.addtitle.clear();
		this.addtitle.sendKeys(i);
	}

	public void addsubtitleblog(String i) {
		this.addsubtitle.sendKeys(Keys.TAB);
		//this.addsubtitle.clear();
		this.addsubtitle.sendKeys(i);
	}

	public void saveblog() {
		this.saveblog.click();

	}

	public void projectlnkclik1(String projectnametxt) {
		String firstxpath = "//a[contains(text(),'";
		String lastxpath = "')]";
		String actualxpath = firstxpath + projectnametxt + lastxpath;
		String actualxpath1 = actualxpath.toString();
		System.out.println(actualxpath1);
		WebElement newxpath = driver.findElement(By.linkText(actualxpath1));
		this.projectlink.click();
		//((WebElement) this.newxpath).click();
	}
	
	public void projectlnkclik() {
		this.projectlink.click();
		
	}


	public void newtask() {
		this.newtask.click();
	}

	public void addnewtasktitle(String i) {
		this.newtasktitle.clear();
		this.newtasktitle.sendKeys(i);
	}

	public void savenewtasktitle() {
		this.newtasksave.click();

	}

	public void rolemgmticon() {
		this.rolemgmticon.click();

	}

	public void addnewrole() {

		this.addnewrole.click();
	}

	public void enternewrole(String i) {
		this.newroletitle.clear();
		this.newroletitle.sendKeys(i);
	}

	public void savenewrole() {

		this.newrolesave.click();
	}

	public void assignroleicon() {
		this.assignroleicon.click();
	}

	public void selectuser(String usermem) {
		//this.userlistbox.click();
		System.out.println("Selecting value user");
		Select sel = new Select(this.userlistbox);
		sel.selectByVisibleText(usermem);
		//this.userlistbox.sendKeys(Keys.TAB);
		
	}
	public void enteruser(String usermem) {
		this.userlistboxenter.sendKeys(usermem);
		this.userlistboxenter.sendKeys(Keys.ENTER);
		
	}
	
	public void entertask(String taskname) {
		this.tasklistboxenter.sendKeys(taskname);
		this.tasklistboxenter.sendKeys(Keys.ENTER);
		
	}
		
	public void selecttask(String task) {
		System.out.println("Selecting task");
		System.out.println("Selecting value user");
		Select sel = new Select(this.tasklistbox);
		sel.selectByVisibleText(task);
		//this.tasklistbox.click();
		//Select sel = new Select(this.tasklistbox);
		//sel.selectByVisibleText(task);

	}

	public void validateduserrole() {
		this.validate.click();
	}

	public void usermgmticon() {
		this.usermgmticon.click();

	}

	public void userchkbox() {
		this.userchkbox.click();

	}

	public void clkregister() {
		this.userregister.click();

	}

	public void senddesc(String valuetobody) {
		// driver.switchTo().frame(coursedesctxt);
		WebElement body = driver.switchTo().activeElement();
		body.clear();
		body.sendKeys(valuetobody);
		driver.switchTo().defaultContent();

	}

}
