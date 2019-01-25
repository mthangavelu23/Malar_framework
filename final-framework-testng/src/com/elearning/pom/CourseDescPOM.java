package com.elearning.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.utility.Driver;

public class CourseDescPOM {

	private WebDriver driver;

	public CourseDescPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "formLogin_submitAuth")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[@title='My courses']")
	private WebElement mycoursetab;
	
	
	@FindBy(xpath = "//img[@title='aelenium']")
	private WebElement coursetitlelnk;
	
	@FindBy(id = "tooldesc_8842")
	private WebElement coursedescicon;
	
	
	@FindBy(xpath = "//img[@title='Description']")
	private WebElement descicon;
	
	
	@FindBy(id = "course_description_title")
	private WebElement coursetitletxt;
		
	@FindBy(xpath = "//*[@id='cke_1_contents']//iframe")
	private WebElement coursedesctxt;
	
	@FindBy(xpath = "//button[@id='course_description_submit']")
	private WebElement savebutton;
	
	@FindBy(xpath = "//div[@class='alert alert-info']")
	private WebElement alerttxt;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
		
	}
	
	public void mycoursetab() {
		this.mycoursetab.click();
	}
	
	public void clickCoursetitle() {
		System.out.println("Clicked course title");
		this.coursetitlelnk.click();
	}

	public void clickcoursedescicon() {
		this.coursedescicon.click(); 
		
	}
	
	public void clickdescicon() {
		this.descicon.click(); 
		
	}
	
	
	public void sendtitle(String title) {
		this.coursetitletxt.clear();
		this.coursetitletxt.sendKeys(title);
	}
	
	
	public void senddesc(String valuetobody)
	{
		driver.switchTo().frame(coursedesctxt);
		WebElement body=driver.switchTo().activeElement();
		body.clear();
		body.sendKeys(valuetobody);
		driver.switchTo().defaultContent();
			
	}
	
	public void clicksavebutton() {
		this.savebutton.click(); 
		
	}
	
	public String handleAlert()
	{
		Alert alert = driver.switchTo().alert();
		String str1 = alert.getText();
		return str1;
	}
	
	public String getcoursetext()
	{
		String str1 = this.alerttxt.getText();
		System.out.println(str1);
		return str1;
		
	}
	
	}

	

	
	
