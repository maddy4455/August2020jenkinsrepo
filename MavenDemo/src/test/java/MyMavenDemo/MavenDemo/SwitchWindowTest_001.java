package MyMavenDemo.MavenDemo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseClass.BaseTest;

public class SwitchWindowTest_001 extends BaseTest{
	
  @Test
  public void SwithWinTest() 
  {
	  openBrowser("chrome");
	  driver.get("https://www.hdfc.com/");
	  
	 System.out.println( driver.getTitle());
	 
	 String parentWindow = driver.getWindowHandle();
	 System.out.println("Parent Window ID :-"+ parentWindow);
	 
	 driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[18]/div[1]/div[1]/div[1]/button[1]")).click();
	  
	  driver.findElement(By.linkText("Apply For Home Loan")).click();
	  
	 Set<String> multiWindows = driver.getWindowHandles();
	 
	Iterator<String> itr = multiWindows.iterator();
	while(itr.hasNext())
	{
		String currentWindow = itr.next();
		System.out.println("Window Id is :"+ currentWindow);
		if(!currentWindow.equals(parentWindow))
		{
			driver.switchTo().window(currentWindow);
		}
	}
	String childWindowTitle = driver.getTitle();
	System.out.println("childwindow title is :"+ childWindowTitle);
	
	driver.close();
	
	// swithing back to parent window
	driver.switchTo().window(parentWindow);
	
	System.out.println("Parent window title is :- "+ driver.getTitle());
	
  }
}
