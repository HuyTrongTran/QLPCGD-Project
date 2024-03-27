package Lecturer_Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Auth_Script.LoginComponent;


public class EditLectureLevelTest extends LoginComponent {
	
	@BeforeTest
	  public void beforeTest() throws InterruptedException { 
		login();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Thù lao")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Cấp bậc GV")).click();
		Thread.sleep(2000);
	  }
	
	//cập nhập tất cả cấp bậc GV theo 1 cấp bậc bất kỳ
//  @Test (priority = 0)
//  public void EditLectureLevel() throws InterruptedException {
//	  WebElement EditFullLevelButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/button"));
//	  EditFullLevelButton.click();
//	  Thread.sleep(2000);
//	  WebElement listBoxFieldElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/div/select"));
//	  Thread.sleep(2000);
//	  Select select = new Select(listBoxFieldElement);
//	  //lựa chọn 1 cấp bậc bất kỳ
//	  Random rand = new Random();
//	  int rand_int1 = rand.nextInt(5);
//	  select.selectByIndex(rand_int1);
//	  //Click submit button
//	  WebElement SubmitButton = driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/button[2]"));
//	  SubmitButton.click();
//	  Thread.sleep(2000);
//  }
  
	//Cập nhập tất cả cấp bậc GV theo tìm kiếm 
  @Test (priority = 1)
  public void EditLectureLevel_2 () throws InterruptedException {
	  WebElement EditFullLevelButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/button"));
	  EditFullLevelButton.click();
	  Thread.sleep(2000);
	  WebElement listBoxFieldElement = driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-container\"]"));
	  Thread.sleep(2000);
	  listBoxFieldElement.click();
	  //Tìm một cấp bậc bất kì
	  driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[2]/div/span[2]/span/span[1]/input")).sendKeys("J");
	  Thread.sleep(1800);
	  driver.findElement(By.xpath("//*[@id=\"select2-academic_degree_rank_id-results\"]")).click();
	  Thread.sleep(2000);
	//Click submit button
	  WebElement SubmitButton = driver.findElement(By.xpath("//*[@id=\"lecturerrank-form\"]/div[3]/button[2]"));
	  SubmitButton.click();
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();;
  }
}
