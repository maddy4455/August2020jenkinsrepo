package gtplBank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class NewCustomerTest extends BaseTest{
  @Test
  public void NewCustomerRegistartion() {
	  
	  String month = "june 1995";
	  
	  openBrowser("chrome");
	  
	  driver.get(newcusUrl);
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
	  
	  driver.findElement(By.xpath("//input[@name='name']")).sendKeys("maddy");
	  driver.findElement(By.name("rad1")).click();
	  driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("05/05/1995");
	  driver.findElement(By.name("addr")).sendKeys("Summerside");
	  driver.findElement(By.name("city")).sendKeys("newyork");
	  driver.findElement(By.name("state")).sendKeys("NewYork");
	  driver.findElement(By.name("pinno")).sendKeys("100034");
	  driver.findElement(By.name("telephoneno")).sendKeys("234567890");
	  driver.findElement(By.name("emailid")).sendKeys("qa12345@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("qa45678");
	  driver.findElement(By.name("sub")).click();
	  
	 System.out.println(driver.getTitle());
	  
	  
	  
	  
	  
	  
	  
  }
}
