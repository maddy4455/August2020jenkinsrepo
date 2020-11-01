package MyMavenDemo.MavenDemo;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseClass.BaseTest;

public class SwitchWindowTest_002 extends BaseTest {
	@Test(priority=1)
	public void HandleWindow_Test() throws Exception {
		openBrowser("chrome");
		driver.get("https://www.hdfc.com/");

		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window id is :- " + parentWindow);

		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[18]/div[1]/div[1]/div[1]/button[1]")).click();

		driver.findElement(By.linkText("Apply For Home Loan")).click();

		Set<String> allWindows = driver.getWindowHandles();

		// to count how may windows are open
		int count = allWindows.size();
		System.out.println("Total windows :- " + count);

		for (String child : allWindows) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);

				System.out.println("Child window id is :- " + child);

				driver.findElement(By.xpath("//button[@class='btn-side']")).click();

				Thread.sleep(3000);
				
				driver.close();

			}
		}
		driver.switchTo().window(parentWindow);

		System.out.println("Parent window title is " + driver.getTitle());

		driver.findElement(By.linkText("Deposits")).click();
		
	}
		@Test(priority=2)
		public void HandleWindow2_Test() throws Exception {
			
			
			driver.navigate().back();
		
		
		
	}
}
