package com.elearning.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.utility.Driver;

public class AddCoursePOM {

	private WebDriver driver;

	public AddCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "formLogin_submitAuth")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Create a course')]")
	private WebElement courselink;

	@FindBy(xpath = "//input[@id='title']")
	private WebElement course;

	@FindBy(id = "advanced_params")
	private WebElement advanceds;

	
	@FindBy(xpath ="//*[@title='()']")
	private WebElement category;
	

	@FindBy(id ="add_course_category_code")
	WebElement coursecategory;
	
	@FindBy(xpath = "//input[@id='add_course_wanted_code']")
	private WebElement coursecode;

	@FindBy(id ="add_course_course_language" )
	private WebElement language;
	

	@FindBy(xpath = "//button[@id='add_course_submit']")
	private WebElement coursesubmit;
	
	@FindBy(xpath = "//p[contains(text(),'this is an selenium course')]")
	private WebElement coursepgcontent;
	
	

	@FindBy(xpath = "//div[@class='btn-group pull-right']//a[@title='Add an introduction text']")
	private WebElement introtextbutton;

	@FindBy(xpath = "//*[@id='cke_1_contents']//iframe")
	private WebElement introcontenttxt;

	@FindBy(xpath = "//button[@id='introduction_text_intro_cmdUpdate']")
	private WebElement saveintrobutton;

	
	@FindBy(xpath = "//div[contains(text(),'Intro was updated')]")
	private WebElement introupdated;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickCourselink() {
		this.courselink.click();
	}

	public void sendcourse(String course) {
		this.course.clear();
		this.course.sendKeys(course);
	}

	public void advanceds() {
		System.out.println("advance button is clicked");
		this.advanceds.click();
	}

	public void sendcategory() {
		
		this.category.click();
		System.out.println("category is clicked");

	}

	public void sendcoursecategory(String categorylist) {
		System.out.println("category is selecting");
		Select sel = new Select(this.coursecategory);
		sel.selectByVisibleText(categorylist);
		
	}
	
	public void sendcoursecode(String coursecode) {
		// this.coursecode.clear();
		this.coursecode.sendKeys(coursecode);
	}

	public void sendlanguage(String language1) {
		System.out.println("Selecting language");
		Select sel1 = new Select(this.language);
		sel1.selectByVisibleText(language1);
		
		//this.language.sendKeys(language1);
	}

	public void clickcoursesubmit() {
		this.coursesubmit.click();
	}
	
	
	public void setfocus(String valuetobody)
	{
		driver.switchTo().frame(introcontenttxt);
		WebElement body=driver.switchTo().activeElement();
		body.sendKeys(valuetobody);
		driver.switchTo().defaultContent();
		
		
	}
	
	public void sendframetext(String introcontenttxt)
	{
		this.introcontenttxt.click();
		this.introcontenttxt.sendKeys(introcontenttxt);
	}
	
	public String getcoursepagecontent()
	{
		String str1 = this.coursepgcontent.getText();
		System.out.println(str1);
		return str1;
	}
	
	public void isexists()
	{
		Boolean b = this.introupdated.isDisplayed();
	}
	
	public void clickAddIntrotext()	{
		this.introtextbutton.click();
	}

	public void introcontenttext(String introcontenttext)
	{
		//driver.switchTo(
		this.introcontenttxt.sendKeys(introcontenttext);
	}
	
	public void clicksaveintro()
		{
		this.saveintrobutton.click();
	}
	public String getcoursetext()
	{
		String str1 = this.coursepgcontent.getText();
		System.out.println(str1);
		return str1;
		
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
		// TODO Auto-generated method stub
		
	}
}
