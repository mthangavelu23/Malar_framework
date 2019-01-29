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

		
	
	@FindBy(xpath = "//a[contains(text(),'Course catalog')]")
	private WebElement coursecat;
	
	@FindBy(name="search_term")
	//input[@name='search_term']
	private WebElement searchterm;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchbutton;
	
	@FindBy(xpath = "//a[contains(text(),'aelenium6')]")
	private WebElement coursedetails;
	
	
	
	public void clickoncoursecat() {
		System.out.println("Click on course");
		this.coursecat.click();
	}

	public void sendsearchtxt(String srchtxt) {
		System.out.println("Clicked user icon");
		this.searchterm.clear();
		this.searchterm.sendKeys(srchtxt);
	}
	
	public void clickonsearch() {
		System.out.println("Click on search");
		this.searchbutton.click();
	}
	
		
	public String getcoursetext()
	{
		String str1 = this.coursedetails.getText();
		System.out.println(str1);
		return str1;
		
	}
}
	
	
	
	
	
	
	
	
