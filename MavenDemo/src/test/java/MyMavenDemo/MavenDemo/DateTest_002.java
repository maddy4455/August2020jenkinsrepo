package MyMavenDemo.MavenDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseClass.BaseTest;

public class DateTest_002 extends BaseTest {
	@Test
	public void Tc_002() throws Exception {

		String month = "Aug 2020";
		String month1 = "Sep 2020";

		openBrowser("firefox");

		driver.get("https://www.redbus.com/");

		// driver.navigate().refresh();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("hyderabad");

		driver.findElement(By.xpath("//li[@class='selected']")).click();

		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("shirdi");

		driver.findElement(By.xpath("//li[contains(text(),'Shirdi,Maharashtra,India')]")).click();

		driver.findElement(By.xpath("//label[@class='db text-trans-uc move-up']")).click();

		while (true) {

			Thread.sleep(2000);
			String text = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/table[1]/tbody[1]/tr[1]/td[2]"))
					.getText();
			if (text.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//button[contains(text(),'>')]"))
						.click();
			}
		}
		driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='wd day'][contains(text(),'28')]"))
				.click();

		Thread.sleep(2000);

		// second calender operation

		driver.findElement(By.xpath("//label[@class='db text-trans-uc tal']")).click();
		while (true) {
			Thread.sleep(2000);
			String text = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/table[1]/tbody[1]/tr[1]/td[2]"))
					.getText();
			if (text.equals(month1)) {
				break;
			} else {
				driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']//button[contains(text(),'>')]"))
						.click();
			}
		}

		driver.findElement(By.xpath("//td[@class='wd day'][contains(text(),'16')]")).click();

		driver.findElement(By.id("search_btn")).click();

		System.out.println("title is " + driver.getTitle());

	}
}
