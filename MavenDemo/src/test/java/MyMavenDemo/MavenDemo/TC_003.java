package MyMavenDemo.MavenDemo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;

import org.openqa.selenium.By;

public class TC_003 extends BaseTest {

	@Test(groups = { "Regression", "sanity" })
	@Parameters("browser")
	public void LinkTextFB(String bType) {

		openBrowser(bType);
		test.log(Status.INFO, "launching browser " + bType);

		driver.get("https://www.facebook.com/");

		String url = driver.getCurrentUrl();
		test.log(Status.INFO, "Navigating url " + url);

		driver.findElement(By.xpath("//input[@id='u_0_b']")).click();
		test.log(Status.INFO, "clicked the linkt text login and enterd into login page");
		
		driver.findElement(By.xpath("//a[contains(text(),'Forgot Pass')]")).click();
		test.log(Status.INFO, "clicking on forgor password link");
		
		String actmsg = driver.findElement(By.xpath("//div[contains(text(),'Please ent')]")).getAttribute("innerHTML");
		
		Assert.assertTrue(actmsg.contains("Please enter"), "error message generated as expexted");

	}
}
