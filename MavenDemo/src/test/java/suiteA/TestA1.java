package suiteA;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.BaseTest;


public class TestA1 extends BaseTest{
  @Test 
  @Parameters("browser")
  public void Pantry_linkTest(String bType) throws InterruptedException {
	  
	  System.out.println("Starting TestA1");
	  
	  openBrowser(bType);
	  test.log(Status.INFO, "Launching Browser---> " + bType);
	  
	   driver.get("https://www.amazon.in/");
	   String url = driver.getCurrentUrl();
	   test.log(Status.INFO, "navigating to Url-->  " + url);
	   
	  String actLink = driver.findElement(By.linkText("Pantry")).getAttribute("innerHTML");
	         
	   String expLink = "Pantry";
	   
	   Assert.assertEquals(expLink,actLink, "Both links are equal");
	   test.log(Status.PASS, "Both links are equal as test paased-->" + actLink);
	  System.out.println("Ending TestA1");
	  
	  
	  
  }
}
