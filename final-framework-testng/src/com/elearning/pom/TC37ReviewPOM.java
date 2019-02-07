package com.elearning.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath = "//img[@id='toolimage_95']")
	private WebElement reporticon;
	
	@FindBy(xpath = "//td[contains(text(),'mthangavelu789')]")
	private WebElement studentrow;
	
	
	//@FindBy(xpath = "//img[@title='2rightarrow.png']")
	@FindBy(xpath = "//img[@title='felenium7test']//ancestor::td//following-sibling::td[@class='hide']//child::img[@alt='2rightarrow.png']")
	private WebElement rtarrowicon;
	//a[@href='../mySpace/myStudents.php?student=17&details=true&course=FELE7&origin=tracking_course&id_session=0']//img[@title='2rightarrow.png']
	//img[@title='felenium7test']//ancestor::td//following-sibling::td[@class='td_actions']//child::img[@alt='2rightarrow.png']
	@FindBy(xpath = "//img[@title='quiz.png']")
	private WebElement quizicon;
	
	@FindBy(name = "send_notification")
	private WebElement sendEmailchkbox;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement correcttest;
	
	@FindBy(xpath = "//span[@class='label label-success']")
	private WebElement validatedbutton;
	
	//div[@class='alert alert-info']
	
	public void mycoursetab() {
		this.mycoursetab.click();
	}
	
	public void courselink()
	{
		this.courselink.click();
	}
	
	public void reporticonclk()
	{
		this.reporticon.click();
	}
	
	public void studentclk()
	{
		this.studentrow.click();
	}
	
	//a[@href='../mySpace/myStudents.php?student=17&details=true&course=FELE7&origin=tracking_course&id_session=0']//img[@title='2rightarrow.png']
	//a[@href='../mySpace/myStudents.php?student=21&details=true&course=FELE7&origin=tracking_course&id_session=0']//img[@title='2rightarrow.png']
	
	public void rtarrowclk()
	{
		this.rtarrowicon.click();
		Actions actions = new Actions(driver);
		System.out.println("Doing mouse over");
		//this.rtarrowicon.click();
		actions.moveToElement(this.rtarrowicon).click().perform();
		}
	
	public void quizoicon()
	{
		this.quizicon.click();
	}
	
	public void sendemailchkbox()
	{
		this.sendEmailchkbox.click();
	}
	
	public void correcttestclk()
	{
		this.correcttest.click();
	}
	
	
}


