package Timetable_Script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Auth_Script.LoginComponent;

public class AssignInstructors extends LoginComponent{

	@BeforeTest 

	 public void beforeClass() throws InterruptedException {  
		login();
	 } 

	@Test (priority = 0) 

	public void TC01_phancong() throws InterruptedException { 

		driver.findElement(By.linkText("Thời khoá biểu")).click(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		driver.findElement(By.linkText("Phân công")).click();
		Thread.sleep(2000); 
		// chọn vào ô trống để phân công giảng viên
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/button[1]")).click();
		Thread.sleep(2000);
		// chọn vào ô tìm kiếm giảng viên
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]/span[1]")).click();
		Thread.sleep(2000);
		// điền tên gv cần phân công
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/span[2]/span[1]/span[1]/input[1]")).sendKeys("Kiet");
		Thread.sleep(2000);
		// submit 
		WebElement SubmitButton = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/button[1]/i[1]")); 
		 SubmitButton.click();
	}
}

