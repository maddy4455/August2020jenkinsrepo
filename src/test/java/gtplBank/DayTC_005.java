package gtplBank;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class DayTC_005 extends BaseTest{
  @Test(dataProvider =  "guruloginData")
  public void TC_005(String username, String password) {
	  String actualBoxMsg;
	  
	  openBrowser("chrome");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(baseguruUrl);
		
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.name("btnLogin")).click();

		 try{ 
			    
		       	Alert alt = driver.switchTo().alert();
				actualBoxMsg = alt.getText();
				alt.accept();
									
				assertEquals(actualBoxMsg,guruUtil.EXPECT_ERROR);
				
			}    
		    catch (NoAlertPresentException Ex){ 
		    	 
				String pageText = driver.findElement(By.tagName("tbody")).getText();

				// Extract the dynamic text mngrXXXX on page		
				String[] parts = pageText.split(guruUtil.PATTERN);
				String dynamicText = parts[1];

				// Check that the dynamic text is of pattern mngrXXXX
				// First 4 characters must be "mngr"
				assertTrue(dynamicText.substring(1, 5).equals(guruUtil.FIRST_PATTERN));
				// remain stores the "XXXX" in pattern mngrXXXX
				String remain = dynamicText.substring(dynamicText.length() - 4);
				// Check remain string must be numbers;
				assertTrue(remain.matches(guruUtil.SECOND_PATTERN));
	        } 
  }

	@DataProvider(name = "guruloginData")
	public Object[][] passData() {

		Object[][] data = new Object[4][2];

		data[0][0] = guruUtil.USER_NAME;
		data[0][1] = guruUtil.PASSWD;
		//2nd row
		data[1][0] = "invalid";
		data[1][1] = "valid";
		//3rd row
		data[2][0] = "valid";
		data[2][1] = "invalid";
		//4th row
		data[3][0] = "invalid";
		data[3][1] = "invalid";

		return data;

	}


  }

