package Major_Script;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import Auth_Script.LoginComponent;

public class ViewListOfMajor extends LoginComponent{
	
  @BeforeTest
  public void beforeClass() throws InterruptedException { 
	  login();
  }
  @Test
  public void TC01_ViewOfList()throws InterruptedException {
	  driver.findElement(By.linkText("Học kỳ và ngành")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Ngành")).click();
	  Thread.sleep(3000);
	  //Xem danh sách ngành theo danh sách hiển thị (10,25,50,tất cả)
	  WebElement listBoxFieldElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[1]/div/label/select"));
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
	  Thread.sleep(3000);
  }
}
