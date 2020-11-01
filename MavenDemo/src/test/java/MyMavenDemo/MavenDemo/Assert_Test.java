package MyMavenDemo.MavenDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseTest;

public class Assert_Test extends BaseTest{
  @Test
  public void AssertTest() {
	  
	  openBrowser("chrome");
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//String actLink = driver.findElement(By.linkText("Books")).getText();
	String actLink = driver.findElement(By.linkText("Mobiles")).getAttribute("innerHTML");
	String expLink = "Mobiles";
	
	System.out.println("actual link :" +actLink);
	System.out.println("expexted link :"+ expLink);
	
	//Assert.assertEquals(actLink, expLink);
	
	//Assert.assertTrue(actLink.equals(expLink), "both links are not equal");
	
	SoftAssert s=new SoftAssert();
	
	s.assertTrue(actLink.equals(expLink), "both links are  equal");
	//s.assertTrue(false, "err1");
	//s.assertTrue(true, "err2");
	//s.assertTrue(false, "err3");
	
	//s.assertAll();

	
	  
  }
}
