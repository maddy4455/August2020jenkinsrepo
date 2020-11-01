package pageobjectmodel;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.BaseTest;

public class CustomerRegisterTest extends BaseTest {
  @Test
  public void RegistrationTest() throws Exception 
  {
	  openBrowser("chrome");
	  test.log(Status.INFO, "initializing chrome browser");
	  
		driver.get("http://automationpractice.com/index.php");
		test.log(Status.INFO, "Launching the website :- " + "http://automationpractice.com/index.php");
		
		CustomerRegistration c=new CustomerRegistration(driver);
		
		c.CustomerRegistrationPage();
		
		String actTitle = driver.getTitle();
		
		String expTitle = "My account - My Store";
		
		Assert.assertEquals(actTitle,expTitle );
		
		System.out.println("The actual page title is :- " + actTitle);
	  test.log(Status.PASS, "verified the page title :-" + actTitle);
	  
  }
}
