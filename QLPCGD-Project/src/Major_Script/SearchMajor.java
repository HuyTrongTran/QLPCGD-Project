package Major_Script;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import Auth_Script.LoginComponent;

public class SearchMajor extends LoginComponent{ 

	@BeforeTest 

	 public void beforeClass() throws InterruptedException {  	  
		login();
	 } 

	//Search Course and edit the Course 

	@Test (priority = 0) 

	public void TC01_SearchMajor() throws InterruptedException { 

		driver.findElement(By.linkText("Học kỳ và ngành")).click(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		driver.findElement(By.linkText("Ngành")).click(); 
		 Thread.sleep(3000); 

	 //Điền tên ngành cần tìm 

	 driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]/input[1]")).sendKeys("111"); 
	 Thread.sleep(2000);
	 
	} 
}