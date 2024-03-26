package Timetable_Script;

import org.testng.annotations.Test;

import Auth_Script.LoginComponent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class ImportTimeTable extends LoginComponent{
  @BeforeTest
  public void beforeTest() throws InterruptedException{
	  login();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Thời khoá biểu")).click();
	  driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/ul/li[1]/a")).click();
	  
	  WebElement termSelect = driver.findElement(By.xpath("//*[@id=\"term\"]"));
	  Select term = new Select(termSelect);
	  term.selectByValue("177");	
	  Thread.sleep(1000);
	  
	  WebElement majorElement = driver.findElement(By.xpath("//*[@id=\"major\"]"));
	  Select major = new Select(majorElement);
	  major.selectByVisibleText("Công Nghệ Thông Tin 177");
	  Thread.sleep(1000);
  }
  @Test
  public void importTimeTable() throws InterruptedException{
	  // click mở localdisk
	  driver.findElement(By.xpath("//*[@id=\"dpz-single-file\"]")).click();
	  
	  String filePath = "C:\\Users\\tranh\\Downloads\\CNTT UIS-ThoiKhoaBieu_TieuChuan_Mau.xlsx";
	  // Khởi tạo robot path
	  Robot rb = null;
	  try {
	    rb = new Robot();
	  } catch (AWTException e) {
	    e.printStackTrace();
	  }
	// Copy File path vào Clipboard
	  StringSelection str = new StringSelection(filePath);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

	  Thread.sleep(1000);

	  // Nhấn Control+V để dán
	  rb.keyPress(KeyEvent.VK_CONTROL);
	  rb.keyPress(KeyEvent.VK_V);

	  // Xác nhận Control V trên
	  rb.keyRelease(KeyEvent.VK_CONTROL);
	  rb.keyRelease(KeyEvent.VK_V);

	  Thread.sleep(1000);
	  rb.keyPress(KeyEvent.VK_ENTER);
	  rb.keyRelease(KeyEvent.VK_ENTER);

	  Thread.sleep(4000);
	  
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[1]/div/div/div[2]/form/div[3]/button")).click();
	  Thread.sleep(2000);
	  
	  WebElement alreadyValue = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]")); 
	  
	  if(alreadyValue.isEnabled()) {
		 driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		 Thread.sleep(1000);
		 
		 WebElement conImpAlert = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));
		 if(conImpAlert.isEnabled()){
			 WebElement continueImportBtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
			 continueImportBtn.click();
//			 driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS); 
		 }
	  }
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[6]/button[1]")));
	  driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
  }
}
