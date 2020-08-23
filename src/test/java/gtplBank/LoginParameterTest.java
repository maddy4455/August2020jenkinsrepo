package gtplBank;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import utilities.BaseTest;

public class LoginParameterTest extends BaseTest {

	@Test(dataProvider="guruloginData")
	public void ManagerLoginTest(String userId, String password)  {

		openBrowser("chrome");

		driver.get(baseguruUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(userId);
		String userIDdata = driver.findElement(By.name("uid")).getAttribute("value");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		String passWordData = driver.findElement(By.name("password")).getAttribute("value");
		driver.findElement(By.name("btnLogin")).click();
		
		
		 try{ 
			    
		       	Alert alt = driver.switchTo().alert();
				String actualBoxMsg = alt.getText(); // get content of the Alter Message
				alt.accept();
				
				String expBoxMsg = "User or Password is not valid";	
				assertEquals(actualBoxMsg,expBoxMsg);
				test.log(Status.INFO, "invalid credentials thrown failed message as: "+actualBoxMsg);
				test.log(Status.FAIL, "invalid credentials "+" id: "+userIDdata +" paswword: "+passWordData);
			}    
		    catch (NoAlertPresentException Ex){ 
		    	String actualTitle = driver.getTitle();
		    	String expTitle = "Guru99 Bank Manager HomePage";
		    	assertEquals(actualTitle,expTitle);
		    	test.log(Status.INFO, "login successfull: "+actualTitle);
		    	test.log(Status.PASS, "successfully entered into manager home page");
		    	test.log(Status.PASS, "valid credentials "+"id: "+ userIDdata +" paswword: "+passWordData);
	        } 
	}

	@DataProvider(name = "guruloginData")
	public Object[][] passData() {

		Object[][] data = new Object[4][2];

		// invalid UN&PW (In data first one is row and second one is coloumn)
		data[0][0] = "mngrjnbgk27657056";
		data[0][1] = "AtYdgtfjuagE";

		// invalid UN&Valid PW
		data[1][0] = "mngr78kkhy276570";
		data[1][1] = "AtYdagE";

		// valid UN& invalid PW
		data[2][0] = "mngr276570";
		data[2][1] = "AtYdagEgg45";

		// valid UN&valid PW
		data[3][0] = "mngr276570";
		data[3][1] = "AtYdagE";

		return data;

	}

}
