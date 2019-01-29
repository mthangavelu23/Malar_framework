package com.elearning.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class roughPOM {
  @Test
  public void f() {
  }
}
public void clickonReport(String reportlist) {
	System.out.println("category is selecting");
	Select sel = new Select(this.reportlist);
	sel.selectByVisibleText(reportlist);
	
}

"//table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]"))

Actions actions = new Actions(driver);
WebElement mainMenu = driver.findElement(By.linkText("menulink"));
actions.moveToElement(mainMenu);

WebElement subMenu = driver.findElement(By.cssSelector("subLinklocator"));
actions.moveToElement(subMenu);
actions.click().build().perform();

public void validatemouse()
{
	Actions actions = new Actions(driver);
	WebElement validatedb = driver.findElements(validatedbutton);
	actions.moveToElement(validatedb);
	actions.click().build().perform();
	this.vaclick();
}