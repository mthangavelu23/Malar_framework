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

public class UnsubscribePOM {

	private WebDriver driver;

	public UnsubscribePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My courses']")
	private WebElement mycoursetab;
	//a[contains(text(),'sert')]
	
	@FindBy(xpath = "//a[contains(text(),'serrf')]")
	private WebElement coursetitlelnk;
	
	@FindBy(id = "toolimage_9141")
	private WebElement usericon;
	
	
	@FindBy(xpath="//*[@name='user[]']")
	private WebElement userlist;
	//private List<WebElement> getElementsAsList("//*[@name='user[]']", String type);
	
	@FindBy(xpath = "//input[@value='103']")
	private WebElement userid;
	
	//tr[@class='row_odd']//a[contains(@title,'Unsubscribe')][contains(text(),'Unsubscribe')]
	
	@FindBy(xpath = "//tr[@class='row_even row_selected']//a[contains(@title,'Unsubscribe')][contains(text(),'Unsubscribe')]")
	private WebElement unsubscribe;
	
	@FindBy(xpath = "//div[@class='alert alert-info']")
	private WebElement msg;
	
	
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
		System.out.println("unscubscribe user is in progress");
		this.userid.click();
		
		
		  //List<WebElement> checkboxes[] = driver.findElements(userlist);
		  
		  //System.out.println(checkboxes.size());
		  
		  //for(int i=0; i<= checkboxes.size() ; i++) {
		   //if(checkboxes.get(i).getAttribute("value").equals("103"))
			//   checkboxes.get(i).click();
		  // }

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
	
	
	
	
	
	
	
	
