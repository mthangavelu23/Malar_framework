package com.elearning.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.utility.Driver;

public class TC38CreateGroupPOM {

	private WebDriver driver;

	public TC38CreateGroupPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//img[@id='toolimage_84']")
	private WebElement groupicon;
	
	@FindBy(xpath = "//img[@title='Create new group(s)']")
	private WebElement createnewgroup;
	
	@FindBy(xpath = "//input[@id='create_groups_number_of_groups']")
	private WebElement entergroupcount;
	
	@FindBy(xpath = "//button[@id='create_groups_submit']")
	private WebElement proceedgroup;
	
	
	//chk how to click on specific group member icon( handling href )
	@FindBy(xpath = "//img[@title='Group members']")
	private WebElement addgroupmember;
	
	@FindBy(xpath = "//button[@id='create_groups_step2_submit']")
	private WebElement creategroupsubmit;
	
	
	//need to see how to identify the correct row and then click on the add group member icon
	//@FindBy(xpath = "//tbody//tr[2]//td[5]//a[3]//img[1]")
	//private WebElement addgroupmembers;
	
	
	@FindBy(name="group_0_name")
	private WebElement groupnametxt;
	
//chk thi sxpath
	@FindBy(name = "group_members-f[]")
	private WebElement groupmembers;
	
	@FindBy(xpath = "//*[@name='add']")
	private WebElement addbutton;
	
	@FindBy(xpath = "//*[@name='remove']")
	private WebElement removebutton;
	
	@FindBy(xpath = "//*[@id='group_edit_submit']")
	private WebElement savesettings1;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement alertmsg;
	
	@FindBy(xpath = "//tr[@class='row_even']//img[@title='Edit this group']")
	private WebElement clkedit;
	
	@FindBy(xpath="//label[contains(text(),'Learners are allowed to self-register in groups')]")
	private WebElement chklearnerregister;
	
	@FindBy(xpath="//label[contains(text(),'Learners are allowed to unregister themselves from')]")
	private WebElement chklearnerunregister;
	
	public void clickgroupicon() {
		this.groupicon.click(); 
		
	}
		
	public void createnewgroup() {
		this.createnewgroup.click(); 
		
	}
	
	
	public void groupcount(String i) {
		this.entergroupcount.clear();
		this.entergroupcount.sendKeys(i);
	}
	
	public void proceedgroup() {
		this.proceedgroup.click(); 
		
	}

	public void entergrouptext(String grptxt) {
		this.groupnametxt.clear();
		this.groupnametxt.sendKeys(grptxt);
	}
	
	public void submitnewgroup() {
		this.creategroupsubmit.click();
		
	}
	
	public void clickaddgroupmember() {
		this.addgroupmember.click(); 
	}
	
	
	
	public void selectgroupmember(String groupmem)
	{
		this.groupmembers.click();
		Select sel = new Select(this.groupmembers);
		sel.selectByVisibleText(groupmem);
	}
	
	public void addmember() {
		System.out.println("Clicking on add member button");
		this.addbutton.click(); 
	}
	
	public void savesettings() {
		this.savesettings1.click(); 
	}
	
	public void senddesc(String valuetobody)
	{
		//driver.switchTo().frame(coursedesctxt);
		WebElement body=driver.switchTo().activeElement();
		body.clear();
		body.sendKeys(valuetobody);
		driver.switchTo().defaultContent();
			
	}
	
		
	public void clickediticon() {
		this.clkedit.click(); 
	}
	public void learnerregister() {
		this.chklearnerregister.click(); 
	}
	public void learnerunregsiter() {
		this.chklearnerunregister.click(); 
	}
	
	public String alerttext()
	{
		String str1 = this.alertmsg.getText();
		System.out.println(str1);
		return str1;
		
	}
	
	}

	

	
	
