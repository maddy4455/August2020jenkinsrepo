package gtplBank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utilities.BaseTest;

public class ss1_Test extends BaseTest {
	@Test
	public void VerifyLogin_fireefox() {

		openBrowser("firefox");
		test.log(Status.INFO, "Launching firefox browser");

		driver.get(baseguruUrl);
		test.log(Status.INFO, "Navigating Url: "+baseguruUrl);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr276570");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("AtYdagE");

		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
	 String actManagerID = driver.findElement(By.xpath("//td[contains(text(),'Manger Id : mngr276570')]")).getAttribute("innerHTML");

		String expManagerId = "Manger Id : mngr276570";

		Assert.assertEquals(actManagerID, expManagerId);
		test.log(Status.PASS, "verified manager id in login page: "+actManagerID);

		
	}
	
	@Test
	public void VerifyLogin_chrome() {
		
		openBrowser("chrome");
		test.log(Status.INFO, "Launching chrome browser");
		
		driver.get(baseguruUrl);
		test.log(Status.INFO, "Navigating Url: "+baseguruUrl);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr276570");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("AtYdagE");

		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		String actMangerPTitle = driver.getTitle();
		System.out.println(actMangerPTitle);
		
		String expManagerPTitle = "Guru99 Bank Manager HomePage";
		
		Assert.assertTrue(actMangerPTitle.contains(expManagerPTitle), "successfully logged in");
		test.log(Status.PASS, "verified manager login page title: "+actMangerPTitle);
		
		
	}
	
}
