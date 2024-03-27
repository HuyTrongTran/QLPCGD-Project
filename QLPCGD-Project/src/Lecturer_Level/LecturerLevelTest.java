package Lecturer_Level;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Auth_Script.LoginComponent;

public class LecturerLevelTest extends LoginComponent {
	@BeforeTest
	  public void beforeTest() throws InterruptedException { 
		login();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Thù lao")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Cấp bậc GV")).click();
	  }
	
	//View list Of LectureLevel
  @Test
  public void ViewList_LectureLevel () throws InterruptedException {
	//Xem danh sách ngành theo danh sách hiển thị (10,25,50,tất cả)
	  WebElement listBoxFieldElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/label/select"));
	  Thread.sleep(1000);
	  Select select = new Select(listBoxFieldElement);
	  //kéo trang xuống
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0, 400)", "");
	  Thread.sleep(3000);
	  select.selectByIndex(0);
	  Thread.sleep(2000);
	  select.selectByIndex(1);
	  Thread.sleep(2000);
	  select.selectByIndex(2);
	  Thread.sleep(2000);
	  select.selectByIndex(3);
	  Thread.sleep(1000);
	  js.executeScript("window.scrollBy(0, 2000)", "");
	  Thread.sleep(2000);
	  js.executeScript("window.scrollBy(0, 2000)", "");
	  Thread.sleep(2000);
	  js.executeScript("window.scrollBy(0, 2000)", "");
	  Thread.sleep(2000);
	  
	  //bấm nút quay lại đầu trang
	  WebElement PullUpButton = driver.findElement(By.xpath("/html/body/div[2]/button"));
	  PullUpButton.click();
	  Thread.sleep(2000);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
}
