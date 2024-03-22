package Major_Script;

import java.util.concurrent.TimeUnit;
import Auth_Script.LoginComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class CreateMajor extends LoginComponent {
	
  @BeforeTest
  public void beforeClass() throws InterruptedException { 
	  login();
  }
  @Test (priority = 0)
  public void TC02_TaoNganh()throws InterruptedException {
	  driver.findElement(By.linkText("Học kỳ và ngành")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Ngành")).click();
	  Thread.sleep(3000);
	  //popupForm tạo ngành
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
	  //Điền thông tin ngành cần tạo
	  driver.findElement(By.id("id")).sendKeys("CNTTK27CNTT");
	  Thread.sleep(1000);
	  driver.findElement(By.id("name")).sendKeys("Công Nghệ Thông Tin - K27CNTT");
	  Thread.sleep(1000);
	  driver.findElement(By.id("abbreviation")).sendKeys("CNTTK27");
	  Thread.sleep(1000);
	  //driver.findElement(By.id("abbreviation")).sendKeys(Keys.TAB);
	  //Chọn dữ liệu trong listBox
	  //driver.findElement(By.id("select2-program_type-container")).click();  
	  Thread.sleep(1000);
	  WebElement listBoxFieldElement = driver.findElement(By.id("program_type"));
	  Thread.sleep(1000);
	  Select select = new Select(listBoxFieldElement);
	  select.selectByValue("0");
	  Thread.sleep(2000);
	  WebElement submitButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]"));
	  submitButton.click();
	  //driver.quit();
  }

}
  
  
  
