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

public class TC40CreateProjectPOM {

	private WebDriver driver;

	public TC40CreateProjectPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@id='toolimage_94']")
	private WebElement projecticon;

	@FindBy(xpath = "//img[@title='Create a new project']")
	private WebElement createnewproject;

	@FindBy(xpath = "//input[@name='blog_name']")
	private WebElement addtitle;

	@FindBy(xpath = "//textarea[@name='blog_subtitle']")
	private WebElement addsubtitle;

	// chk how to click on specific group member icon( handling href )
	@FindBy(xpath = "//button[@id='add_blog_submit']")
	private WebElement saveblog;

	@FindBy(xpath = "//h3[@class='title-post']//child::a[contains(text(),'Welcome')]")
	private WebElement welcomenote;

	@FindBy(xpath = "//img[@title='Selenium3']")
	private WebElement projectlink;

	@FindBy(xpath = "//img[@title='New task']")
	private WebElement newtask;
	@FindBy(xpath = "//input[@name='title']")
	private WebElement newtasktitle;
	@FindBy(xpath = "//button[@id='add_post_save']")
	private WebElement newtasksave;
	@FindBy(xpath = "//img[@title='Roles management']")
	private WebElement rolemgmticon;
	@FindBy(xpath = "//img[@title='Add a new role']")
	private WebElement addnewrole;
	@FindBy(xpath = "//input[@name='task_name']")
	private WebElement newroletitle;
	@FindBy(xpath = "//button[@name='Submit']")
	private WebElement newrolesave;
	@FindBy(xpath = "//img[@title='Assign roles']")
	private WebElement assignroleicon;
	@FindBy(xpath = "//div[@class='dropdown-menu open']//following-sibling::select[@name='task_user_id']")
	private WebElement userlistbox;
	@FindBy(xpath = "//div[@class='bs-searchbox']//child::input[@xpath='1']")
	private WebElement userlistboxenter;
	
	@FindBy(xpath = "//div[@class='dropdown-menu open']//following-sibling::select[@name='task_task_id']")
	private WebElement tasklistbox;
	
	@FindBy(xpath = "//div[@class='bs-searchbox']//child::input[@xpath='1']")
	private WebElement tasklistboxenter;
	
	
	@FindBy(xpath = "//button[@id='assign_task_submit']")
	private WebElement validate;
	@FindBy(xpath = "//img[@title='Users rights management']")
	private WebElement userrightmgmticon;
	@FindBy(xpath = "//img[@title='Users management']")
	private WebElement usermgmticon;
	@FindBy(xpath = "//input[@value='21']")
	private WebElement userchkbox;
	@FindBy(xpath = "//a[contains(@class,'btn btn-primary')][contains(text(),'Register')][contains(@href,'21')]")
	private WebElement userregister;
	//tr[@class='row_odd']
	private Object newxpath;

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
