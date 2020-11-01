package MyMavenDemo.MavenDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseTest;

public class SwithFramesTest extends BaseTest {
  @Test
  public void SwitchFrameTest() 
  {
	  openBrowser("chrome");
	  
	  driver.get("https://www.selenium.dev/selenium/docs/api/java/");
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //to know how many frames 
	 List<WebElement> f = driver.findElements(By.tagName("frame"));
	 System.out.println(f.size());
	  
	  driver.switchTo().frame(0);
	  
	  driver.findElement(By.xpath("//li[5]//a[1]")).click();
	  
	  //we have to switch out the frame so that we can swith to other frame
	  driver.switchTo().defaultContent();
	  
	  driver.switchTo().frame(driver.findElement(By.name("packageFrame")));
	  
	  driver.findElement(By.xpath("//li[10]//a[1]//span[1]")).click();
	  
	  //swithing to other frame
	  driver.switchTo().defaultContent();
	  
	  driver.switchTo().frame(driver.findElement(By.name("classFrame")));
	  
	  driver.findElement(By.linkText("SearchContext")).click();
	  
	  
  }
}
