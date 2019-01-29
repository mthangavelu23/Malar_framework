package com.elearning.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.utility.Driver;

public class TC37ReviewPOM {

	private WebDriver driver;

	public TC37ReviewPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My courses']")
	private WebElement mycoursetab;
	
	@FindBy(xpath = "//a[contains(text(),'felenium7')]")
	private WebElement courselink;
	
	@FindBy(xpath = "//img[@title='Tests']")
	private WebElement testicon;
	
	@FindBy(xpath = "//img[@title='Results and feedback']")
	private WebElement resultfeedback;
	
	@FindBy(xpath = "//a[@href='exercise_show.php?cidReq=FELE7&id_session=0&gidReq=0&gradebook=0&origin=&action=qualify&id=2']//img[@title='Grade activity']")
	private WebElement gradeactivity;
	
	@FindBy(xpath = "//tr[@id='2']//span[@class='label label-success'][contains(text(),'Validated')]")
	private WebElement validated;
	
	public void testiconclk()
	{
		this.testicon.click();
	}
	
	public void resultfeedbackclk()
	{
		this.resultfeedback.click();
	}
	
	public void gradeact()
	{
		this.gradeactivity.click();
	}
	
	public String mouseovertxt()
	{
	
		Actions actions = new Actions(driver);
		System.out.println("Doing mouse over");
		Actions status = actions.moveToElement(this.validated).;//how to get inner text of mouse over element	
		String str1 = status.toString();
		return str1;
		}

}
