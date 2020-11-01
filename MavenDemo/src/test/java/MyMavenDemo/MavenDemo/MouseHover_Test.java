package MyMavenDemo.MavenDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import baseClass.BaseTest;

public class MouseHover_Test extends BaseTest {
	@Test
	public void MouseDemo_Test() throws InterruptedException {

		openBrowser("chrome");

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");

		WebElement autoelement = driver.findElement(By.xpath("//button[@class='dropbtn']"));

		Actions act = new Actions(driver);

		act.moveToElement(autoelement).perform();

		List<WebElement> links = driver.findElements(By.xpath("//div[@class='dropdown-content']//a"));

		int total_count = links.size();

		for (int i = 0; i < total_count; i++) {
			WebElement element = links.get(i);

			String text = element.getAttribute("innerHTML");
			
			boolean status = element.isEnabled();

			System.out.println("links name is: " + text +"and the link status is: "+status);

			if (text.equalsIgnoreCase("TestNG")) {

				element.click();
				break;

			}

		}

	}
}
