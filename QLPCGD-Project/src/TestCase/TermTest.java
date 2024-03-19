package TestCase;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import Authentication.LoginComponent;

public class TermTest extends LoginComponent{
	
	String[] addTermValue = {"322", "2022", "2025", "2", "4", "4"};
	@BeforeTest
	  public void beforeTest() throws InterruptedException { 
		login();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Học kỳ và ngành")).click();
	  }
  @Test (priority = 0)
  public void sendValue() throws InterruptedException{
	  
	  driver.findElement(By.xpath("//*[@id=\"tblTerm_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
	  
	  
	  for (int i = 0; i < addTermValue.length; i += 6) {
	      WebElement term = driver.findElement(By.id("id"));
	      term.sendKeys(addTermValue[i]);
	      term.sendKeys(Keys.TAB);
	      
	      WebElement startYearElement = driver.findElement(By.xpath("//*[@id=\"start_year\"]"));
	      Select startYear = new Select(startYearElement);
	      startYear.selectByValue(addTermValue[i + 1]);
	      
	      WebElement endYearElement = driver.findElement(By.xpath("//*[@id=\"end_year\"]"));
	      Select endYear = new Select(endYearElement);
	      endYear.selectByValue(addTermValue[i + 2]);
	      
	      WebElement startWeek = driver.findElement(By.xpath("//*[@id=\"start_week\"]"));
	      startWeek.clear();
	      startWeek.sendKeys(addTermValue[i + 3]); 
	      
	       //Handling date selection if needed
	       WebElement selectStartDay = driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]"));
	       selectStartDay.click();
	       WebElement monthElement = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/select"));
	       monthElement.click();
	       Select daypickMonth = new Select(monthElement);
	       daypickMonth.selectByVisibleText("Tháng một");
	       
	       WebElement daypickYear = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div/input"));
	       daypickYear.clear();
	       daypickYear.click();
	       daypickYear.sendKeys(addTermValue[1]);
	       Thread.sleep(2000);
	       
	       driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[14]")).click();
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      WebElement maxLesson = driver.findElement(By.xpath("//*[@id=\"max_lesson\"]"));
	      maxLesson.clear();
	      maxLesson.sendKeys(addTermValue[i + 4]);
	      
	      WebElement maxClass = driver.findElement(By.xpath("//*[@id=\"max_class\"]"));
	      maxClass.clear();
	      maxClass.sendKeys(addTermValue[i + 5]);
	      
	      driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[7]/button[2]")).click();
	  }
  }
  @Test (priority = 1)
  public void EditTerm() throws InterruptedException{
	  WebElement findTermElement = driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input"));
	  findTermElement.sendKeys("322");
	  Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();
    String[] editValue = {"2023", "2026", "3", "6", "6"};
    
    for (int i = 0; i < editValue.length; i += 6) {
	      
	      WebElement startYearElement = driver.findElement(By.xpath("//*[@id=\"start_year\"]"));
	      Select startYear = new Select(startYearElement);
	      startYear.selectByValue(editValue[i]);
	      
	      WebElement endYearElement = driver.findElement(By.xpath("//*[@id=\"end_year\"]"));
	      Select endYear = new Select(endYearElement);
	      endYear.selectByValue(editValue[i + 1]);
	      
	      WebElement startWeek = driver.findElement(By.xpath("//*[@id=\"start_week\"]"));
	      startWeek.clear();
	      startWeek.sendKeys(editValue[i + 2]); 
	      
	       
	       WebElement selectStartDay = driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]"));
	       selectStartDay.click();
	       WebElement monthElement = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/select"));
	       monthElement.click();
	       Select daypickMonth = new Select(monthElement);
	       daypickMonth.selectByVisibleText("Tháng một");
	       
	       WebElement daypickYear = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/div/input"));
	       daypickYear.clear();
	       daypickYear.click();
	       daypickYear.sendKeys(editValue[0]);
	       Thread.sleep(1000);
	        
	       driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[2]/div/span[11]")).click();
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      WebElement maxLesson = driver.findElement(By.xpath("//*[@id=\"max_lesson\"]"));
	      maxLesson.clear();
	      maxLesson.sendKeys(editValue[i + 3]);
	      
	      WebElement maxClass = driver.findElement(By.xpath("//*[@id=\"max_class\"]"));
	      maxClass.clear();
	      maxClass.sendKeys(editValue[i + 4]);
	      
	      driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[7]/button[2]")).click();
	  }   
  }
  
  @Test (priority = 2)
  public void lockTerm() throws InterruptedException {
	  WebElement findTermElement = driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input"));
	  findTermElement.clear();
	  findTermElement.sendKeys(addTermValue[0]);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[8]/div/input")).click();
	  Thread.sleep(1000);
  }
  @Test (priority = 3)
  public void deleteTerm() throws InterruptedException{
	  WebElement findTermElement = driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input"));
	  findTermElement.clear();
	  findTermElement.sendKeys(addTermValue[0]);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[2]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.className("swal2-confirm")).click();
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
