package MyMavenDemo.MavenDemo;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseClass.BaseTest;

public class DateTest_002 extends BaseTest {
	@Test
	public void Tc_002() throws Exception {

		String month = "Dec 2020";
		String month1 = "Feb 2021";

		openBrowser("chrome");

		driver.get("https://www.redbus.com/");
		driver.manage().deleteAllCookies();
		WebDriverWait wait=new WebDriverWait(driver, 20);

		WebElement from = driver.findElement(By.xpath("//input[@id='src']"));
		from.sendKeys("Hyderabad");
		from.sendKeys(Keys.ENTER);

		WebElement to = driver.findElement(By.xpath("//input[@id='dest']"));
		to.sendKeys("Shiridi");
		to.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//label[contains(text(),'Onward Date')]")).click();

		while (true) {

			Thread.sleep(2000);
			String text = driver.findElement(By.cssSelector("td[class='monthTitle']")).getAttribute("innerHTML");

			if (text.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//button[contains(text(),'>')]"))
						.click();
			}
		}
		driver.findElement(By.xpath("//body[1]/div[5]/table[1]/tbody[1]/tr[4]/td[4]")).click();

		Thread.sleep(2000);

		// second calender operation

		driver.findElement(By.xpath("//label[@class='db text-trans-uc tal']")).click();
		while (true) {
			String text1 = driver.findElement(By.xpath("//body[1]/div[5]/table[1]/tbody[1]/tr[1]/td[2]"))
					.getAttribute("innerHTML");

			if (text1.equals(month1)) {
				break;
			} else {
				driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']//button[contains(text(),'>')]"))
						.click();
			}
		}

		driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']//td[@class='wd day'][contains(text(),'16')]"))
				.click();
       // Robot robot= new Robot();
       // robot.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.id("search_btn")).click();
		
			/*driver.findElement(By.xpath(
					"//body/section[@id='rh_main']/div[@id='mBWrapper']/div[@id='root']/div[1]/div[2]/div[2]/div[2]/ul[1]/div[1]/li[1]/div[1]/div[2]/div[1]"))
					.click();

			String actMsg = driver.findElement(By.xpath("//span[contains(text(),'Click on an Available seat to proceed with your tr')]")).getText();
		String expMsg = "Click on an Available seat to proceed with your transaction.";
		
		assertEquals(actMsg, expMsg);
		System.out.println("exp msg is:-"+actMsg);*/
			
}    
		
}
	

