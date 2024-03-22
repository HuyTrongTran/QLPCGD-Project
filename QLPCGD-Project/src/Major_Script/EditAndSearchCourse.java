package Major_Script;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import Auth_Script.LoginComponent;

public class EditAndSearchCourse extends LoginComponent{
	
	@BeforeTest
	  public void beforeClass() throws InterruptedException { 
		  login();  
	  }
	//Search Course and edit the Course
  @Test (priority = 0)
  public void TC01_SearchCourse() throws InterruptedException {
	  driver.findElement(By.linkText("Thù lao")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Môn học")).click();
	  Thread.sleep(2000);
	  //Điền tên môn học cần tìm
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div/div/label/input")).sendKeys("Nhập môn công nghệ");
	  Thread.sleep(2000);
	  //Chỉnh sửa môn học
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[6]/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/div/input[1]")).click();
	  Thread.sleep(2000);
	  WebElement SubmitButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/button[2]"));
	  SubmitButton.click();
  }
}
