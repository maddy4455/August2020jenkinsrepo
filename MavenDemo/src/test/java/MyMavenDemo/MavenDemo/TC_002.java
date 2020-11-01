package MyMavenDemo.MavenDemo;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import baseClass.BaseTest;

public class TC_002 extends BaseTest {

	@Test(groups = { "Regression", "sanity" })
	@Parameters("browser")
	public void Demo_Test(String bType) {

		openBrowser(bType);
		test.log(Status.INFO, "launching browser " + bType);

		driver.get("https://www.amazon.in/");
		String url = driver.getCurrentUrl();
		test.log(Status.INFO, "navigating url " + url);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry potter");
		test.log(Status.INFO, "find the element and enterd the text in text box");

		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
		test.log(Status.INFO, "clicking on search button");

		driver.findElement(By.xpath("//span[contains(text(),'Harry Potter Box')]")).click();
		test.log(Status.INFO, "find the serch button and clicked");

	}

}
