package suiteA;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import baseClass.BaseTest;

public class TestA3 extends BaseTest {
  @Test 
  @Parameters("browser")
  public void sell_linkTest(String bType) throws InterruptedException {
  System.out.println("Starting TestA3");
  
  System.out.println("Starting TestA2");
  openBrowser(bType);
  test.log(Status.INFO, "Launching the Browser-->  " + bType);
  
   driver.get("https://www.amazon.in/");
   String url = driver.getCurrentUrl();
   test.log(Status.INFO, "navigating to Url-->  " + url);
	  
	 String actLink = driver.findElement(By.linkText("Sell")).getAttribute("innerHTML");
	 String expLink = "Sel";
	 
	 
	// SoftAssert s = new SoftAssert();
	 Assert.assertEquals(expLink, actLink, "Both links are not equal");
	 test.log(Status.FAIL, "both links are not equal-->"  + actLink);
	 
	  System.out.println("Ending TestA3");
	
  }
}
