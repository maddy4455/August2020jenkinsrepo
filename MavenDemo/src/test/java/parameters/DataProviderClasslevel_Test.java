package parameters;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseTest;

public class DataProviderClasslevel_Test extends BaseTest{
  @Test(dataProvider = "searchProvider", dataProviderClass=dataProviderClass.class)
  public void testMethod(String author, String searchkey) throws InterruptedException {
	  
	 openBrowser("edge");
	 driver.get("https://www.google.ca/");
	 
	WebElement searhBox = driver.findElement(By.name("q"));
	searhBox.sendKeys(searchkey);
	  System.out.println("Welcome author-->"+author+" your searchkey is-->"+searchkey);
	  Thread.sleep(3000);
	 String testValue = searhBox.getAttribute("value");
	 System.out.println(testValue+":::"+searchkey);
	 searhBox.clear();
	 assertTrue(testValue.equalsIgnoreCase(searchkey),"both values are equal");
	  
	  
  }
}
