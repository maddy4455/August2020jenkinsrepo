package MyMavenDemo.MavenDemo;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import baseClass.BaseTest;

import org.testng.annotations.Parameters;
import org.openqa.selenium.By;

public class TC_004 extends BaseTest {

	@Test(groups = { "Regression", "sanity" })
	@Parameters("browser")
	public void RadioButtonFB(String bType) {

		openBrowser(bType);
		test.log(Status.INFO, "launching browser " + bType);

		driver.get("https://www.facebook.com/");
		String url = driver.getCurrentUrl();
		test.log(Status.INFO, "Navigating url " + url);

		driver.findElement(By.id("u_0_7")).click();
		test.log(Status.INFO, "find the login button and clicked");
		
		driver.findElement(By.xpath("//button[@id='u_0_12']")).click();
		test.log(Status.INFO, "clicked on Sign Up button");
		
	
	}

}
