package MyMavenDemo.MavenDemo;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseTest;

public class SwitchWindowsTest_003 extends BaseTest {

	@Test
	public void switchTest2() throws Exception {

		openBrowser("chrome");

		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");

		String parentWindow = driver.getWindowHandle();
		System.out.println("parent window id is :- " + parentWindow);

		driver.findElement(By.xpath("//div[@id='post-body-6170641642826198246']//a[1]")).click();
		driver.findElement(By.xpath("//div[@id='post-body-6170641642826198246']//a[2]")).click();
		driver.findElement(By.xpath("//div[@id='post-body-6170641642826198246']//a[3]")).click();

		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total windows :- " + count);

		ArrayList tabs = new ArrayList<>(allWindows);

		driver.switchTo().window((String) tabs.get(2));
		System.out.println("2 window title is " + driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("hello world");

		Thread.sleep(2000);
		
	}

	@Test(dependsOnMethods = "switchTest2")
	public void switchTest3() throws Exception {

		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total windows :- " + count);
		ArrayList tabs = new ArrayList<>(allWindows);
		
		driver.switchTo().window((String) tabs.get(1));

		System.out.println("1 window title is " + driver.getTitle());
		WebElement searchBox = driver.findElement(By.cssSelector("input#header-search-input"));
		searchBox.sendKeys("inception");
		searchBox.submit();
	//	driver.findElement(By.xpath("//i[@class='Fz(26px) Mstart(2px) Icon-Fp2 IconNavSearch Icon-Fp2']")).click();

		Thread.sleep(2000);
		
	}

	@Test(dependsOnMethods = "switchTest3")
	public void switchTest4() throws Exception {
		
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total windows :- " + count);
		ArrayList tabs = new ArrayList<>(allWindows);

		driver.switchTo().window((String) tabs.get(3));
		System.out.println("3 window title is " + driver.getTitle());
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("ileana");
		driver.findElement(By.xpath("//div[@class='hpuQDe']//*[local-name()='svg']")).click();

		Thread.sleep(2000);
		
	}

	@Test(dependsOnMethods = "switchTest4")
	public void switchTest5() throws Exception {
		
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total windows :- " + count);
		ArrayList tabs = new ArrayList<>(allWindows);

		driver.switchTo().window((String) tabs.get(0));

		System.out.println("Parent window title is " + driver.getTitle());
		driver.findElement(By.xpath("//a[@class='profile-link']")).click();

		Thread.sleep(2000);
		

	}
}
