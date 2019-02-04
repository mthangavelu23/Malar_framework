package com.elearning.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.utility.Driver;

public class TC36ReportSendPOM {

	private WebDriver driver;

	public TC36ReportSendPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My courses']")
	private WebElement mycoursetab;
	
	@FindBy(xpath = "//a[contains(text(),'felenium7')]")
	private WebElement homepgcourselnk;
	
	@FindBy(xpath = "//a[@href='http://elearning.upskills.in/courses/FELE7/index.php']")
	private WebElement courselink;
	
	@FindBy(xpath = "//img[@title='Tests']")
	private WebElement testicon;
	
	@FindBy(xpath = "//td[contains(text(),'ASHWIN111')]")
	private WebElement selectstudentrow;
	
	@FindBy(xpath = "//img[@title='2rightarrow.png']")
	private WebElement rtarrowstudent;
	
	@FindBy(xpath = "//img[@title='felenium7test']//ancestor::td//following-sibling::td[@class='td_actions']//child::img[@alt='Results and feedback']")
	private WebElement resultfeedback;
	
	@FindBy(xpath = "//td[@title='Abishek']//following-sibling::td[@aria-describedby='results_actions']//child::img[@title='Grade activity']")
	private WebElement gradeactivity;
	
	public void testiconclk()
	{
		this.testicon.click();
	}
	
			
	public void resultfeedbackclk()
	{
		this.resultfeedback.click();
	}
	
	
		
	public void gradeact() throws InterruptedException
	
	{	Actions actions = new Actions(driver);
		//actions.moveToElement(this.gradeactivity).click().perform();
		actions.moveToElement(this.gradeactivity).doubleClick(this.gradeactivity).perform();
		Thread.sleep(2000);
		//actions.this.gradeactivity.click();
	}
	
	public void homepgcourseclk() {
		homepgcourselnk.click();
	}
	
	public void courseclk() {
		courselink.click();
	}
	

}
