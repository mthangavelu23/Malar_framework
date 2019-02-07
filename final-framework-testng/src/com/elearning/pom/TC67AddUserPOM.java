package com.elearning.pom;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.RenderingHints.Key;
import java.awt.Robot;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.utility.Driver;

public class TC67AddUserPOM {

	private WebDriver driver;

	public TC67AddUserPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Administration']")
	private WebElement admintab;

	@FindBy(xpath = "//a[contains(text(),'Add a user')]")
	private WebElement adduserlnk;

	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstnameinput;

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastnameinput;

	// chk how to click on specific group member icon( handling href )
	@FindBy(xpath = "//input[@id='email']")
	private WebElement useremail;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement userphonenumber;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement loginusername;
	//// div[@class='radio']//child::label//input[@name='password[password_auto]'][@id='qf_650f0d']
	@FindBy(xpath = "//label[contains(text(),'Enter password')]//preceding-sibling::input[@name='password[password_auto]']")
	private WebElement selectenterpassword;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement loginpassword;
	@FindBy(xpath = "//select[@id='status_select']")
	private WebElement selectprofile;
	@FindBy(xpath = "//button[@name='submit_plus']")
	private WebElement useraddplus;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement useradd;

	public void clickadmintab() {
		this.admintab.click();

	}

	public void adduserlink() {
		this.adduserlnk.click();
	}

	public void enterfirstname(String fname) {
		this.firstnameinput.sendKeys(fname);
	}

	public void enterlastname(String lname) {
		this.lastnameinput.sendKeys(lname);
	}

	public void enteremail(String email) {
		this.useremail.sendKeys(email);
	}

	public void enterphone(String phone) {
		this.userphonenumber.sendKeys(phone);
	}

	public void enterloginname(String login) {
		this.loginusername.sendKeys(login);
		this.loginusername.sendKeys(Keys.TAB);
	}

	public void selectpasswordoption() throws AWTException {

		this.selectenterpassword.click();

	}

	public void enterpassword(String pwd) {
		this.loginpassword.sendKeys(pwd);
		this.loginpassword.sendKeys(Keys.TAB);
	}

	public void chooseprofile(String profile) {
		Select sel = new Select(this.selectprofile);
		sel.selectByVisibleText(profile);

	}

	public void adduserbtn() {
		this.useradd.click();
	}

}
