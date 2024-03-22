package Major_Script;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import Auth_Script.LoginComponent;

public class DeleteAndUpdateMajor extends LoginComponent{
  @BeforeTest
  public void beforeClass() throws InterruptedException { 
	  login();
  }
  //Cập nhập ngành
  @Test (priority = 0)
  public void TC01_UpdateMajor()throws InterruptedException {
	  driver.findElement(By.linkText("Học kỳ và ngành")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Ngành")).click();
	  Thread.sleep(3000);
	  WebElement ButtonEdit = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[6]/a[1]"));
	  ButtonEdit.click();
	  Thread.sleep(1000);
	  WebElement listBoxFieldElement = driver.findElement(By.id("program_type"));
	  Thread.sleep(1000);
	  Select select = new Select(listBoxFieldElement);
	  select.selectByValue("0");
	  Thread.sleep(2000);
	  //Lưu
	  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[2]")).click();
	  Thread.sleep(1000);
	  //Mở lại form cập nhập ngành
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[6]/a[1]")).click();
	  Thread.sleep(1000);
	  //Hủy
	  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/button[1]")).click();
  }
  //Xóa ngành
  @Test (priority = 1)
  public void TC02_DeleteMajor()throws InterruptedException {
	//Press the Delete Button
	  WebElement ButtonDelete = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[6]/a[2]/i"));
	  ButtonDelete.click();
	  Thread.sleep(1500);
	  WebElement ButtonAccept = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
	  ButtonAccept.click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
  }
//Press the Cancel Button
  @Test (priority = 2)
  public void TC03_DeleteMajor()throws InterruptedException {
	  WebElement ButtonDele = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[6]/a[2]/i"));
	  ButtonDele.click();
	  Thread.sleep(1500);
	  WebElement ButtonCancel = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]"));
	  ButtonCancel.click();
	  Thread.sleep(1000);
  }
}
