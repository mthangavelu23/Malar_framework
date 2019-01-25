package com.elearning.pom;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.utility.Driver;

public class CoursesListPOM {

	private WebDriver driver;

	public CoursesListPOM(WebDriver driver) {
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
	//a[contains(text(),'sert')]
	
	@FindBy(xpath = "//a[contains(text(),'serrf')]")
	private WebElement coursetitlelnk;
	
	@FindBy(id = "toolimage_9141")
	private WebElement usericon;
	
	
	@FindBy(id = "form_student_list_id")
	private By userlist;
	
	
	//@FindBy(xpath = "//input[@value='103']")
	//private WebElement userid;
	
	//tr[@class='row_odd']//a[contains(@title,'Unsubscribe')][contains(text(),'Unsubscribe')]
	
	@FindBy(xpath = "//tr[@class='row_even row_selected']//a[contains(@title,'Unsubscribe')][contains(text(),'Unsubscribe')]")
	private WebElement unsubscribe;
	
	@FindBy(xpath = "//div[@class='alert alert-info']")
	private WebElement msg;
	
	
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
		System.out.println("Clicked on mycourse tab");
		this.mycoursetab.click();
	}
	
	public void clickoncourse() {
		System.out.println("Click on course");
		this.coursetitlelnk.click();
	}

	public void clickusericon() {
		System.out.println("Clicked user icon");
		this.usericon.click();
	}

	public void clickuserid() {
		  java.util.List<WebElement> ListOfCheckBoxes = driver.findElements(userlist);
		  System.out.println("Number of check boxes pesent are: "+ListOfCheckBoxes.size());
		  
		  for(int i=0; i< ListOfCheckBoxes.size() ; i++) {
		   if(ListOfCheckBoxes.get(i).getAttribute("value").equals("103"))
		    ListOfCheckBoxes.get(i).click();
		   }

		System.out.println("Clicked user id checkbox");
		//this.userlist.click();
	}
	public void unsubscribe() {
		System.out.println("Clicked unsubscribe");
		this.unsubscribe.click();
	}
	
	
	public void handleAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
			
	}
	
	
	public String getcoursetext()
	{
		String str1 = this.msg.getText();
		System.out.println(str1);
		return str1;
		
	}
}
	
	
	
	
	
	
	
	
