package suiteA;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.BaseTest;
import junit.framework.Assert;

public class TestA2 extends BaseTest{
  @Test 
  @Parameters("browser")
  public void VerifyTitle(String bType) throws InterruptedException {
	  
  System.out.println("Starting TestA2");
  openBrowser(bType);
  test.log(Status.INFO, "Launching The Browser-->" + bType);
  
   driver.get("https://www.amazon.in/");
   String url = driver.getCurrentUrl();
   test.log(Status.INFO, "navigating to Url-->  " + url);
   //String pageTitle = driver.getTitle();
   String actTitle = driver.getTitle();
   String expTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
   
   Assert.assertTrue(actTitle.equals(expTitle));
   test.log(Status.PASS, "verified actual page title-->"  + actTitle);
	  
	 // System.out.println(pageTitle);
	 System.out.println("ending testA2");
	  
  }
}
