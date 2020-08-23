package gtplBank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseTest;



public class gettextTest extends BaseTest{
  @Test
  public void f() {
	  
	  openBrowser("chrome");
	  driver.get("https://www.google.co.in/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@name='q']")).sendKeys("rajnikanth");
	 String textData = driver.findElement(By.xpath("//input[@name='q']")).getAttribute("value");
	  System.out.println(textData);
	  
	  driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).sendKeys(Keys.ENTER);
	 String actpageTitle = driver.getTitle();
	// String expPageTitle = "Raj";
	 System.out.println("page Title is: "+actpageTitle);
	 
	 Assert.assertTrue(actpageTitle.contains("raj"), "saerch box is working");
  }
}
