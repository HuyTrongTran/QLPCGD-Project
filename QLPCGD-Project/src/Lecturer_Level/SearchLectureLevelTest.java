package Lecturer_Level;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Auth_Script.LoginComponent;

public class SearchLectureLevelTest extends LoginComponent {
	@BeforeTest
	  public void beforeTest() throws InterruptedException { 
		login();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Thù lao")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Cấp bậc GV")).click();
		Thread.sleep(2000);
	  }
	
	//Tìm kiếm cấp bậc GV
  @Test
  public void SearchLectureLevelTC_01() throws InterruptedException{
	  int leftLimit = 97; // letter 'a'
      int rightLimit = 122; // letter 'z'
      int len = 1;
      Random random = new Random();
      StringBuilder buffer = new StringBuilder(len);
      for (int i = 0; i < len; i++) {
          int randomLimitedInt = leftLimit + (int)
                  (random.nextFloat() * (rightLimit - leftLimit + 1));
          buffer.append((char) randomLimitedInt);
      }
      String generatedString = buffer.toString();
	  WebElement LectureLevelInput = driver.findElement(By.xpath("//*[@id=\"tblLecturerRank_filter\"]/label/input"));
	  LectureLevelInput.sendKeys(generatedString);
  }
  
  @AfterTest
  public void afterClass() {
	  driver.close();;
  }
}
