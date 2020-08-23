package gtplBank;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import gtplBankPages.LoginPageGuru;
import utilities.BaseTest;

public class LoginPageGuruTest extends BaseTest {
  @Test(priority=1)
  public void ManagerLoginTest() {
	  
	  openBrowser("firefox");
	  test.log(Status.INFO, "initializing firefox browser");
	  
	  driver.get("http://demo.guru99.com/V4/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  LoginPageGuru ml=new LoginPageGuru(driver);
	  ml.ManagerLogin();
	  
	String expmanageID = "Manger Id : mngr276570";
	  
	System.out.println("manager ID Is: "+ml.verifyManagerId());
	
	  Assert.assertEquals(ml.verifyManagerId(), expmanageID);
	    
 
  }
  
}
