package QLPCGD;

import org.testng.annotations.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import Authentication.LoginComponent;

public class DeleteClass extends LoginComponent{
  @BeforeTest
  public void beforeTest() throws InterruptedException{
	login();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Thời khoá biểu")).click();
  }
  @Test
  public void deleteClass() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/ul/li[2]/a")).click();
	  WebElement termSelect = driver.findElement(By.xpath("//*[@id=\"term\"]"));
	  Select term = new Select(termSelect);
	  term.selectByValue("177");
	  Thread.sleep(1000);
	  
	  WebElement majorElement = driver.findElement(By.xpath("//*[@id=\"major\"]"));
	  Select major = new Select(majorElement);
	  major.selectByVisibleText("Công Nghệ Thông Tin 177");
	  Thread.sleep(1000);
	  
	  WebElement classElement = driver.findElement(By.xpath("//*[@id=\"275293\"]"));
	  classElement.click();
	  Thread.sleep(1000);
	  
//	  String nameClass = driver.findElement(By.xpath("//*[@id=\"popover829612\"]/h3/span")).getText();
	  WebElement deleteButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/button[2]"));	  
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
	  deleteButton.click();
	  for (int i=0; i<1; i++) {
		  if(!deleteButton.isEnabled()) {
			  classElement.click();
		  }
	  }
	  WebElement nameClassInput = driver.findElement(By.xpath("/html/body/div[4]/div/input[1]"));
	  nameClassInput.clear();
	  nameClassInput.sendKeys("221_71ITBS10103_04"); 
	  driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
  }
}
