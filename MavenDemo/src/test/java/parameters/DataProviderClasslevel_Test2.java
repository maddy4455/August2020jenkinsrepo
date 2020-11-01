package parameters;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import baseClass.BaseTest;
import baseClass.Utility;

public class DataProviderClasslevel_Test2 extends BaseTest {
	  @Test(dataProvider="SearchProvider", priority = 1)
	    public void testMethodA(String author,String searchKey) throws InterruptedException, IOException{
	        

		openBrowser("edge");
		driver.get("https://www.google.ca/");

		WebElement searhBox = driver.findElement(By.name("q"));
		searhBox.sendKeys(searchKey);
		test.log(Status.INFO, "Captured searbox with value",
				MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.getScreenshot(driver)).build());
		Thread.sleep(3000);
		System.out.println("Welcome author-->" + author + " your searchkey is-->" + searchKey);
		String testValue = searhBox.getAttribute("value");
		System.out.println(testValue + ":::" + searchKey);
		searhBox.clear();
		assertTrue(testValue.equalsIgnoreCase(searchKey), "both values are equal");

	}

	@Test(dataProvider = "SearchProvider", priority = 2)
	public void testMethodB(String searchKey) throws InterruptedException, IOException {
		{	
			openBrowser("edge");
			driver.get("https://www.google.ca/");
			WebElement searchText = driver.findElement(By.name("q"));
			// Search text in search box
			searchText.sendKeys(searchKey);
			test.log(Status.INFO, "Captured searbox with value",
					MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.getScreenshot(driver)).build());
			Thread.sleep(3000);
			// Print only search string
			System.out.println("Welcome ->Unknown user Your search key is->" + searchKey);
			String testValue = searchText.getAttribute("value");
			System.out.println(testValue + "::::" + searchKey);
			searchText.clear();
			// Verify if google text box is showing correct value
			assertTrue(testValue.equalsIgnoreCase(searchKey));
		}
	}
		 @DataProvider(name="SearchProvider")
		    public Object[][] getDataFromDataprovider(Method m){
		        if(m.getName().equalsIgnoreCase("testMethodA")){
		        return new Object[][] {
		                { "Guru99", "India" },
		                { "Krishna", "UK" },
		                { "Bhupesh", "USA" }
		            };}
		        else{
		        return new Object[][] {
		                { "Canada" },
		                { "Russia" },
		                { "Japan" }
		            };
		        }
	}
}
