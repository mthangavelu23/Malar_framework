package com.elearning.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.utility.Driver;

public class TC39GenerateReportPOM {

	private WebDriver driver;

	public TC39GenerateReportPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

		@FindBy(xpath = "//a[@title='Reporting']")
	private WebElement reporttab;
		
		//a[contains(text(),'Followed students')]
	
	@FindBy(xpath = "//a[contains(text(),'Followed students')]")
	private WebElement followedstudents;
	
	@FindBy(xpath = "//div[@class='col-sm-8']//input[@name='keyword']")
	private WebElement enterkeyword;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement searchsubmit;
	
	@FindBy(xpath = "//td[contains(text(),'karthi')]")
	private WebElement selectstudentrow;
	
	
	@FindBy(xpath = "//img[@title='2rightarrow.png']")
	private WebElement rtarrowstudent;
	
	//need to improve xpath here
	@FindBy(xpath = "//img[@title='Details']")
	private WebElement rtarrowdetailscourse;
	
	@FindBy(xpath = "//td[contains(text(),'felenium7test')]")
	private WebElement testrow;
	
	@FindBy(xpath = "//img[@title='quiz.png']")
	private WebElement quizpng;
	
	public void reporttabclk()
	{
		this.reporttab.click();
	}
	
	public void followedstudentclk()
	{
		this.followedstudents.click();
	}
	public void enterkeyword(String keyword)
	{
		this.enterkeyword.clear();
		this.enterkeyword.sendKeys(keyword);
	}
	public void searchsubmitclk()
	{
		this.searchsubmit.click();
	}
	
	public void selectstudentrowclk()
	{
		this.selectstudentrow.click();
	}
	
	public void rtarrowclkstudent()
	{
		Actions actions = new Actions(driver);
		//WebElement mainMenu = driver.findElement(By.linkText("menulink"));
		System.out.println("Doing mouse over");
		//this.rtarrowstudent.click();
		actions.moveToElement(this.rtarrowstudent).click().perform();
		}
	public void selecttestrowclk()
	{
		this.testrow.click();
	}
		
	public void rtarrowclkdetails() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		//WebElement mainMenu = driver.findElement(By.linkText("menulink"));
		System.out.println("Doing mouse over on rt arrow of test");
		//this.rtarrowstudent.click();
		actions.moveToElement(this.rtarrowdetailscourse).click().build().perform();
		}
	
	public void quiziconclk()
	{	Actions actions = new Actions(driver);
		System.out.println("Clciking on Quiz icon");
		//this.quizpng.click();
		actions.moveToElement(this.quizpng).click().perform();
	}
	
	

}
